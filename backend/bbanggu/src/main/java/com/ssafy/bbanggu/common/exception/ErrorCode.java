package com.ssafy.bbanggu.common.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
	// ✅ 사용자 관련 예외 (1000번대)
	BAD_REQUEST(1000, HttpStatus.BAD_REQUEST, "잘못된 요청입니다. 요청 데이터를 다시 확인해주세요."),
	USER_NOT_FOUND(1001, HttpStatus.NOT_FOUND, "해당 사용자를 찾을 수 없습니다."),
	INVALID_PASSWORD(1002, HttpStatus.UNAUTHORIZED, "비밀번호가 올바르지 않습니다."),
	ACCOUNT_DEACTIVATED(1003, HttpStatus.FORBIDDEN, "이 계정은 비활성화(탈퇴)되었습니다."),
	INVALID_AUTHORIZATION_HEADER(1004, HttpStatus.UNAUTHORIZED, "유효하지 않은 Authorization 헤더입니다."),
	MISSING_AUTHORIZATION_HEADER(1005, HttpStatus.UNAUTHORIZED, "Authorization 헤더가 존재하지 않습니다."),
	EMAIL_ALREADY_IN_USE(1006, HttpStatus.CONFLICT, "이미 사용 중인 이메일입니다."),
	PASSWORD_RESET_FAILED(1007, HttpStatus.BAD_REQUEST, "비밀번호 초기화에 실패했습니다."),
	PHONE_NUMBER_ALREADY_EXISTS(1008, HttpStatus.CONFLICT, "이미 사용 중인 전화번호입니다."),
	SAME_AS_OLD_PASSWORD(1009, HttpStatus.BAD_REQUEST, "이전 비밀번호와 동일한 비밀번호는 사용하실 수 없습니다."),
	INVALIE_PASSWORD(1010, HttpStatus.BAD_REQUEST, "비밀번호는 8자 이상이어야 합니다."),
	UNAUTHORIZED_USER(1011, HttpStatus.UNAUTHORIZED, "토큰이 없거나, 인증되지 않은 사용자입니다."),
	NOT_EQUAL_USER(1012, HttpStatus.FORBIDDEN, "현재 로그인한 사용자와 조회 대상이 일치하지 않습니다."),
	USER_IS_NOT_OWNER(1013, HttpStatus.UNAUTHORIZED, "현재 로그인한 사용자는 사장님이 아닙니다."),
	NOT_EQUAL_PASSWORD(1014, HttpStatus.BAD_REQUEST, "입력한 기존 비밀번호가 현재 비밀번호와 일치하지 않습니다."),
	EQUAL_ORIGIN_AND_NEW_PASSWORD(1015, HttpStatus.BAD_REQUEST, "기존 비밀번호와 동일한 비밀번호로는 변경할 수 없습니다."),
	PROFILE_IMAGE_UPLOAD_FAILED(1016, HttpStatus.INTERNAL_SERVER_ERROR, "프로필 이미지 저장에 실패하였습니다."),
	DUPLICATE_PHONE(1017, HttpStatus.BAD_REQUEST, "이미 존재하는 휴대폰 번호입니다. 다시 입력해주세요."),

	// ✅ kakao 인증 관련 예외(1500번대)
	KAKAO_AUTH_FAILED(1501, HttpStatus.BAD_REQUEST, "카카오 인증에 실패하였습니다."),
	KAKAO_USER_INFO_FAILED(1502, HttpStatus.BAD_REQUEST, "카카오 사용자 정보 요청에 실패하였습니다."),

	// ✅ 가게 관련 예외 (2000번대)
	NUMBER_ALREADY_IN_USE(2000, HttpStatus.CONFLICT, "이미 존재하는 사업자 등록 번호입니다."),
	BAKERY_NAME_ALREADY_IN_USE(2001, HttpStatus.CONFLICT, "이미 존재하는 가게 이름입니다."),
	BAKERY_NOT_FOUND(2002, HttpStatus.NOT_FOUND, "가게를 찾을 수 없습니다."),
	NO_PERMISSION_TO_EDIT_BAKERY(2003, HttpStatus.FORBIDDEN, "해당 가게를 수정할 권한이 없습니다."),
	NO_KEYWORD_ENTERED(2004, HttpStatus.BAD_REQUEST, "입력된 키워드가 없습니다. 검색어를 입력해주세요."),
	SETTLEMENT_NOT_FOUND(2005, HttpStatus.NOT_FOUND, "해당 가게의 정산정보가 존재하지 않습니다."),
	BAKERY_IMAGE_UPLOAD_FAILED(2006, HttpStatus.INTERNAL_SERVER_ERROR, "가게 이미지 저장에 실패하였습니다."),
	BAKERY_BACKGROUND_IMAGE_UPLOAD_FAILED(2007, HttpStatus.INTERNAL_SERVER_ERROR, "가게 배경 이미지 저장에 실패하였습니다."),
	BAKERY_PICKUP_TABLE_NOT_FOUND(2008, HttpStatus.NOT_FOUND, "해당 가게의 픽업타임이 생성되지 않았습니다."),

	// ✅ 빵 관련 예외 (2100번대)

	// ✅ 빵꾸머리 관련 예외 (2200번대)
	BREAD_PACKAGE_NOT_FOUND(2200, HttpStatus.NOT_FOUND, "존재하지 않는 빵꾸러미입니다."),
	BREAD_PACKAGE_QUANTITY_CONFLICT(2001, HttpStatus.CONFLICT, "빵꾸러미가 부족합니다."),
	WRONG_DATE_FORMAT(2002, HttpStatus.BAD_REQUEST, "잘못된 날짜 형식입니다. (예: 2024-02-01 00:00:00)"),
	PACKAGE_ALREADY_DELETED(2003, HttpStatus.FORBIDDEN, "이미 삭제된 빵꾸러미입니다."),
	DUPLICATE_BREAD_PACKAGE(2004, HttpStatus.CONFLICT, "동일한 빵꾸러미가 이미 등록되어 있습니다."),
	TODAY_PACKATE_ALREADY_EXIST(2005, HttpStatus.BAD_REQUEST, "빵꾸러미는 하루에 한 번만 등록할 수 있습니다."),

	// ✅ 관심 가게 관련 예외 (2300번대)
	ALREADY_FAVORITE(2300, HttpStatus.BAD_REQUEST, "이미 관심가게로 등록된 빵집입니다."),
	BAKERY_NOT_FAVORITE(2301, HttpStatus.BAD_REQUEST, "좋아요 하지 않은 가게입니다."),

	// ✅ 예약 관련 예외 (2300번대)
	RESERVATION_NOT_FOUND(2300, HttpStatus.NOT_FOUND, "예약 정보를 찾을 수 없습니다."),
	PAYMENT_NOT_VALID(2301, HttpStatus.BAD_REQUEST, "결제 정보가 다릅니다."),
	QUANTITY_EXCEEDED(2302, HttpStatus.BAD_REQUEST, "남은 빵꾸러미 수량보다 많은 개수를 예약할 수 없습니다."),
	DUPLICATE_RESERVATION(2303, HttpStatus.CONFLICT, "이미 예약된 빵꾸러미가 있습니다. 중복 예약이 불가능합니다."),
	UNVERIFIED_RESERVATION(2304, HttpStatus.UNAUTHORIZED, "검증되지 않은 예약입니다."),
	RESERVATION_ALREADY_CANCELED(2305, HttpStatus.CONFLICT, "이미 취소된 예약입니다."),
	NOT_BAKERY_OWNER(2306, HttpStatus.FORBIDDEN, "사장님이 아닌 사용자는 예약 처리 권한이 없습니다."),
	RESERVATION_IS_NOT_CONFIRMED(2307, HttpStatus.CONFLICT, "현재 예약 상태가 'CONFIRMED'가 아닙니다."),
	RESERVATION_ALREADY_COMPLETED(2308, HttpStatus.BAD_REQUEST, "이미 픽업이 완료된 예약입니다."),
	USER_NOT_BAKERY_OWNER(2309, HttpStatus.UNAUTHORIZED, "현재 로그인한 사용자는 해당 빵집의 사장님이 아닙니다."),
	USER_NOT_RESERVATION_USER(2310, HttpStatus.UNAUTHORIZED, "현재 로그인한 사용자는 예약자가 아닙니다."),

	// ✅ 이메일 인증 관련 예외 (3000번대)
	EMAIL_SEND_FAILED(3000, HttpStatus.INTERNAL_SERVER_ERROR, "이메일 전송에 실패하였습니다."),
	TOO_MANY_REQUESTS(3001, HttpStatus.TOO_MANY_REQUESTS, "너무 많은 요청을 보냈습니다. 나중에 다시 시도하세요."),
	INVALID_VERIFICATION_CODE(3002, HttpStatus.UNAUTHORIZED, "인증번호가 일치하지 않습니다. 다시 확인해주세요."),
	EXPIRED_VERIFICATION_CODE(3003, HttpStatus.GONE, "인증 코드가 만료되었습니다."),
	USED_VERIFICATION_CODE(3004, HttpStatus.GONE, "이미 사용된 인증 코드입니다."),
	EMAIL_ALREADY_VERIFIED(3005, HttpStatus.CONFLICT, "이미 인증된 이메일입니다."),
	VERIFICATION_CODE_NOT_FOUND(3006, HttpStatus.NOT_FOUND, "해당 이메일의 인증 코드가 존재하지 않습니다."),
	INVALID_EMAIL(3007, HttpStatus.BAD_REQUEST, "유효하지 않은 이메일 형식입니다."),
	EMAIL_NOT_FOUND(3008, HttpStatus.NOT_FOUND, "존재하지 않는 이메일입니다."),
	INVALID_AUTH_CODE_FORMAT(3009, HttpStatus.BAD_REQUEST, "유효하지 않은 인증번호 형식입니다."),

	// ✅ JWT 관련 예외 (4000번대)
	INVALID_ACCESS_TOKEN(4000, HttpStatus.UNAUTHORIZED, "유효하지 않은 Access Token 입니다."),
	INVALID_REFRESH_TOKEN(4001, HttpStatus.UNAUTHORIZED, "유효하지 않은 Refresh Token 입니다."),
	INVALID_TOKEN_MISSING_USERID(4002, HttpStatus.UNAUTHORIZED, "JWT 토큰에 userId 정보가 없습니다."),
	TOKEN_EXPIRED(4003, HttpStatus.UNAUTHORIZED, "토큰이 만료되었습니다."),
	TOKEN_VERIFICATION_FAILED(4004, HttpStatus.UNAUTHORIZED, "토큰 검증에 실패하였습니다."),
	INVALID_AUTHENTICATION(4005, HttpStatus.FORBIDDEN, "잘못된 인증 정보입니다."),
	REFRESH_TOKEN_NOT_FOUND(4006, HttpStatus.UNAUTHORIZED, "Refresh Token이 존재하지 않습니다."),
	EXPIRED_TOKEN(4007, HttpStatus.UNAUTHORIZED, "토큰이 만료되었습니다."),
	TOKEN_THEFT_DETECTED(4008, HttpStatus.FORBIDDEN, "토큰 탈취가 의심됩니다."),
	INCORRECT_TOKEN_FORMAT(4009, HttpStatus.BAD_REQUEST, "JWT 토큰 형식이 잘못되었습니다."),
	REFRESH_TOKEN_NOT_EXIST(4010, HttpStatus.UNAUTHORIZED, "쿠키에 Refresh Token이 없습니다."),
	NOT_MATCHED_AUTH_INFO(4011, HttpStatus.UNAUTHORIZED, "인증정보가 일치하지 않습니다."),

	// ✅ 요청, 응답 관련 예외 (4100번대)
	MISSING_REQUIRED_FIELDS(4100, HttpStatus.BAD_REQUEST, "필수 입력란이 누락되었습니다."),

	// ✅ 로그아웃 관련 예외 (4500번대)
	LOGOUT_FAILED(4500, HttpStatus.BAD_REQUEST, "로그아웃 처리 중 오류가 발생했습니다."),
	USER_ALREADY_LOGGED_OUT(4501, HttpStatus.BAD_REQUEST, "이미 로그아웃된 사용자입니다."),

	// ✅ 리뷰 관련 예외 (4600번대)
	REVIEW_NOT_ALLOWED(4600, HttpStatus.FORBIDDEN, "픽업을 완료한 후에만 리뷰를 작성할 수 있습니다."),
	REVIEW_ALREADY_EXISTS(4601, HttpStatus.CONFLICT, "해당 예약에 대한 리뷰는 이미 작성되었습니다."),
	FORBIDDEN_REVIEW(4602, HttpStatus.FORBIDDEN, "해당 리뷰에 대한 권한이 없습니다."),
	ONLY_VIEW_OWN_REVIEW(4603, HttpStatus.UNAUTHORIZED, "본인의 리뷰만 조회할 수 있습니다."),
	INVALID_RATING(4604, HttpStatus.BAD_REQUEST, "유요하지 않은 평점입니다. 평점은 1~5 사이의 숫자여야 합니다."),
	REVIEW_IMAGE_UPLOAD_FAILED(4605, HttpStatus.INTERNAL_SERVER_ERROR, "리뷰 이미지 저장에 실패하였습니다."),

	// ✅ 서버 내부 오류 (5000번대)
	INTERNAL_SERVER_ERROR(5000, HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류가 발생했습니다.");

	private final int code;
	private final HttpStatus status;
	private final String message;
}
