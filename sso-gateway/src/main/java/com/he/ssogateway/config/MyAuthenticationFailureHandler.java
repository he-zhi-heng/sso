package com.he.ssogateway.config;

import lombok.Data;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author root
 */
@Data
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private  String url;
    private boolean isRedirect;

    public MyAuthenticationFailureHandler(String url, boolean isRedirect) {
        this.url = url;
        this.isRedirect = isRedirect;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (isRedirect){
            response.sendRedirect(url);
        }else {
            request.getRequestDispatcher(url).forward(request,response);
        }
    }
}
