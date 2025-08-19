### Sharding
* user-service의 DB를 2개의 Mariadb(shard1, shard2)로 분리하여 저장한 다음, Sharding key를 구분하여 2개의 DB에 분산되어 저장하도록 처리
* 초기 테이블이가 shard1(또는 shard2)에만 생길 수 있기 때문에, 다른 쪽 shard에 수동으로 테이블 생성 필요
* 전체 데이트 조회하는 API는 2개의 DB에 분산되어 저장된 데이터를 모두 가져오도록 구현되어 있지 않았기 때문에, 한쪽의 데이터만 보임