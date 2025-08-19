### Observability
* 서비스 간에 발생되는 로그를 Fluend 서비스에 통합하여 처리
* user-service, order-service, payment-service, shipping-service의 로그를 fluentd-central에 저장
* fluentd-central에서 마이크로서비스의 모든 로그를 관리
* zipkin을 이용하여 정보 수집