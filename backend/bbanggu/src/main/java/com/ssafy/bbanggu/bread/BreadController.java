package com.ssafy.bbanggu.bread;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/bread")
@RequiredArgsConstructor
public class BreadController {
	private final BreadService breadService;

	// 빵 정보 등록
	@PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> insertBread(
		@RequestPart("bread") String breadDtoJson,
		@RequestPart(value = "breadImage", required = false) MultipartFile file) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			BreadDTO breadDto = objectMapper.readValue(breadDtoJson, BreadDTO.class);
			System.out.println("mapper");
			Bread insertedBread = breadService.insertBread(breadDto, file);
			return ResponseEntity.ok("빵 등록 성공: ID = " + insertedBread.getBreadId());
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("빵 등록 실패");
		}
	}

	// 빵 정보 개별 조회
	@GetMapping("/{breadId}")
	public ResponseEntity<?> getBread(@PathVariable("breadId") long breadId) {
		try {
			BreadDTO breadDTO = breadService.getBread(breadId);
			if (breadDTO != null) {
				return ResponseEntity.ok(breadDTO);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("빵 정보를 찾을 수 없습니다.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류가 발생했습니다.");
		}
	}

	// 가게 빵 전체 조회
	@GetMapping("/bakery/{bakeryId}")
	public ResponseEntity<?> getBreadsByBakeryId(@PathVariable("bakeryId") long bakeryId) {
		try {
			List<BreadDTO> breadList = breadService.getBreadByBakeryId(bakeryId);

			if (breadList != null) {
				return ResponseEntity.ok(breadList);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("빵 정보를 찾을 수 없습니다.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류가 발생했습니다.");
		}
	}

	// 빵 정보 수정
	@PutMapping(value = "/{breadId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> updateBread(
		@PathVariable long breadId,
		@RequestPart("bread") String breadDtoJson,
		@RequestPart(value = "breadImage", required = false) MultipartFile file) {
		try {
			System.out.println("dto: " + breadDtoJson);
			// 기존 bread 삭제 처리
			breadService.deleteBread(breadId);
			// Json을 BreadDTO로 변환
			ObjectMapper objectMapper = new ObjectMapper();
			BreadDTO breadDto = objectMapper.readValue(breadDtoJson, BreadDTO.class);
			// bread를 새로 넣어줌
			Bread insertedBread = breadService.insertBread(breadDto, file);
			return ResponseEntity.ok("빵 수정 성공: ID = " + insertedBread.getBreadId());
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("빵 등록 실패");
		}
	}

	@DeleteMapping("/{breadId}")
	public ResponseEntity<String> deleteBread(@PathVariable long breadId) {
		breadService.deleteBread(breadId);
		return ResponseEntity.ok("빵 삭제 성공");
	}
}
