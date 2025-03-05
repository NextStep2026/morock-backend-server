package com.domain.repository;

import com.domain.entity.ClubRankPermission;
import com.domain.id.ClubRankPermissionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRankPermissionRepository extends JpaRepository<ClubRankPermission, ClubRankPermissionId> {

    boolean existsByClubIdAndRankIdAndPermissionKey(Long clubId, Long rankId, String permissionKey);
}
