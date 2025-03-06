package com.domain.repository;

import com.domain.entity.ClubMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClubMemberRepository extends JpaRepository<ClubMemberEntity, Long> {


    Long findRankIdByClubIdAndUserId(Long clubId, Long userId);
}
