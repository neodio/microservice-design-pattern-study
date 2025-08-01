# create-topics.sh
#!/bin/bash
# Wait for Kafka to be ready (optional, but recommended)
cub kafka-ready -b kafka:9092 10
kafka-topics --create --topic my-scripted-topic --bootstrap-server kafka:9092 --replication-factor 1 --partitions 1
sleep infinity # Keep the container alive if it's a dedicated service
