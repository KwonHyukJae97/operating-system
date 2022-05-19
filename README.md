
<h2>DB Info </h2>



<h2>local 환경 DB docker 구축 </h2>

``` shell 
 docker run -dit -p 5432:5432 \
 -v C:/Users/kwon/dev/storage/postgresql:/bitnami/postgresql \
 --name postgresql-master -e POSTGRESQL_USERNAME=arreokwon \
 -e POSTGRESQL_PASSWORD=arreokwon \
-e POSTGRESQL_DATABASE=omt bitnami/postgresql:latest
```

``` shell
docker run --name oracle11g1 -d -p 1521:1521 jaspeen/oracle-xe-11g
```

``` shell
docker run --name oracle11g2 -d -p 1522:1521 jaspeen/oracle-xe-11g
```

``` shell
docker run --name oracle11g3 -d -p 1523:1521 jaspeen/oracle-xe-11g
```


<h3>build command</h3>

``` shell
./gradlew build --exclude-task test
```

<h3>application-prod.yml 파일로 jar 배포하기 </h3>

```shell
*파일 경로는 미기제

``` shell
java -jar "-Dspring.profiles.active=prod" kr.co.seoultel.operation.management-0.0.1-SNAPSHOT.jar
```

<h3>DB 및 테이블 정보</h3>

```shell
1. 증액 
  - postgreSQL
    -limit_count_history (증액이력)
    -limit_count_threshold (적용중인 단가 및 사용여부 확인)
    -limit_count_status (현재 금액 상태 및 사용량 확인)
    -remote_block_user (원격 접속 차단 이력)
    -remote_status (원격 접속 현황)
    -remote_server_list (원격 서버 현황)
    -remote_user_list (원격 사용자 현황)
    
2. 라우팅 및 인증코드IP
  - Oracle
    -CMM_CDAUTH (라우팅 및 인증코드IP 관련)

3. 로우데이터 
  - Oracle
   -SMS_CMP_H (sms로우데이터) 
   -MMS_CMP_H (mms로우데이터)
   
4. 건수제한
  - Oracle
    -CMM_LIMIT_THRESHOLD (sms, lms 건수제한)
```    
