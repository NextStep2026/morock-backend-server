package com.controller;

import com.common.dto.ApiResponse;
import com.domain.dto.ClubMember;
import com.service.ClubMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/club_user")
public class ClubMemberController {

    private final ClubMemberService clubMemberService;

    /**
     * 모임 회원 목록 조회
     * 모임 회원의 목록을 조건에 따라 조회 할 수 있다.
     *
     * @return 성공시 모임 회원 목록 응답
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<ClubMember>>> getClubUsers() {
        List<ClubMember> users = clubMemberService.getClubMembers();
        return ResponseEntity.ok(ApiResponse.success(users));
    }

    /**
     * 엡 회원 단건 조회
     * 엡 회원을 조회 할 수 있다.
     *
     * @param clubMemberId 필수여부 : O
     * @return 성공시 id 대상 엡 회원 응답
     */
    @GetMapping(value = "/{clubMemberId}")
    public ResponseEntity<ApiResponse<ClubMember>> getClubUserById(@PathVariable Long clubMemberId) {
        return ResponseEntity.ok(ApiResponse.success(clubMemberService.getClubMemberById(clubMemberId)));
    }

    /**
     * 엡 회원 등록
     * 엡 회원 정보를 등록 할 수 있다.
     *
     * @param clubMember 회원정보
     * @return 성공 여부 응답
     */
    @PostMapping
    public ResponseEntity<ApiResponse<ClubMember>> addClubMember(@RequestBody ClubMember clubMember) {
        clubMemberService.addClubMember(clubMember);
        return ResponseEntity.noContent().build();
    }

    /**
     * 엡 회원 수정
     * 엡 회원 정보를 수정 할 수 있다.
     *
     * @param id 수정대상, 필수여부 : O
     * @param clubMember 수정 정보
     * @return 성공 여부 응답
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<ClubMember>> updateClubMember(@PathVariable Long id, @RequestBody ClubMember clubMember) {
        clubMemberService.updateClubMember(id, clubMember);
        return ResponseEntity.ok(ApiResponse.success(clubMemberService.getClubMemberById(id)));
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
    public ResponseEntity<ApiResponse<ClubMember>> deleteClubMember(@PathVariable Long id) {
        clubMemberService.deleteClubMember(id);
        return ResponseEntity.noContent().build();
    }

}
