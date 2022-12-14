# 기능 구현 목록

## UI
### InputView
- [x] 자판기 초기 보유 금액 입력
- [ ] 상품 등록 정보 입력
- [ ] 투입 금액 입력
- [ ] 구매할 상품명 입력

### OutputView
- [ ] 자판기 초기 보유 동전 현황 출력
- [ ] 투입 금액 출력
- [ ] 잔돈 출력
- [x] 에러 메시지 출력
---

## Controller
### VendingController
- [x] 자판기 생성
- [ ] 상품 등록
- [ ] 투입한 금액에 대해 상품 구매
  - [ ] 상품 1회 구매
  - [ ] 잔돈 반환
---

## Domain
### VendingMachine
- [ ] 상품 등록
- [ ] 상품 구매 가능 상태인지 확인
- [ ] 상품 1회 구매
- [ ] 잔돈 반환

### Product
- [ ] 가격 반환
- [ ] 개수가 없는지 확인
- [ ] 개수 차감

### Products
- [ ] 물품 생성
- [ ] 특정 물품 가격 반환
- [ ] 특정 물품 개수 차감

### Coin (Enum)
- [ ] 구현

### CoinStatus
- [ ] 랜덤 개수 생성
- [ ] 잔돈 반환

### CoinMachine
- [ ] 동전 랜덤 생성
- [ ] 잔돈 반환

### CoinInfo (Value Object)
- [ ] 구현
---

## Constant
### VendingRule
- [ ] 구현
