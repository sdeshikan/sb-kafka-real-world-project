# Spring Boot + Apache Kafka

> Use Apache Kafka as a broker to exchange messages between Producer and Consumer in Spring Boot Application, using Wikimedia recent changes Event Stream Data.

## Technical Implementation 
- Install and setup Apache Kafka
- Create and setup multi-module Spring Boot project
  1. Module 1: kafka-consumer-database
  2. Module 2: kafka-producer-wikimedia
- Create two Microservices

### Producer
- Configure Wikimedia Producer multi-level module and Create a Kafka Topic
- Implement Event Handler in Producer module
- Run and Test Wikimedia Producer Application 

### Consumer
- Configure Kafka Consumer 
- Implement Kafka Listener for a topic with groupId
- Run and Test Consumer Application

### MySql Database 
- Configure DB in application properties of Consumer and Producer Applications 
- Create Entity and JPA Repository 
- Save Wikimedia Data into MySQL Database 
