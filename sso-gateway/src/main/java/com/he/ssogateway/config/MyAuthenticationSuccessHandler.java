package com.he.ssogateway.config;

import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author root
 */
@Data
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private String url;
    private boolean isRedirect;

    public MyAuthenticationSuccessHandler(String url, boolean isRedirect) {
        this.url = url;
        this.isRedirect = isRedirect;
    }

    /**
     * @param request 请求对象 request.getRequestDispatcher.forward()
     * @param response 响应对象 response.sendRedirect()
     * @param authentication 用户认证成功后的对象。其中报换用户名权限结合，内容是
     *                       自定义UserDetailsService
     * */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (isRedirect){
            response.sendRedirect(url);
        }else {
            request.getRequestDispatcher(url).forward(request,response);
        }
    }


}
