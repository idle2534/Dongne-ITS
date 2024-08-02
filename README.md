Things to be aware of : 
1. build.gradle(백엔드)에서 프론트엔드 파일 디렉토리를 본인의 컴퓨터 파일 경로에 맞게 변경하세요.
2. 서버는 5173 포트에 있어야 합니다. 5174나 5175가 아닙니다.

데이터배이스 만드는 방법

1. 아래의 명령어로 데이터배이스 "summerproject" 만들기

CREATE DATABASE summerproject;

-------------------------------------
2. 아래의 명령어로 방금 만든 데이터배이스 안에 Table 만들기 

USE summerproject;

CREATE TABLE member (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sign_id VARCHAR(255),
    password VARCHAR(255),
    role ENUM('ADMIN', 'PL', 'DEV', 'TESTER'),
    name VARCHAR(255),
    is_deleted BOOLEAN
);

-----------------------------------------
3. 아래의 명령어로 방금 만든 Table 안에 ADMIN 계정 정보입력하기  (!!반드시 이걸 해야함! 이 방법외에 ADMIN 계정 생성방법없음!)

INSERT INTO member (id, sign_id, password, role, name, is_deleted) 
VALUES (1, 'admin', '1234', 'ADMIN', 'test', 0);

------------------------------------------
4.제대로 입력되었는지 확인하기

USE summerproject;
SELECT * FROM member;


앱 실행하는 방법

1. 백앤드를 먼저 실행 (반드시 백앤드 먼저 실행). "./gradlew bootRun" 이나 위에 초록색 "ItsApplication" 실행버튼 누름. 둘다 같은 기능.
2. 프론트앤드 실행. "npm run dev"
3. "http://localhost:5173"으로 접속
