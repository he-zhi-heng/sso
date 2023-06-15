package com.he.auth.filter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSON;
import com.he.commons.enums.StateCode;
import com.he.commons.result.JsonResult;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author hemoren
 */
public class JwtAuthFilter extends OncePerRequestFilter {
    /**
     * JWT数据的密钥
     */
    private String secretKey = "fgfdsfadsfadsafdsafdsfadsfadsfdsafdasfdsafdsafdsafds4rttrefds";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("JwtAuthenticationFilter.doFilterInternal()");
        // 清除Spring Security上下文中的数据
        // 避免此前曾经存入过用户信息，后续即使没有携带JWT，在Spring Security仍保存有上下文数据（包括用户信息）
        System.out.println("清除Spring Security上下文中的数据");
        SecurityContextHolder.clearContext();
        // 客户端提交请求时，必须在请求头的Authorization中添加JWT数据，这是当前服务器程序的规定，客户端必须遵守
        // 尝试获取JWT数据
        String jwt = request.getHeader("Authorization");
        System.out.println("从请求头中获取到的JWT=" + jwt);
        // 判断是否不存在jwt数据
        if (!StringUtils.hasText(jwt)) {
            // 不存在jwt数据，则放行，后续还有其它过滤器及相关组件进行其它的处理，例如未登录则要求登录等
            // 此处不宜直接阻止运行，因为“登录”、“注册”等请求本应该没有jwt数据
            System.out.println("请求头中无JWT数据，当前过滤器将放行");
            filterChain.doFilter(request, response); // 继续执行过滤器链中后续的过滤器
            return; // 必须
        }

        // 注意：此时执行时，如果请求头中携带了Authentication，日志中将输出，且不会有任何响应，因为当前过滤器尚未放行
        // 以下代码有可能抛出异常的
        // TODO 密钥和各个Key应该统一定义
        String username = null;
        String permissionsString = null;
        try {
            System.out.println("请求头中包含JWT，准备解析此数据……");
            Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt).getBody();
            username = claims.get("username").toString();
            permissionsString = claims.get("permissions").toString();
            System.out.println("username=" + username);
            System.out.println("permissionsString=" + permissionsString);
        } catch (ExpiredJwtException e) {
            System.out.println("解析JWT失败，此JWT已过期：" + e.getMessage());
            JsonResult<Void> jsonResult = JsonResult.failed(
                    StateCode.ERR_JWT_EXPIRED, "您的登录已过期，请重新登录！");
            String jsonString = JSON.toJSONString(jsonResult);
            System.out.println("响应结果：" + jsonString);
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().println(jsonString);
            return;
        } catch (MalformedJwtException e) {
            System.out.println("解析JWT失败，此JWT数据错误，无法解析：" + e.getMessage());
            JsonResult<Void> jsonResult = JsonResult.failed(StateCode.ERR_JWT_MALFORMED, "获取登录信息失败，请重新登录！");
            String jsonString = JSON.toJSONString(jsonResult);
            System.out.println("响应结果：" + jsonString);
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().println(jsonString);
            return;
        } catch (SignatureException e) {
            System.out.println("解析JWT失败，此JWT签名错误：" + e.getMessage());
            JsonResult<Void> jsonResult = JsonResult.failed(
                    StateCode.ERR_JWT_SIGNATURE, "获取登录信息失败，请重新登录！");
            String jsonString = JSON.toJSONString(jsonResult);
            System.out.println("响应结果：" + jsonString);
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().println(jsonString);
            return;
        } catch (Throwable e) {
            System.out.println("解析JWT失败，异常类型：" + e.getClass().getName());
            e.printStackTrace();
            JsonResult<Void> jsonResult = JsonResult.failed(
                    StateCode.SERVER_ERROR, "获取登录信息失败，请重新登录！");
            String jsonString = JSON.toJSONString(jsonResult);
            System.out.println("响应结果：" + jsonString);
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().println(jsonString);
            return;
        }

        // 将此前从JWT中读取到的permissionsString（JSON字符串）转换成Collection<? extends
        // GrantedAuthority>
        List<SimpleGrantedAuthority> permissions = JSON.parseArray(permissionsString, SimpleGrantedAuthority.class);
        System.out.println("从JWT中获取到的权限转换成Spring Security要求的类型：" + permissions);
        // 将解析得到的用户信息传递给Spring Security
        // 获取Spring Security的上下文，并将Authentication放到上下文中
        // 在Authentication中封装：用户名、null（密码）、权限列表
        // 因为接下来并不会处理认证，所以Authentication中不需要密码
        // 后续，Spring Security发现上下文中有Authentication时，就会视为已登录，甚至可以获取相关信息
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, permissions);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("将解析得到的用户信息传递给Spring Security");
        // 放行
        System.out.println("JwtAuthenticationFilter 放行");
        filterChain.doFilter(request, response);
    }
}
