package com.domain.repository.impl;




import com.domain.repository.ClubMemberRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.domain.entity.QClubMemberEntity.clubMemberEntity;

@Repository
@RequiredArgsConstructor
public class ClubMemberRepositoryImpl implements ClubMemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Long findRankIdByClubIdAndUserId(Long clubId, Long userId) {
        return queryFactory
                .select(clubMemberEntity.rankId.rankId)
                .from(clubMemberEntity)
                .where(
                        clubMemberEntity.clubId.eq(clubId),
                        clubMemberEntity.userId.eq(userId)
                )
                .fetchOne();
    }
}
