# 빵을 구하자, 빵구 (BBANGGU)
![BBANGGU_Title](https://github.com/user-attachments/assets/eec5168f-77e5-4084-9134-71f99f357b3a)
<br>

### 삼성 청년 SW·AI 아카데미(SSAFY) 12th 공통 프로젝트 - 우수상🏆
> 2025.01.06. ~ 2025.02.21. (7주)
<br>

## 목차
1. [프로젝트 소개](#-프로젝트-소개)
    - [기획 의도](#-기획-의도)
    - [주요 특징](#-주요-특징)
    - [서비스 가치](#-서비스-가치)
2. [화면 구성](#-화면-구성)
3. [아키텍처 구성도](#%EF%B8%8F-아키텍처-구성도)
4. [ERD](#%EF%B8%8F-erd)
5. [기술 스택](#%EF%B8%8F-기술-스택)
6. [팀원 소개](#-팀원-소개)
<br>

## 🥨 프로젝트 소개
<strong>빵을 구하자, 빵구(BBANGGU)</strong>는 베이커리의 **마감 임박 제품을 '빵꾸러미'로 구성해 할인된 가격에 판매할 수 있도록 지원하는 친환경 식품 유통 플랫폼**입니다. 소비자는 신선한 빵을 저렴하게 구매하고, 점주는 재고를 효율적으로 소진하며, 동시에 음식물 쓰레기를 줄일 수 있는 **소셜임팩트형 서비스**입니다.
<br>
<br>

### 🎯 기획 의도
- **음식물 쓰레기 감소**: 매일 폐기되는 베이커리 제품을 줄여 환경 보호에 기여
- **소비자 혜택**: 신선한 베이커리 제품을 합리적인 가격에 제공
- **점주 매출 증대**: 폐기 예정 제품의 판매를 통한 손실 최소화
<br>
  
### 💡 주요 특징
- **AI 기반 빵 인식**: YOLO와 EfficientNet B2 모델을 활용한 자동 빵 인식 시스템
- **빵꾸러미 시스템**: 점주가 마감 임박 제품을 패키지로 구성하여 할인 판매
- **실시간 재고 관리**: 베이커리의 재고 현황을 실시간으로 확인 및 관리
- **간편한 결제 시스템**: 소비자가 쉽게 구매할 수 있는 직관적인 결제 프로세스
<br>

### 🎁 서비스 가치
- **환경적 가치**: 음식물 쓰레기 감소를 통한 환경 보호  
- **경제적 가치**: 소비자는 합리적 가격, 점주는 폐기 손실 절감  
- **사회적 가치**: 지속 가능한 소비 문화를 조성하고 지역 상권 활성화에 기여  
<br>

## 👀 화면 구성
### 1. 사장님 (판매자) 
| 홈 화면 | YOLOv8 빵 재고 인식 | AI 빵꾸러미 조합 추천 | AI 분석 리포트 제공 | 
|-----------|-----------|-----------|-----------| 
| <img src="https://github.com/user-attachments/assets/7d23357c-ffd7-44eb-ab2d-ede4d350d3fd" height="500"/> | <img src="https://github.com/user-attachments/assets/d11c13e8-1f81-437e-a4eb-fe1c3a27b70b" height="500"/> | <img src="https://github.com/user-attachments/assets/c6977939-ec05-4548-a88f-cc45e427eac6" height="500"/> | <img src="https://github.com/user-attachments/assets/cc3243c3-9a75-4b77-8f1d-0a71e4029854" height="500"/> | 
| - 등록된 빵꾸러미 현황 조회<br>- 신규 빵꾸러미 등록 및 관리<br>- 가게 리뷰 조회 및 관리 | - YOLOv8 기반 빵 <br>종류와 수량 인식<br>- 자체 라벨링 데이터<br> 1,200장 이상을 기반<br> 모델 학습<br>- 등록된 정보는 자동<br> DB 반영 | - 인식된 재고 기반 빵꾸러미<br> 패키지 자동 구성<br>- 가격/종류를 균형있게<br> 고려한 패키지 추천<br> | - Top3 빵 재고 현황 조회<br>- 일/주/월 단위 재고량<br> 그래프로 시각화<br>- GPT API 연동을 통한<br> 분석 레포트 제공<br> |
<br> 

### 2. 고객 (구매자) 
| 홈 화면 | 지도 (Kakao Map) | 결제 (Tosspayments) | 절약한 자원/예약 확인 | 
|-----------|-----------|-----------|-----------| 
| <img src="https://github.com/user-attachments/assets/2ee5d697-b348-48b5-a255-6358bdbe523a" height="500"/> | <img src="https://github.com/user-attachments/assets/ac489deb-b4b3-4ce2-9c31-4756587b00f7" height="500"/> | <img src="https://github.com/user-attachments/assets/455826e2-f407-438f-b8a4-ca05b4c44391" height="500"/> | <img src="https://github.com/user-attachments/assets/2bc62c4f-2ab6-4ad2-9ad1-bddbdfba3504" height="500"/> | 
| 설명 | 설명 | 설명 | 설명 | 
<br>

### 3. 공통
| PWA (Progressive Web App) | Kakao 로그인 (OAuth2) |
|-----------|-----------|
| <img src="https://github.com/user-attachments/assets/b339f29b-ed81-42c0-972a-d829a97e3e86" height="500"/> | <img src="https://github.com/user-attachments/assets/a7c81ac1-d471-4686-9695-274e427c09a2" height="500"/> |
| 설명 | 설명 |
<br>

## ⚙️ 아키텍처 구성도
<img src="https://github.com/user-attachments/assets/9c890c9b-292e-4d23-99fa-827153d37585" width="800"/><br>

## 🗄️ ERD
<img src="https://github.com/user-attachments/assets/58651c5f-f68b-4fa7-9eeb-76df388cbf54" width="800"/><br>
<br>

## 🛠️ 기술 스택
#### Frontend
![React](https://img.shields.io/badge/React-61DAFB?style=flat&logo=react&logoColor=black)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=flat&logo=javascript&logoColor=black)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=flat&logo=html5&logoColor=white)
![Kakao Map API](https://img.shields.io/badge/Kakao%20Map%20API-FFCD00?style=flat&logo=kakao&logoColor=black)

#### Backend
![Java](https://img.shields.io/badge/Java-007396?style=flat&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat&logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?style=flat&logo=springsecurity&logoColor=white)
![JPA](https://img.shields.io/badge/JPA-59666C?style=flat&logo=hibernate&logoColor=white)
![FastAPI](https://img.shields.io/badge/FastAPI-009688?style=flat&logo=fastapi&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=flat&logo=jsonwebtokens&logoColor=white)
![OAuth2](https://img.shields.io/badge/OAuth2-3C3C3D?style=flat&logo=oauth&logoColor=white)
![Toss Payments API](https://img.shields.io/badge/Toss%20Payments%20API-0064FF?style=flat&logo=toss&logoColor=white)

#### Database
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white)

#### AI
![PyTorch](https://img.shields.io/badge/PyTorch-EE4C2C?style=flat&logo=pytorch&logoColor=white)
![YOLOv8](https://img.shields.io/badge/YOLOv8-00FFFF?style=flat&logo=yolo&logoColor=black)
![EfficientNet](https://img.shields.io/badge/EfficientNet-00C7B7?style=flat&logo=tensorflow&logoColor=white)
![GPT API](https://img.shields.io/badge/GPT%20API-412991?style=flat&logo=openai&logoColor=white)

#### Infra & DevOps
![AWS EC2](https://img.shields.io/badge/Amazon%20EC2-FF9900?style=flat&logo=amazonec2&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat&logo=docker&logoColor=white)
![DockerHub](https://img.shields.io/badge/DockerHub-2496ED?style=flat&logo=docker&logoColor=white)
![Jenkins](https://img.shields.io/badge/Jenkins-D24939?style=flat&logo=jenkins&logoColor=white)
![Nginx](https://img.shields.io/badge/Nginx-009639?style=flat&logo=nginx&logoColor=white)
![SSL](https://img.shields.io/badge/SSL-2C2D72?style=flat&logo=letsencrypt&logoColor=white)

#### Communication & Collaboration
![GitLab](https://img.shields.io/badge/GitLab-FC6D26?style=flat&logo=gitlab&logoColor=white)
![Jira](https://img.shields.io/badge/Jira-0052CC?style=flat&logo=jira&logoColor=white)
![Notion](https://img.shields.io/badge/Notion-000000?style=flat&logo=notion&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=flat&logo=postman&logoColor=white)
![Mattermost](https://img.shields.io/badge/Mattermost-0072C6?style=flat&logo=mattermost&logoColor=white)
<br>
<br>

## 🩵 팀원 소개
<!-- 가로폭만 지정 (비율 유지됨) -->
<img src="https://github.com/user-attachments/assets/dd18db00-d049-4bf5-b86f-d209c10e52bc" width="600"/><br>

| 👑[김유진](https://github.com/zladb) | [김휘동](https://github.com/HwiDong6831) | [정나금](https://github.com/gomie1) | [신은찬](https://github.com/eunchan0324) | [권가영](https://github.com/gayeong718) | [서유민](https://github.com/sennaseo) |
|:---:|:---:|:---:|:---:|:---:|:---:|
| ![Yujin](https://github.com/user-attachments/assets/69a74b1e-e8a1-44dd-b2c1-be8f43ea4293)   | ![Hwidong](https://github.com/user-attachments/assets/75bf9404-cfe2-46a9-b55a-3545047b1ed4) | ![Nageum](https://github.com/user-attachments/assets/1d47995d-8cb9-4232-953e-c740dcc0ccfa) | ![Eunchan](https://github.com/user-attachments/assets/b8e01d40-2361-4291-a554-ad186f19300c) | ![Garong](https://github.com/user-attachments/assets/db9eb4c6-1d41-4a06-917d-0a25f3989b3d) | ![Yumin](https://github.com/user-attachments/assets/24943c97-8cb5-4e86-bb35-d4d5e6498c21) |
| `BE`, `Infra` | `BE`, `AI` | `BE` | `FE` | `FE` | `FE` |
