package com.controller;

import com.common.dto.ApiResponse;
import com.domain.dto.AppUser;
import com.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/app_user")
public class AppUserController {

    private final AppUserService appUserService;

    /**
     * 엡 회원 다건 조회
     * 엡 회원 목록을 검색조건에 맞게 조회 할 수 있다
     *
     * @return 성공시 엡 회원 목록 응답
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<AppUser>>> getAppUsers() {
        List<AppUser> users = appUserService.getAppUsers();
        return ResponseEntity.ok(ApiResponse.success(users));
    }

    /**
     * 엡 회원 단건 조회
     * 엡 회원을 조회 할 수 있다.
     *
     * @param id 필수여부 : O
     * @return 성공시 id 대상 엡 회원 응답
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<AppUser>> getAppUserById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(appUserService.getAppUserById(id)));
    }

    /**
     * 엡 회원 등록
     * 엡 회원 정보를 등록 할 수 있다.
     *
     * @param appUser 회원정보
     * @return 성공 여부 응답
     */
    @PostMapping
    public ResponseEntity<ApiResponse<AppUser>> addAppUser(@RequestBody AppUser appUser) {
        appUserService.addAppUser(appUser);
        return ResponseEntity.noContent().build();
    }

    /**
     * 엡 회원 수정
     * 엡 회원 정보를 수정 할 수 있다.
     *
     * @param id 수정대상, 필수여부 : O
     * @param appUser 수정 정보
     * @return 성공 여부 응답
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<AppUser>> updateAppUser(@PathVariable Long id, @RequestBody AppUser appUser) {
        appUserService.updateAppUser(id, appUser);
        return ResponseEntity.ok(ApiResponse.success(appUserService.getAppUserById(id)));
    }

    /**
     * 엡 회원 삭제
     * 엡 회원을 삭제 할 수 있다.
     * 삭제시 논리 삭제 또는 테이블 이관
     *
     * @param id 삭제대상, 필수여부 : O
     * @return 성공 여부 응답
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<AppUser>> deleteAppUser(@PathVariable Long id) {
        appUserService.deleteAppUser(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * 로그인 ID로 회원 단건 조회
     * 로그인 ID로 회원 정보를 조회 할 수 있다
     * @param loginId 로그인 ID
     * @return 성공 여부 응답
     */
    @GetMapping("/login-id/{loginId}")
    public ResponseEntity<ApiResponse<AppUser>> getAppUserByLoginId(@PathVariable String loginId) {
        AppUser user = appUserService.getAppUserByLoginId(loginId);
        return ResponseEntity.ok(ApiResponse.success(user));
    }
}
