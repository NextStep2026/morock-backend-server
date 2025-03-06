package com.security;

import com.domain.repository.ClubMemberRepository;
import com.domain.repository.ClubRankPermissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class PermissionCheckAspect {

    private final ClubMemberRepository clubMemberRepository;
    private final ClubRankPermissionRepository clubRankPermissionRepository;
    @Around("@annotation(clubPermissionCheck)")
    public Object checkPermission(ProceedingJoinPoint joinPoint,ClubPermissionCheck clubPermissionCheck) throws Throwable {
        CustomUserPrincipal principal = (CustomUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = principal.getUserId();
        Long clubId = principal.getCurrentClubId();
        if (clubId == null) {
            throw new SecurityException("현재 선택된 클럽이 없습니다.");
        }

        Long rankId = clubMemberRepository.findRankIdByClubIdAndUserId(clubId, userId);

        if (rankId == null) {
            throw new SecurityException("해당 클럽에 대한 접근 권한이 없습니다.");
        }

        String requiredPermission = clubPermissionCheck.permission();
        if (!hasPermission(clubId, rankId, requiredPermission)) {
            throw new SecurityException("해당 기능에 대한 권한이 없습니다.");
        }
        return joinPoint.proceed();
    }
    private boolean hasPermission(Long clubId, Long rankId, String permissionKey) {
        // club_rank_permission 테이블에서 존재 여부 확인
        return clubRankPermissionRepository.existsByClubIdAndRankIdAndPermissionKey(clubId, rankId, permissionKey);
    }
}
