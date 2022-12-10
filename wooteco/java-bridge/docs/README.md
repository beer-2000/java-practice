# 기능 구현 목록

## UI
### InputView
- [x] 다리 길이 입력
  - [ ] (예외 처리) 숫자 여부 판별
- [x] 이동할 칸 입력
- [ ] 게임 재시작 여부 입력

### OutputView
- [x] 게임 시작 안내 멘트 출력
- [x] 다리 길이 입력 요청 멘트 출력
- [x] 줄 띄우기
- [x] 이동할 칸 입력 요청 멘트 출력
- [ ] 현재 이동 현황 출력
- [ ] 게임 재시작 여부 입력 요청 멘트 출력
- [ ] 최종 게임 결과 출력
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
- [ ] (예외 처리) 다리 길이 

### MovingStatus (Value Object)
- [x] 실패 여부 설정
- [x] 실패 여부 반환
- [x] 이동 기록 반환

### BridgeMaker
- [x] 다리 생성

### BridgeRandomNumberGenerator
- [x] 다리 생성을 위한 랜덤 숫자 생성

## Constant
### BridgeRule
- [x] 구현

### ProgressStatus
- [x] 구현