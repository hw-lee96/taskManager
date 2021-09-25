#
## **[2021-09-20]**
1. tomak 프로젝트 참고하여 setup 진행
    - build.gradle, *.yml

2. gradle command
    - 프로젝트내 gradle 설치 : ` .\gradlew.bat `
    - 서버 실행 : ` .\gradlew bootRun `

3. setup
    - ` .\gradlew bootRun` 부터 돌림
        - 아래 에러 발생
        - ` FAILURE: Build failed with an exception. * Where: Build file 'C:\Users\melod\git\taskManager\taskManager\build.gradle' line: 27 * What went wrong: A problem occurred evaluating root project 'taskManager'. > Could not find method providedRuntime() for arguments [org.springframework.boot:spring-boot-starter-tomcat] on object of type org.gradle.api.internal.artifacts.dsl.dependencies.DefaultDependencyHandler. * Try: Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output. Run with --scan to get full insights. `

        - `providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat' ` 어노테이션 때문에 발생함. 예전에 war로 빌드하려고 추가했던 내용인데 이 부분을 사용하려면 plugins에 ` id 'war' ` 추가해줘야함
        
        - 현재는 해당 부분 제거하니까 `./gradlew bootRun ` 바로 진행됨
        - 8000으로 정상 구동 확인

4. db 세팅
    - 생성만함

    1. 로그인
        1. mariaDB command prompt 실행 후 `` mysql -u root -p `` 커맨드 입력
        2. password 입력

    2. database 확인
        - `` show databases; ``

    3.  database 생성
        - `` create database [db명]; ``
    
    4. db 사용 
        - `` use [db명]; ``
    
    5. 전체 table 확인
        - `` show tables; ``
    
    6. table 생성 예시
        - create table users (
            idx int(10) not null primary key,
            id char(150) not null,
            email char(200) not null,
            name char(150) not null,
            useyn char(1) not null default 'Y',
            insDate datetime not null default now(),
            updDate datetime null
        );
    
    7. insert 예시
        - insert into board (idx, title, content, insDate, updDate, userId) values (0, 'title1', 'content1', now(), null, 'user1');

5. restController.java 생성하여 메소드 호출 확인

6. DB랑 연결 후 회원가입 구현하면 됨
