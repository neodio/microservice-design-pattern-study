### EDA
* 서비스간 통신에서 API를 직접 호출하는 것이 아닌, 이벤트 발생/구독을 통해 처리하는 Event-Driven Architecture 사용
* JSON Schema 검증 방식을 이용하여 Kafka에 전송되는 메시지에 대해 버전 관리 및 검증 처리
* 기존 KafkaTemplate<String, Object>를 KafkaTemplate<String, String>로 변경
* Kafka에 메시지를 발송/수신할 떄 검증 처리 - order-created.schema.json

### Local 테스트 환경을 위한 docker compose
- 실행방법
  ```
  $ cd docker-eda
  $ docker-compose up -d
  ```

- 종료방법
  ```
  $ cd docker-eda
  $ docker-compose down -v
  ```