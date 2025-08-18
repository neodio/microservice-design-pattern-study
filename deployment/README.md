### Deployment
* 마이크로서비스 배포 전략
* order-service에 대해 Blue-Green, Canary, AB Test에 대해 배포 예제
    * docker-compose + nginx 조합으로 배포 테스트

* order-service v1 build
- intellij에서 build > build
- 터미널로 빌드
```
$ ./gradlew build
```

* order-service v1 docker 이미지 생성
```
$ docker build --tag enterfive/order-service:v1 -f Dockerfile .
```

* order-service v2 build
- intellij에서 build > build
- 터미널로 빌드
```
$ ./gradlew build
```

* order-service v2 docker 이미지 생성
```
$ docker build --tag enterfive/order-service:v2 -f Dockerfile .
```

* order-service docker 이미지 생성 확인
```
$ docker images | grep order-service
```
