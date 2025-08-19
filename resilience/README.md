### Resilience
* 서비스 간 통신에 오류가 발생하는 경우 장애 격리를 위한 작업
* 주문정보가 포함된 사용자 상세보기 요청을 위해, user-service에서 order-service를 호출하게 되는데, order-service에 문제가 발생할 경우에 대한 장애 격리 처리
    * retry, circuit breaker, bulk head, timeout, fallback 처리
    * service 메소드 내에서 다른 메소드를 호출하는 경우에는 Annotation으로 선언한 resilience 작업이 실행되지 않으며, 이를 처리하기 위한 별도의 클래스를 생성하여 작업 처리하도록 구현 (user-service 프로젝트의 OrderService.java)