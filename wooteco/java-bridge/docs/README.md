# 기능 구현 목록

## UI

### InputView

- [ ] 다리 길이 입력
- [ ] 이동할 칸 입력
- [ ] 게임 재시작 여부 입력

### OutputView

- [ ] 게임 시작 안내 멘트 출력
- [ ] 다리 길이 입력 요청 멘트 출력
- [ ] 이동할 칸 입력 요청 멘트 출력
- [ ] 현재 이동 현황 출력
- [ ] 게임 재시작 여부 입력 요청 멘트 출력
- [ ] 최종 게임 결과 출력
- 

---

## Controller

### BridgeController

- [ ] 이동 요청
- [ ] 재시작 여부 판별 요청

---

## Domain

### BridgeGame

- [ ] 이동
- [ ] 재시작
  - [ ] 재시작 여부 판별
  - [ ] 이동 기록 초기화

### BridgeCalculator

- [ ] 이동 방향이 맞는지 확인

### MovingStatus (Value Object)

- [ ] 구현

### BridgeMaker

- [x] 다리 생성

### BridgeRandomNumberGenerator

- [x] 다리 생성을 위한 랜덤 숫자 생성

## Constant

### BridgeRule

- [x] 구현