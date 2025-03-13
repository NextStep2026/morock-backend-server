package com.mapper;

import com.domain.dto.PlaceDTO;
import com.domain.entity.PlaceEntity;

public class PlaceMapper {

    public static PlaceEntity toEntity(PlaceDTO dto) {
        if (dto == null) return null;
        return PlaceEntity.builder()
                .placeId(dto.getPlaceId())
                .placeName(dto.getPlaceName())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .description(dto.getDescription())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }
}
