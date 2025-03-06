package com.security;

import com.domain.entity.AppUserEntity;
import com.domain.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUserEntity userEntity = appUserRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));

        // 🔥 기존 방식 - 여기서 필요한 정보 다 넘김
        return new CustomUserPrincipal(
                userEntity.getUserEmail(),
                userEntity.getUserPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")), // 필요 시 변경 가능
                userEntity.getUserId()
        );
    }

    public UserDetails loadUserById(Long userId) {
        AppUserEntity userEntity = appUserRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + userId));

        return new CustomUserPrincipal(
                userEntity.getUserEmail(),
                userEntity.getUserPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")), // 필요 시 권한 로직 변경 가능
                userEntity.getUserId()
        );
    }
}
