# 기능 구현 목록

## UI
### InputView
- [x] 메인 화면 기능 입력
- [x] 경로 조회 기능 입력
- [x] 출발역 입력
- [x] 도착역 입력

### OutputView
- [x] 메인 화면 기능 목록 출력
- [x] 경로 조회 기능 목록 출력
- [x] 조회 결과 출력
- [x] 에러 메시지 출력
---

## Controller
### SubwayController
- [x] 초기 세팅
- [x] 결과 출력
---

## Domain
### Subway
- [x] 초기 세팅
- [x] 경로 불러오기
- [x] 경로 가중치 합 불러오기

### Station
- [x] 생성

### StationRepository
- [x] 역 저장
- [x] 역 전체 불러오기
- [x] 역 불러오기
- [x] 역 삭제
- [x] 역 전체 삭제

### Line
- [x] 생성

### LineRepository
- [x] 노선 저장
- [x] 노선 전체 불러오기
- [x] 노선 삭제
- [x] 노선 전체 삭제

### PathGraph
- [x] 생성
- [x] 경로 저장
- [x] 경로에 있는 값들 불러오기
- [x] 경로의 가중치 합 계산

### PathGraphRepository
- [x] 경로 그래프 저장
- [x] 경로 정보 저장
- [x] 경로 그래프 불러오기

### PathInfo (Value Object)
- [x] 생성
- [x] 값 설정
- [x] 값 반환

### PathResult (Value Object)
- [x] 생성
- [x] 값 반환
---

## Constant
### MainCommand
- [x] 기능 메시지 반환
- [x] 입력 커맨드에 맞는 값 반환
  - [x] 입력 커맨드와 값의 커맨드가 같은지 반환

### PathCommand
- [x] 기능 메시지 반환
- [x] 입력 커맨드에 맞는 값 반환
    - [x] 입력 커맨드와 값의 커맨드가 같은지 반환
---

## 예외 사항 사전 정리
- [ ] 거리 양의 정수
- [ ] 소요 시간 양의 정수
- [ ] 경로 조회 시 출발역과 도착역이 같으면 에러 출력
- [ ] 경로 조회 시 출발역과 도착역이 연결되어 있지 않으면 에러 출력
---