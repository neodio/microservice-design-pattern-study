### CQRS + Event Sourcing
* CQRS를 이용하여 Command 작업과 Query 작업을 분리하고, 데이터 상태 변경을 Event Store(DB)에 저장
> * cqrs1 프로젝트
* user-service에서 주문을 요청하면 order-service에서 주문 데이터를 저장할 때, 기존의 Orders 테이블에 저장하는 것 대신, Order_event 테이블에 상태를 기록
* 주문 내용에 대해 추가 및 수정 작업에 대해 Event sourcing 작업 처리
* 사용자 상세정보 요청 시, 주문목록을 표시할 때 Event Store에 기록 된 상태를 Replay하여 데이터의 최종값 결정
> * cqrs2 프로젝트
* order-service에서 주문 데이터를 저장한 다음, ApplicationEventPublisher를 이용한 OrderEvent를 발행
* OrderEvent는 @EventListener로 등록 된 서비스가 Consumer로써 메시지를 소비할 수 있도록 처리