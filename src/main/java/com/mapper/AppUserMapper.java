package com.mapper;

import com.domain.dto.AppUser;
import com.domain.entity.AppUserEntity;

public class AppUserMapper {

    public static AppUserEntity toEntity(AppUser dto) {
        if (dto == null) return null;
        return AppUserEntity.builder()
                .userId(dto.getUserId())
                .userLoginId(dto.getUserLoginId())
                .userPassword(dto.getUserPassword())
                .userEmail(dto.getUserEmail())
                .googleAccount(dto.getGoogleAccount())
                .kakaoAccount(dto.getKakaoAccount())
                .naverAccount(dto.getNaverAccount())
                .appleAccount(dto.getAppleAccount())
                .name(dto.getName())
                .birthDate(dto.getBirthDate())
                .phoneNumber(dto.getPhoneNumber())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }

    public static AppUser toDto(AppUserEntity entity) {
        if (entity == null) return null;
        return AppUser.builder()
                .userId(entity.getUserId())
                .userLoginId(entity.getUserLoginId())
                .userPassword(entity.getUserPassword())
                .userEmail(entity.getUserEmail())
                .googleAccount(entity.getGoogleAccount())
                .kakaoAccount(entity.getKakaoAccount())
                .naverAccount(entity.getNaverAccount())
                .appleAccount(entity.getAppleAccount())
                .name(entity.getName())
                .birthDate(entity.getBirthDate())
                .phoneNumber(entity.getPhoneNumber())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static void updateEntityFromDto(AppUserEntity entity, AppUser dto) {
        entity.setUserLoginId(dto.getUserLoginId());
        entity.setUserPassword(dto.getUserPassword());
        entity.setUserEmail(dto.getUserEmail());
        entity.setGoogleAccount(dto.getGoogleAccount());
        entity.setKakaoAccount(dto.getKakaoAccount());
        entity.setNaverAccount(dto.getNaverAccount());
        entity.setAppleAccount(dto.getAppleAccount());
        entity.setName(dto.getName());
        entity.setBirthDate(dto.getBirthDate());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setUpdatedAt(dto.getUpdatedAt());
    }
}
