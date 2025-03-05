package com.security;

import com.service.ClubPermissionService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class PermissionCheckAspect {

    private final ClubPermissionService clubPermissionService;

    /**
     * CheckPermission 어노테이션이 붙은 메서드 실행 전 권한 체크
     */
    @Before("@annotation(checkPermission) && args(clubId, ..)")
    public void checkPermission(CheckPermission checkPermission, Long clubId) {
        Long userId = getCurrentUserId();

        String permissionKey = checkPermission.permissionKey();

        boolean hasPermission = clubPermissionService.hasPermission(clubId, userId, permissionKey);

        if (!hasPermission) {
            throw new AccessDeniedException("권한이 없습니다: " + permissionKey);
        }
    }

    private Long getCurrentUserId() {
        CustomUserPrincipal principal = (CustomUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getUserId();
    }
}
