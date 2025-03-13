package com.controller;

import com.common.dto.ApiResponse;
import com.domain.dto.PlaceDTO;
import com.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/places")
public class PlaceController {

    private final PlaceService placeService;


    /**
     * 장소 목록 조회
     * 등록한 장소 전체 정보를 조회할 수 있다.
     *
     * @return 성공시 장소 목록 응답
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<PlaceDTO>>> getPlaces() {
        List<PlaceDTO> places = placeService.getPlaces();
        return ResponseEntity.ok(ApiResponse.success(places));
    }

    /**
     * 장소 단건 조회
     * 등록한 장소 정보를 조회할 수 있다.
     *
     * @param id 필수여부 : 0
     * @return 성공시 id 대상 장소 응답
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<PlaceDTO>> getPlaceById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ApiResponse.success(placeService.getPlaceById(id)));
    }

    /**
     * 장소 등록
     * 장소를 등록할 수 있다.
     *
     * @param place
     * @return
     */
    @PostMapping
    public ResponseEntity<ApiResponse<PlaceDTO>> addPlace(@RequestBody PlaceDTO place) {
        placeService.addPlace(place);
        return ResponseEntity.noContent().build();
    }

    /**
     * 장소 수정
     * 장소 정보를 수정할 수 있다.
     *
     * @param id
     * @param place
     * @return
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<PlaceDTO>> updatePlace(@PathVariable Long id, @RequestBody PlaceDTO place) {
        placeService.updatePlace(id, place);
        return ResponseEntity.ok(ApiResponse.success(placeService.getPlaceById(id)));
    }

    /**
     * 장소 삭제
     * 장소 정보를 삭제할 수 있다.
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<PlaceDTO>> deletePlace(@PathVariable Long id) {
        placeService.deletePlace(id);
        return ResponseEntity.noContent().build();
    }
}
