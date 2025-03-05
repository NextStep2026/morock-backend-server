package com.domain.repository;

public interface ClubMemberRepositoryCustom {
    Long findRankIdByClubIdAndUserId(Long clubId, Long userId);
}
