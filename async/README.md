### Asynchronous communications
* Kafka Broker를 사용하여 order-service와 shipping-service 사이의 데이터 동기화 처리
* user-service에서 주문을 요청하면 order-service에서 주문 데이터를 저장한 다음, 해당 주문 데이터를 Kafka Topic으로 전송
* shipping-service에서는 Kafka Topic에 전달 된 메시지를 가지고 배송 데이터로 저장

### Local 테스트 환경을 위한 docker compose
- 실행방법
  ```
  $ cd docker-async
  $ docker-compose up -d
  ```

- 종료방법
  ```
  $ cd docker-async
  $ docker-compose down -v
  ```