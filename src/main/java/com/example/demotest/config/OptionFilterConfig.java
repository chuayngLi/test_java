package com.example.demotest.config;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@WebFilter
public class OptionFilterConfig implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (((HttpServletRequest) servletRequest).getMethod().equals("OPTIONS")) {
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            httpResponse.setHeader("Access-Control-Allow-Origin", "*"); // 允许所有跨域地址
            httpResponse.setHeader("Access-Control-Allow-Headers", "*");
            httpResponse.setHeader("Access-Control-Allow-Methods", "*");
            httpResponse.addHeader("Access-Control-Max-Age", "3600");
            httpResponse.setStatus(200);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
