package com.controller;


import com.common.dto.ApiResponse;
import com.domain.dto.AppUser;
import com.domain.dto.LoginRequest;
import com.domain.dto.LoginResponse;
import com.domain.entity.AppUserEntity;
import com.security.JwtTokenProvider;
import com.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AppUserService appUserService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody LoginRequest request) {
        AppUser appUser = appUserService.getAppUserByLoginId(request.getUserLoginId());


        if (!passwordEncoder.matches(request.getUserPassword(), appUser.getUserPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        // JWT 발급
        String token = jwtTokenProvider.createToken(appUser.getUserId());

        // 응답 데이터 구성
        LoginResponse response = LoginResponse.builder()
                .userId(appUser.getUserId())
                .userLoginId(appUser.getUserLoginId())
                .token(token)
                .build();

        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
