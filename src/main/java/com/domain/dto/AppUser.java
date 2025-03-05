package com.domain.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser {

    private Long userId;
    private String userLoginId;
    private String userPassword;
    private String userEmail;
    private String googleAccount;
    private String kakaoAccount;
    private String naverAccount;
    private String appleAccount;
    private String name;
    private LocalDateTime birthDate;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
