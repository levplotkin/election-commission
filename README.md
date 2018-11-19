# election-commission
Fuse: Kafka streams


Download confluent distribution
https://www.confluent.io/product/confluent-open-source/

https://docs.confluent.io/current/quickstart/cos-quickstart.html#cos-quickstart

Run ‘./confluent start’ from ‘bin’ folder

./kafka-console-consumer --topic vote --bootstrap-server   localhost:9092

Run ‘./confluent status’

control-center is [UP]
ksql-server is [UP]
connect is [UP]
kafka-rest is [UP]
schema-registry is [UP]
kafka is [UP]
zookeeper is [UP]

Control-center URL : http://localhost:9021

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
