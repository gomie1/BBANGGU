package com.ssafy.bbanggu.user.dto;

/**
 * 사용자 정보 수정 요청 DTO
 * 클라이언트에서 수정할 사용자 데이터를 전달받음
 */
public record UpdateUserRequest(
	String name,
	String phone,
	String profileImageUrl,
	String addressRoad,
	String addressDetail
) {}
