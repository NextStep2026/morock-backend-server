package com.domain.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_user", schema = "public")
public class AppUserEntity {

    // 회원 고유 ID (PK)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    // 로그인 ID
    @Column(name = "user_login_id", nullable = false, unique = true, length = 30)
    private String userLoginId;

    // 비밀번호
    @Column(name = "user_password", nullable = false, length = 100)
    private String userPassword;

    // 이메일
    @Column(name = "user_email", length = 30)
    private String userEmail;

    // 구글 계정 연동 정보
    @Column(name = "google_account", length = 30)
    private String googleAccount;

    // 카카오 계정 연동 정보
    @Column(name = "kakao_account", length = 30)
    private String kakaoAccount;

    // 네이버 계정 연동 정보
    @Column(name = "naver_account", length = 30)
    private String naverAccount;

    // 애플 계정 연동 정보
    @Column(name = "apple_account", length = 30)
    private String appleAccount;

    // 회원 이름
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    // 회원 생년월일
    @Column(name = "birth_date")
    private LocalDate birthDate;

    // 회원 전화번호
    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    // 생성일
    @Column(name = "created_at")
    private LocalDate createdAt;

    // 수정일
    @Column(name = "updated_at")
    private LocalDate updatedAt;


}
