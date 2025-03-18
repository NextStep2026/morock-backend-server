package com.mapper;

import com.domain.dto.ClubMember;
import com.domain.entity.ClubMemberEntity;

public class ClubMemberMapper {

    public static ClubMemberEntity toEntity(ClubMember dto) {
        if (dto == null) return null;
        return ClubMemberEntity.builder()
                .clubMemberId(dto.getClubMemberId())
                .clubId(dto.getClubId())
                .joinedAt(dto.getJoinedAt())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }

    public static ClubMember toDto(ClubMemberEntity entity) {
        if (entity == null) return null;
        return ClubMember.builder()
                .clubMemberId(entity.getClubMemberId())
                .clubId(entity.getClubId())
                .joinedAt(entity.getJoinedAt())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static void updateEntityFromDto(ClubMemberEntity entity, ClubMember dto) {
        entity.setClubMemberId(dto.getClubMemberId());
        entity.setClubId(dto.getClubId());
        entity.setJoinedAt(dto.getJoinedAt());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
    }
}
