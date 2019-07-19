package pl.marcin;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, pattern = "/login"))
public class LoginFilter implements Filter{



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpSession session = httpServletRequest.getSession();
        String path = ((HttpServletRequest) req).getServletPath();
        if (session.getAttribute("loggedUser") == null && !path.contains("/login")){
             HttpServletResponse response = (HttpServletResponse) resp;
            response.sendRedirect("/login");

        } else {
            chain.doFilter(req, resp);
        }


    }

    @Override
    public void destroy() {

    }
}
