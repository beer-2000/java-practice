# 기능 구현 목록

## UI

### InputView

- [x] 구입금액 입력 받기
- [ ] 당첨 번호 입력 받기
- [ ] 보너스 번호 입력 받기

### OutputView

- [x] 구입금액 입력 안내 멘트 출력
- [x] 구매 내역 출력
    - [x] 구매 개수 출력
    - [x] 구입한 로또 번호 출력
- [x] 당첨 번호 입력 안내 멘트 출력
- [ ] 보너스 번호 입력 안내 멘트 출력
- [ ] 당첨 통계 출력

---

## Controller

### LottoController

- [ ] 구입금액만큼의 로또 발행 요청
- [ ] 당첨 결과 계산 요청

---

## Domain

### Lotto

- [ ] 로또 번호 리스트가 특정 값을 포함하는지 확인
- [ ] 유효성 검사 : 숫자 개수가 적절한지 확인

### NumberGenerator

- [x] 번호 생성

### Cashier

- [x] 구입금액에 해당하는 로또 개수 계산

### WinningCalculator

- [ ] 여러 장의 로또에 대한 당첨 결과 계산

### Result (Value Object)

- [ ] 수익률 계산

### WinningResult (Enum)

- [ ] 구현

## Constant

### LottoRule

- [ ] 구현