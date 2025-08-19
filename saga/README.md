### SAGA
* 분산 트랜잭션에서 오류 발생 시 처리 작업을 이전으로 돌리기 위한(Roll back) 보상 트랜잭션 처리
* user-service에서 주문을 요청하면 order-service에서 주문 데이터를 저장
* order-service에서는 주문 데이터를 Kafka Topic으로 전송
* payment-service에서는 Kafka Topic에 전달 된 메시지를 가지고 결제 처리 프로세스 시작, 결제 결과를 Kafka Topic으로 전송
    * 결제가 실패 되었을 때는 Kafka Topic에 실패 메시지를 전달
* shipping-service에서
    * 결제가 성공 되었을 때, "배송 시작" 상태로 변경
    * 결제가 실패 되었을 때, Kafka Topic에 실패 메시지를 전달하고 상태를 "실패"로 변경