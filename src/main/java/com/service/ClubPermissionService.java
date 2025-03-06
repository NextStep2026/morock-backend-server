package com.service;

import com.domain.repository.ClubMemberRepository;
import com.domain.repository.ClubRankPermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClubPermissionService {

    private final ClubMemberRepository clubMemberRepository;
    private final ClubRankPermissionRepository clubRankPermissionRepository;

    /**
     * 모임별 기능 권한 체크
     *
     * @param clubId 모임ID
     * @param userId 사용자ID
     * @param permissionKey 확인할 권한키 (ex: POST_CREATE)
     * @return 권한 여부 (true: 허용, false: 거부)
     */
    public boolean hasPermission(Long clubId, Long userId, String permissionKey) {
        // 1. 해당 모임의 회원이 갖고 있는 랭크 조회
        Long rankId = clubMemberRepository.findRankIdByClubIdAndUserId(clubId, userId);

        if (rankId == null) {
            // 모임에 가입되어 있지 않으면 권한 없음
            return false;
        }

        // 2. 해당 랭크가 해당 권한을 갖고 있는지 조회
        return clubRankPermissionRepository.existsByClubIdAndRankIdAndPermissionKey(clubId, rankId, permissionKey);
    }
}
