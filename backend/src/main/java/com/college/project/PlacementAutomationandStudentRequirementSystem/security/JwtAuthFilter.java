package com.college.project.PlacementAutomationandStudentRequirementSystem.security;

import com.college.project.PlacementAutomationandStudentRequirementSystem.user.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthFilter extends OncePerRequestFilter {
    private final UserRepository userRepository;

    private final CostumeUserDetailsService userDetailsService;
    private final AuthUtil authUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("incoming requests {}", request.getPathInfo());

        // separate header from token
        final String requestTokenHeader = request.getHeader("Authorization");

        // token is valid or not
        if (requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer ")) {
            // if not -->
            filterChain.doFilter(request, response);        // > push forward into filterChain
            return;
        }
        // split token from header and store in jwtToken
        String jwtToken = requestTokenHeader.split("Bearer ")[1];
        try {
            //get username form jwt token
            String userName = authUtil.getUserFromToken(jwtToken);

            // check user is valid or not and SecurityContextHolder is empty or not
            if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                //get userdetails from db
                CostumeUserDetails userDetails = (CostumeUserDetails) userDetailsService.loadUserByUsername(userName);

                if (authUtil.isTokenValid(jwtToken, userDetails)) {
                    // create UserNameAndPasswordAuthenticationToken
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    // fill security contextHolder with created token
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
        } catch (Exception e) {
            log.error("Exception occurred", e);
        }
        filterChain.doFilter(request, response);        // > push forward into filterChain

    }
}
