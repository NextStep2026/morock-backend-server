package com.service;

import com.domain.dto.ClubMember;
import com.domain.entity.ClubMemberEntity;
import com.domain.repository.ClubMemberRepository;
import com.mapper.ClubMemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClubMemberService {


    private final ClubMemberRepository clubMemberRepository;
    /**
     * 모임 회원 다건 조회
     * 모임 회원의 목록을 조건에 따라 조회 할 수 있다.
     *
     * @return 성공시 모임 회원 목록 응답
     */
    @Transactional(readOnly = true)
    public List<ClubMember> getClubMembers() {
        return clubMemberRepository.findAll().stream()
                .map(ClubMemberMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * 모임 회원 단건 조회
     * 모임 회원을 조회 할 수 있다.
     *
     * @param clubMemberId 필수여부 : O
     * @return 성공시 id 대상 모임 회원 응답
     */
    @Transactional(readOnly = true)
    public ClubMember getClubMemberById(Long clubMemberId) {
        return clubMemberRepository.findById(clubMemberId)
                .map(ClubMemberMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 모임원입니다 ID: " + clubMemberId));
    }
    /**
     * 모임 가입
     * 엡 회원이 모임에 가입 할 수 있다.
     *
     * @param clubMember 회원정보
     */
    @Transactional
    public void addClubMember(ClubMember clubMember) {
        ClubMemberEntity entity = ClubMemberMapper.toEntity(clubMember);
        ClubMemberEntity savedEntity = clubMemberRepository.save(entity);
        ClubMemberMapper.toDto(savedEntity);
    }
    /**
     * 모임 회원 정보 수정
     * 모임 회원 정보를 수정 할 수 있다.
     *
     * @param clubMemberId 수정대상, 필수여부 : O
     * @param clubMember 수정 정보
     */
    @Transactional
    public void updateClubMember(Long clubMemberId, ClubMember clubMember) {
        ClubMemberEntity existingUser = clubMemberRepository.findById(clubMemberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 모임원입니다 ID: " + clubMemberId));
        ClubMemberMapper.updateEntityFromDto(existingUser, clubMember);
        ClubMemberEntity updatedUser = clubMemberRepository.save(existingUser);
        ClubMemberMapper.toDto(updatedUser);
    }
    /**
     * 모임원 삭제
     * 모임원을 삭제 할 수 있다.(delFlg?)
     *
     * @param clubMemberId 삭제대상, 필수여부 : O
     */
    @Transactional
    public void deleteClubMember(Long clubMemberId) {
        clubMemberRepository.deleteById(clubMemberId);
    }
}
