# 기능 구현 목록

## UI
### InputView
- [x] 다리 길이 입력
  - [x] (예외 처리) 숫자 여부 판별
- [x] 이동할 칸 입력
- [x] 게임 재시작 여부 입력

### OutputView
- [x] 게임 시작 안내 멘트 출력
- [x] 다리 길이 입력 요청 멘트 출력
- [x] 줄 띄우기
- [x] 이동할 칸 입력 요청 멘트 출력
- [x] 현재 이동 현황 출력
- [x] 게임 재시작 여부 입력 요청 멘트 출력
- [x] 최종 게임 결과 출력
---

## Controller
### BridgeController
- [x] 이동 요청
- [x] 재시작 여부 판별 요청
---

## Domain
### BridgeGame
- [x] 이동
  - [x] (예외 처리) 이동 문자 유효성 검사
- [x] 재시작
  - [x] 재시작 여부 판별
  - [x] 이동 기록 초기화
  - [x] (예외 처리) 게임 재시작 문자 유효성 검사
- [x] 종료 여부 판별
- [x] 성공 여부 반환
- [x] 시도 횟수 반환

### BridgeCalculator
- [x] 이동 방향이 맞는지 확인
- [x] 다리 길이 반환
- [x] (예외 처리) 다리 길이 

### MovingStatus (Value Object)
- [x] 실패 여부 설정
- [x] 실패 여부 반환
- [x] 이동 기록 반환
- [x] 마지막 이동 반환

### BridgeMaker
- [x] 다리 생성

### BridgeRandomNumberGenerator
- [x] 다리 생성을 위한 랜덤 숫자 생성

## Constant
### BridgeRule
- [x] 구현

### ProgressStatus
- [x] 구현