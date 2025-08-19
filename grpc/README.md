### MSA Communications Samples(gprc)
* user-esrvice와 order-service 간의 통신에 대한 샘플 코드
* user-service에서 사용자 ID에 대한 상세 정보 조회 시 order-service로부터 사용자가 주문한 주문 목록을 가져오기
> * gRPC API 사용
  >  * OrderGrpcService 오류 발생 시
  >    * target/generated-sources 폴더에 OrderServiceGrpc 클래스가 생성되어 있는지 확인
  >      * OrderServiceGrpc.java, OrderRequest.java, OrderResponse.java, Order.java
  >    * IDE 등에서 소스 코드 인식 (IntellIJ IDEA 예시)
  >      *  프로젝트에서 우측 클릭 -> Maven 탭 -> Reload Project
  >      *  File -> Invalidate Caches -> Restart
  >      * IntelliJ에서 target/generated-sources/protobuf 폴더를 우클릭 후, Mark Directory as → Generated Sources Root 설정