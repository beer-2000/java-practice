# 기능 구현 목록

## UI
### InputView
- [ ] 다리 길이 입력
- [ ] 이동할 방향 입력
- [ ] 게임 재시작 여부 입력

### OutputView
- [ ] 게임 시작 안내
- [ ] 이동 결과 출력
- [ ] 최종 게임 결과 출력
- [ ] 게임 성공 여부 출력
- [ ] 총 시도한 횟수 출력
---

## Controller
### BridgeController
- [ ] 게임 실행
- [ ] 한 턴의 이동 실행
  - [ ] (실패 시) 게임 재시작 여부 확인
- [ ] 최종 결과 반환
---

## Domain

### BridgeGame
- [ ] 이동
- [ ] 재시작

### BridgeReferee
- [ ] 현재 이동 성공 판단

### BridgePicture
- [ ] 현재 이동 기록
- [ ] 현재 다리 현황 반환

### BridgeMaker
- [ ] 다리 생성

### BridgeRandomNumberGenerator
- [ ] 다리 방향을 나타내는 랜덤 숫자 생성

### Moving (Enum)
- [ ] 이동 방향 상수 집합 구현

### GameCommand (Enum)
- [ ] 게임 재시작 커맨드 상수 집합 구현

### GameStatus (Enum)
- [ ] 게임 상태 상수 집합 구현
---

## Constant
### BridgeRule
- [ ] 게임 전체 룰 상수 집합 구현
---

## 예외 사항 사전 정리
- [ ] (예외 처리) 잘못된 다리 길이
- [ ] (예외 처리) 잘못된 이동 방향
- [ ] (예외 처리) 잘못된 게임 재시작 여부
---