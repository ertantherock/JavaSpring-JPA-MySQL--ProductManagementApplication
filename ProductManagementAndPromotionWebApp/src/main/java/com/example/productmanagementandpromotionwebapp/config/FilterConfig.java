package com.example.productmanagementandpromotionwebapp.config;

import com.example.productmanagementandpromotionwebapp.entities.User;
import com.example.productmanagementandpromotionwebapp.repositories.UserRepository;
import com.example.productmanagementandpromotionwebapp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RequiredArgsConstructor
public class FilterConfig implements Filter {

    final UserService userService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String url = req.getRequestURI();
        String freeUrls[] = {"/loginPage", "/registerPage"};

        boolean loginStatus = true;

        for (String item : freeUrls) {
            if (url.equals(item)) {
                loginStatus = false;
                break;
            }
        }

        if (loginStatus) {
            //SessionControl
            boolean status = req.getSession().getAttribute("user") == null;

            if (status) {
                // redirect Login
                res.sendRedirect("/loginPage");
            } else {
                User u = (User) req.getSession().getAttribute("user");

                req.setAttribute("user", u);
                chain.doFilter(req, res);
            }
        } else {

            chain.doFilter(req, res);
        }

    }

}

