# 기능 구현 목록

## UI
### InputView
- [x] 다리 길이 입력
    - [x] 다리 길이 자료형 변환
    - [x] 예외 처리
- [x] 이동할 방향(moving) 입력
- [x] 게임 재시작 여부(game command) 입력

### OutputView
- [x] 게임 시작 안내
- [x] 다리 이동 현황 출력
- [x] 최종 게임 결과 출력
- [x] 게임 종료 안내
---

## Controller
### BridgeController
- [x] 게임 시작
    - [x] 다리 게임 생성
    - [x] 한 턴의 이동 요청
        - [x] 실패 확인
            - [x] 재시작 요청
    - [x] 최종 결과 출력 요청
---

## Domain
### BridgeMaker
- [x] 다리 생성

### BridgeRandomNumberGenerator
- [x] 랜덤 숫자 생성 (기작성된 코드)

### BridgeGame
- [x] 한 턴의 이동
- [x] 재시작 여부 판단 및 처리
    - [x] 재시작
- [x] 성공 여부 확인
- [x] 게임 상태 확인
    - [x] 진행 중인지 확인
    - [x] 실패 상태인지 확인
    - [x] 종료 상태인지 확인
- [x] 이동 현황 반환
- [x] 총 시도한 횟수 반환
- [x] 예외 처리
    - [x] 이동할 방향(moving)
    - [x] 게임 재시작 여부(game command)

### BridgeReferee
- [x] 이동 결과 판단 후 게임 상태 반환
    - [x] 이동 방향이 해당 위치에서의 옳은 방향이 맞는지 확인
- [x] 다리 건너기 성공 여부 반환
- [x] 위치 초기화

### BridgeDrawer
- [x] 한 턴의 이동에 대한 현황 기록
    - [x] 괄호 열기
    - [x] 괄호 닫기
    - [x] "|" 추가를 위해 공백으로 끝나는지 확인
    - [x] "|" 추가
    - [x] 한 줄의 마지막 인덱스 반환
    - [x] 실패한 이동 기록
    - [x] 성공한 이동 기록
- [x] 이동 현황 반환
- [x] 이동 현황 초기화
---

## Constant
### (enum) GameStatus : 게임 진행 상황
- [x] 구현하기

### Moving : 이동 방향
- [x] 구현하기

### GameCommand : 게임 재시작 여부
- [x] 구현하기

### (enum) ErrorMessage : 에러 메시지
- [x] 구현하기

### BridgeRule : 다리 게임 규칙 관련 수
- [x] 구현하기
- [x] 랜덤 숫자를 이동 방향 값으로 변환
---