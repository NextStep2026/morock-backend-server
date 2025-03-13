package com.domain.dto;


import com.domain.entity.PlaceEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDTO {

    private Long placeId;                // 장소 ID
    private String placeName;            // 장소명
    private Double latitude;        // 위도
    private Double longitude;       // 경도
    private String description;            // 설명
    private Long registeredById;    // 등록자 ID (앱회원 테이블 id)
    private LocalDateTime createdAt; // 등록일
    private LocalDateTime updatedAt; // 수정일


    // 정적 팩토리 메서드 (of)
    public static PlaceDTO of(Long placeId, String name, Double latitude, Double longitude, String description, Long registeredById, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new PlaceDTO(placeId, name, latitude, longitude, description, registeredById, createdAt, updatedAt);
    }

    // 엔티티 -> DTO 변환 메서드 (fromEntity)
    public static PlaceDTO fromEntty(PlaceEntity entity) {
        return new PlaceDTO(
                entity.getPlaceId(),
                entity.getPlaceName(),
                entity.getLatitude(),
                entity.getLongitude(),
                entity.getDescription(),
                entity.getRegisteredById(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
