package com.service;

import com.security.CustomUserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ClubService {
    public void setCurrentClubId(Long clubId) {
        CustomUserPrincipal principal = (CustomUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        principal.setCurrentClubId(clubId);
    }
}
