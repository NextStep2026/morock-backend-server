package com.service;

import com.domain.dto.PlaceDTO;
import com.domain.entity.PlaceEntity;
import com.domain.repository.PlaceRepository;
import com.mapper.PlaceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;


    @Transactional(readOnly = true)
    public List<PlaceDTO> getPlaces() {
        return placeRepository.findAll().stream()
                .map(PlaceDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PlaceDTO getPlaceById(Long id) {
        return placeRepository.findById(id)
                .map(PlaceDTO::fromEntity)
                .orElseThrow(() -> new IllegalArgumentException("저장하지 않은 장소입니다."));
    }

    @Transactional
    public void addPlace(PlaceDTO placeDTO) {
        PlaceEntity entity = PlaceMapper.toEntity(placeDTO);
        placeRepository.save(entity);
    }

    @Transactional
    public void updatePlace(Long id, PlaceDTO placeDTO) {
        PlaceEntity existingPlace = placeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("저장하지 않는 장소입니다."));
        PlaceEntity entity = PlaceMapper.toEntity(placeDTO);
        placeRepository.save(entity);
    }

    @Transactional
    public void deletePlace(Long id) {
        placeRepository.deleteById(id);
    }
}
