package com.domain.repository.impl;


import com.domain.repository.ClubMemberRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ClubMemberRepositoryImpl implements ClubMemberRepositoryCustom {
    @Override
    public Long findRankIdByClubIdAndUserId(Long clubId, Long userId) {
        return null;
    }

//
//    private final JPAQueryFactory queryFactory;
//
//    @Override
//    public Long findRankIdByClubIdAndUserId(Long clubId, Long userId) {
//        return queryFactory
//                .select(clubMemberEntity.rankId)
//                .from(clubMemberEntity)
//                .where(
//                        clubMemberEntity.clubId.eq(clubId),
//                        clubMemberEntity.userId.eq(userId)
//                )
//                .fetchOne();
//    }
}