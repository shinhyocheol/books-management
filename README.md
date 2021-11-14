# 도서관리 API

## 개발 환경

- **edit tool**: eclips
- **language** : Java8
- **framework** : SpringBoot2.5.6
- **DB** : MySQL5.7, JPA/Hibernate
- **build**: gradle7
- **etc** : github, swagger2

---


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
    

    ![스크린샷 2021-11-14 오후 10.26.04.png](https://github.com/shinhyocheol/books-management/blob/master/screenshot.png)
    
    * 참고
        - 프로젝트가 실행되기 전 데이터베이스가 생성이됩니다.
        - 프로젝트가 실행되고 난 후 https://www.notion.so/farmskincosmeticcom/24de5d14a23d4d09abe62410f1da3fbe 데이터를 기반으로 카테고리, 책 데이터가 각각 등록이 한번씩 실행됩니다.
    
---

## API 문서(프로젝트 실행 후)

- api docs(swagger2-ui) :  [{HOST}:{PORT}/api/swagger-ui.html](http://localhost:8080/api/swagger-ui.html)

    ![스크린샷 2021-11-14 오후 10.26.04.png](https://github.com/shinhyocheol/books-management/blob/master/screenshot2.png)

