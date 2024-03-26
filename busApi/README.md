# 화면별 필요한 기능

## 회원가입
- [ ] 아이디와 비밀번호 전달
  - [ ] 비밀번호 jwt로 암호화
  - [ ] `school_id` 정수형 확인
  - [ ] `email` 중복 확인
  - [ ] 일반 회원가입 `role` &rarr; 3

## 로그인 
- [ ] 아이디와 비밀번호 전달
  - [ ] 비밀번호 일치하면 토큰 발행

## 메인화면
- [ ] `user` 이름
- [ ] 해당 `user`의 관심노선 ㄱㄴㄷ 순으로 정렬

## 게시판
- [ ] __내가 쓴 글__ &rarr; `post` 테이블에서 `user_id` 검색후 반환
- [ ] `공지사항`을 누르면 `post_type`이 1인 게시글 가져오기
- [ ] `분실물 게시판`을 누르면 `post_type`이 2인 게시글 가져오기
- [ ] `자유게시판`을 누르면 `post_type`이 3인 게시글 가져오기
  - [ ] 게시글을 누르면 해당 게시글의 내용과 댓글 가져오기
  - [ ] 이미지는 어떻게 저장할지 생각해봐야할 듯
  - [ ] api 호출 시 조회수 1 증가

### 글쓰기
- [ ] 제목, 내용, `post_type` 전달 후 저장
- [ ] 이미지는 어떻게??

## 셔틀버스
- [ ] 메인화면에서 `셔틀 버스`를 누르면 `bus` 테이블의 모든 셔틀 가져오기
- [ ] 관심노선에서는 해당 사용자가 __북마크__ 해둔 노선 가져오기
- [ ] 선택한 노선과 운행일에 해당하는 셔틀의 정보를 불러옴 &rarr; 요일도 필요할듯
- [ ] 현재위치는 어떻게??

## 아이디 찾기
[ ] 이메일과 이름 전달
[ ] 일치하는 개체의 user_id 출력

## 비밀번호 찾기
[ ] 이메일과 이름, 아이디전달
[ ] 일치하는 개체가 존재할 시 password를 새로 입력받아 UPDATE

## 버스 도착 알림
[ ] 현재위치와 arrival-station위치가 같아질 경우 해당 bus_id 전달
[ ] 해당 bus_id의 arrival_Time, 목적지 가져오기


## 변경

## 게시판
[ ] 공지사항을 누르면 post_type이 1인 게시글/의 post_TIME 내림차순으로 정렬해/ 가져오기
[ ] 분실물 게시판을 누르면 post_type이 2인 게시글/의 post_TIME 내림차순으로 정렬해/ 가져오기
[ ] 자유게시판을 누르면 post_type이 3인 게시글/의 post_TIME 내림차순으로 정렬해/ 가져오기
[ ] 게시글을 누르면 해당 게시글의 내용과 댓글/, post_TIME/ 가져오기

## 글쓰기
[ ] 글 저장 시 post_TIME에 현재 시간을 저장