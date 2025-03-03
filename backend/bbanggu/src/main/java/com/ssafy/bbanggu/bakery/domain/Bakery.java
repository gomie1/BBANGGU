package com.ssafy.bbanggu.bakery.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.ssafy.bbanggu.bread.Bread;
import com.ssafy.bbanggu.breadpackage.BreadPackage;
import com.ssafy.bbanggu.favorite.Favorite;
import com.ssafy.bbanggu.review.domain.Review;
import com.ssafy.bbanggu.stock.Stock;
import com.ssafy.bbanggu.user.domain.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "bakery")
public class Bakery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bakery_id", columnDefinition = "INT UNSIGNED")
	private Long bakeryId; // 가게 ID

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user; // 사용자 ID (연관 관계)

	@Column(nullable = false, length = 100)
	private String name; // 가게 이름

	@Column(length = 1500, nullable = true)
	private String description; // 가게 설명

	@Column(name = "business_registration_number", nullable = false, unique = true, length = 50)
	private String businessRegistrationNumber; // 사업자 등록 번호

	@Column(name = "address_road", nullable = false, length = 255)
	private String addressRoad; // 도로명 주소

	@Column(name = "address_detail", nullable = false, length = 150)
	private String addressDetail; // 상세 주소

	@Column(name = "bakery_image_url", length = 255, nullable = true)
	private String bakeryImageUrl; // 가게 이미지 URL

	@Column(name = "bakery_background_img_url")
	private String bakeryBackgroundImgUrl; // 가게 배경 이미지 URL

	@Column(nullable = false)
	private Double latitude; // 위도

	@Column(nullable = false)
	private Double longitude; // 경도

	@Column(nullable = false, columnDefinition = "DOUBLE DEFAULT 0.0")
	private Double star;

	@Column(name = "rating_1_cnt", nullable = false, columnDefinition = "INT DEFAULT 0")
	private int rating1Cnt;

	@Column(name = "rating_2_cnt", nullable = false, columnDefinition = "INT DEFAULT 0")
	private int rating2Cnt;

	@Column(name = "rating_3_cnt", nullable = false, columnDefinition = "INT DEFAULT 0")
	private int rating3Cnt;

	@Column(name = "rating_4_cnt", nullable = false, columnDefinition = "INT DEFAULT 0")
	private int rating4Cnt;

	@Column(name = "rating_5_cnt", nullable = false, columnDefinition = "INT DEFAULT 0")
	private int rating5Cnt;

	@Column(name = "review_cnt", nullable = false, columnDefinition = "INT DEFAULT 0")
	private int reviewCnt;

	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt; // 생성일

	@Column(name = "deleted_at")
	private LocalDateTime deletedAt; // 삭제일

	@Column(name = "updated_at")
	private LocalDateTime updatedAt; // 수정일

	// 연관 관계 설정
	@OneToMany(mappedBy = "bakery", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BakeryPickupTimetable> pickupTimetables; // 픽업 시간표

	@OneToMany(mappedBy = "bakery", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Bread> breads; // 빵 목록

	@OneToMany(mappedBy = "bakery", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BreadPackage> packages; // 패키지 목록

	@OneToMany(mappedBy = "bakery", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review> reviews; // 리뷰 목록

	@OneToMany(mappedBy = "bakery", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Stock> stocks; // 재고 목록

	@OneToMany(mappedBy = "bakery", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Favorite> favorites; // 즐겨찾기 목록

	// ✅ Builder 패턴 확인 (description, bakeryImageUrl 포함해야 함)
	@Builder
	public Bakery(String name, String description, String businessRegistrationNumber,
		String addressRoad, String addressDetail, String bakeryImageUrl,
		double latitude, double longitude, double star, User user,
		int reviewCnt, int rating1Cnt, int rating2Cnt, int rating3Cnt,
		int rating4Cnt, int rating5Cnt
	) {
		this.name = name;
		this.description = description;
		this.businessRegistrationNumber = businessRegistrationNumber;
		this.addressRoad = addressRoad;
		this.addressDetail = addressDetail;
		this.bakeryImageUrl = bakeryImageUrl;
		this.latitude = latitude;
		this.longitude = longitude;
		this.star = star;
		this.user = user;
		this.reviewCnt = reviewCnt;
		this.rating1Cnt = rating1Cnt;
		this.rating2Cnt = rating2Cnt;
		this.rating3Cnt = rating3Cnt;
		this.rating4Cnt = rating4Cnt;
		this.rating5Cnt = rating5Cnt;
	}

	@PrePersist
	protected void onCreate() {
		createdAt = LocalDateTime.now();
		updatedAt = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = LocalDateTime.now();
	}

	@PreRemove
	protected void onDelete() {
		deletedAt = LocalDateTime.now();
	}

}
