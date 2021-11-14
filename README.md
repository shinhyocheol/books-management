# 도서관리 API

## 개발 환경

- **edit tool**: eclips
- **language** : Java8
- **framework** : SpringBoot2.5.6
- **DB** : MySQL5.7, JPA/Hibernate
- **build**: gradle7
- **etc** : github, swagger2


## 프로젝트 실행

### 1. 프로젝트 소스 내려받기

- 프로젝트 아래명령어를 실행하여 프로젝트를 내려받습니다.
    
    ```bash
    git clone https://github.com/shinhyocheol/notice-management.git
    ```
    

### **2. 프로젝트 실행(Java 설치필수)**

- 프로젝트 루트경로로 이동 후 jar 파일(배포용) 생성
    
    ```bash
    $ ./gradlew bootJar						
    ```
    
- 생성파일이 위치한 곳으로 이동
    
    ```bash
    $ cd /build/libs
    ```
    
- jar 파일 실행(해당 API는 Java8버전에서 작성되었습니다.)s
    
    ```bash
    {jar파일 위치디렉토리} java -jar {생성된 파일}.jar  		
    ```
    
    ## **또는**
    
- 프로젝트 루트경로에서 배포파일 생성없이 바로 실행
    
    ```bash
    $ ./gradlew bootRun
    ```
    

![스크린샷 2021-11-14 오후 10.26.04.png](%E1%84%83%E1%85%A9%E1%84%89%E1%85%A5%E1%84%80%E1%85%AA%E1%86%AB%E1%84%85%E1%85%B5%20API%20c22503860d694294a32590f52e296542/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2021-11-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_10.26.04.png)

---

## API 문서(프로젝트 실행 후)

- api docs(swagger2-ui) :  [http://localhost:8080/api/swagger-ui.html](http://localhost:8080/api/swagger-ui.html)
