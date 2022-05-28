package com.example.demo.audit;

import com.example.demo.userDetail.MyUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class AuditorAware implements org.springframework.data.domain.AuditorAware {

    public Optional getCurrentAuditor() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication==null || !authentication.isAuthenticated()){
            return null;
        }
        return Optional.ofNullable(authentication.getName());
    }
}
