# election-commission
## Fuse: Kafka streams

###Prerequisites:

Download confluent distribution
https://www.confluent.io/product/confluent-open-source/

https://docs.confluent.io/current/quickstart/cos-quickstart.html#cos-quickstart

Run `./confluent start` from `bin` folder

Run `./confluent status`
```
control-center is [UP]
ksql-server is [UP]
connect is [UP]
kafka-rest is [UP]
schema-registry is [UP]
kafka is [UP]
zookeeper is [UP]
```

Control-center URL : http://localhost:9021
Swagger URL: http://localhost:9000/swagger-ui.html

Guidelines

We will develop polling system based on ‘Twin’ approach: 
http://people.csail.mit.edu/rivest/RivestSmith-ThreeVotingProtocolsThreeBallotVAVAndTwin.pdf

Topics will be used:
List of candidates
Voters list (sha from ssn + salt )
Raw votes
Signed votes 
Voter anonymized metadata (age, education, address, income,  num of children ...)

Queries:
Voters statistics
Participation rate and distributions
Votes rate and distributions

```
./kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1  --topic vote
./kafka-topics --delete --topic vote --zookeeper localhost:2181
./confluent destroy
./kafka-console-consumer --topic vote --bootstrap-server   localhost:9092
./kafka-topics --list --zookeeper localhost:2181

# working with string messages:
cat votes.json | ./kafka-console-producer --broker-list localhost:9092 --topic vote
```