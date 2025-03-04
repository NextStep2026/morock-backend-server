package com.service;

import com.domain.dto.AppUser;
import com.domain.entity.AppUserEntity;
import com.domain.repository.AppUserRepository;
import com.mapper.AppUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;
    /**
     * 엡 회원 다건 조회
     * 엡 회원 목록을 검색조건에 맞게 조회 할 수 있다
     *
     * @return 성공시 엡 회원 목록 응답
     */
    @Transactional(readOnly = true)
    public List<AppUser> getAppUsers() {
        return appUserRepository.findAll().stream()
                .map(AppUserMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * 엡 회원 단건 조회
     * 엡 회원을 조회 할 수 있다.
     *
     * @param id 필수여부 : O
     * @return 성공시 id 대상 엡 회원 응답
     */
    @Transactional(readOnly = true)
    public AppUser getAppUserById(Long id) {
        return appUserRepository.findById(id)
                .map(AppUserMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다 ID: " + id));
    }
    /**
     * 엡 회원 등록
     * 엡 회원 정보를 등록 할 수 있다.
     *
     * @param appUser 회원정보
     * @return 성공 여부 응답
     */
    @Transactional
    public void addAppUser(AppUser appUser) {
        AppUserEntity entity = AppUserMapper.toEntity(appUser);
        AppUserEntity savedEntity = appUserRepository.save(entity);
        AppUserMapper.toDto(savedEntity);
    }
    /**
     * 엡 회원 수정
     * 엡 회원 정보를 수정 할 수 있다.
     *
     * @param id 수정대상, 필수여부 : O
     * @param appUser 수정 정보
     */
    @Transactional
    public void updateAppUser(Long id, AppUser appUser) {
        AppUserEntity existingUser = appUserRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다 ID: " + id));
        AppUserMapper.updateEntityFromDto(existingUser, appUser);
        AppUserEntity updatedUser = appUserRepository.save(existingUser);
        AppUserMapper.toDto(updatedUser);
    }

    /**
     * 엡 회원 삭제
     * 엡 회원을 삭제 할 수 있다.
     * 삭제시 논리 삭제 또는 테이블 이관
     *
     * @param id 삭제대상, 필수여부 : O
     */
    @Transactional
    public void deleteAppUser(Long id) {
        appUserRepository.deleteById(id);
    }


    /**
     * 로그인 ID로 회원 단건 조회
     * 로그인 ID로 회원 정보를 조회 할 수 있다
     * @param loginId 로그인 ID
     * @return 성공 여부 응답
     */
    @Transactional(readOnly = true)
    public AppUser getAppUserByLoginId(String loginId) {
        return appUserRepository.findByUserLoginId(loginId)
                .map(AppUserMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("User not found with loginId: " + loginId));
    }
}
