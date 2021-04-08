package com.example.xiaochun.jwt;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final PathMatcher pathMather = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            if (isProtectedUrl(request)) {
                if (!request.getMethod().equals("OPTIONS")) {
                    request = JwtUtil.validateTokenAndAddUserIdToHeader(request);
                }
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return;
        }
        filterChain.doFilter(request, response);
    }

    private boolean isProtectedUrl(HttpServletRequest request) {
        List<String> protectedPaths = new ArrayList<String>();
        protectedPaths.add("/sm/user/info");
        boolean bFind = false;
        for (String passPath : protectedPaths) {
            bFind = pathMather.match(passPath, request.getServletPath());
            if  (bFind)  {
                break;
            }
        }
        return bFind;
    }
}
