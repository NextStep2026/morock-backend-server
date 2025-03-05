package com.domain.repository;

import com.domain.entity.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUserEntity, Long> {

    // 로그인 ID로 회원 단건 조회
    Optional<AppUserEntity> findByUserLoginId(String userLoginId);

    Optional<AppUserEntity> findByName(String username);
}
