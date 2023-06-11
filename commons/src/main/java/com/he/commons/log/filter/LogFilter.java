package com.he.commons.log.filter;

import org.slf4j.MDC;
import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

/**
 * @author hemoren
 */
public class LogFilter implements Filter {
    private static final String UNIQUE_ID_NAME = "traceId";
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        MDC.put(UNIQUE_ID_NAME, UUID.randomUUID().toString().replace("-", ""));
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.remove(UNIQUE_ID_NAME);
        }
    }
}
