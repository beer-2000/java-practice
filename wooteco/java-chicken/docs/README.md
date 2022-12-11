# 기능 구현 목록

## UI
### InputView
- [x] 기능 선택 입력
- [x] 테이블 선택 입력
- [x] 메뉴 선택 입력
- [x] 메뉴 수량 입력
- [x] 결제 수단 입력

### OutputView
- [x] 메인화면 출력
- [x] 테이블 목록 출력
- [x] 메뉴 출력
- [x] 빈 줄 출력
- [x] 주문 내역 출력
- [ ] 결제 금액 출력
---

## Controller
### HofController
- [x] 주문등록
- [x] 결제
- [ ] 프로그램 종료
---

## Domain
### Menu
- [x] 메뉴 정보 반환

### Table
- [x] 테이블 번호 반환
- [x] 주문 추가
- [x] 주문 존재 여부 확인
- [x] 주문서 반환

### Order
- [x] 주문 추가
- [x] 주문 존재 여부 확인
- [x] 주문서 반환
---

## Repository
### MenuRepository
- [x] 전체 메뉴 정보 반환
- [x] 메뉴 번호로 메뉴 반환

### TableRepository
- [x] 전체 테이블 정보 반환
- [x] 테이블 번호로 테이블 반환
- [x] 주문 추가
---

## Constant
### HofRule
- [x] 구현
