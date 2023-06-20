# JPA 학습 전 필수 지식
### Spring IOC, Spring Bean, Spring container
### Configuration, @Bean, @Component, @Mapper, @Repository, @Service, @Controller
### 3-Tier(Persistence, Business, Presentation)
### Spring MVC(Front Controller Pattern)
### @RequestParam, @RequestBody, @ResponseBody, @RestController
### @Transactional
### AOP(핵심 로직에만 집중하도록(관점 지향), Proxy
### MultipartRequest




# JPA(Java Persistence API)
### JPA는 자바 진영에서 ORM(Object-Relational Mapping) 기술 표준으로 사용되는 인터페이스의 모음이다. 
### 다시 말해, 실제적으로 구현된것이 아니라 구현된 클래스와 매핑을 해주기 위해 사용되는 프레임워크이다. 
### JPA를 구현한 대표적인 오픈소스로는 Hibernate가 있다.

# ORM(Object-Realation Mapping)
### ORM은 개발자가 SQL 쿼리를 직접 작성하지 않고도 객체를 통해 데이터베이스에 접근하고 조작할 수 있도록 도와줍니다. 
### 객체와 데이터베이스 간의 변환 작업은 ORM 프레임워크가 자동으로 처리해주며, 
### 개발자는 객체 지향적인 코드를 작성함으로써 데이터베이스 조작을 추상화할 수 있습니다.




# Transaction
데이터 베이스의 상태를 변경하는 작업(한 번에 수행되어야 하는 연산 # commit을 자동으로 수행해주며, 예외 발생시 rollback 또한 자동으로 수행해준다.)

## 쉬운예시)
### 상황 : 뮤지컬 티켓을 예매하려는 데 한 자리 밖에 남지 않았을 때 두 명이 동시에 결제를 시도 했을 때
#### 결제는 다른 사람과 독립적으로 이루어지며, 과정에서 다른 연산이 끼어들 수 없다.
#### 오류가 생긴 경우 연산을 모두 취소하고 원래대로 되돌린다(rollback). 성공할 경우 결과를 반영한다.



## 원자성(Atomicity)
### 한 트렌잭션 내에서 실행한 작업들은 하나의 단위로 처리한다. 즉, 모두 성공 또는 모두 실패.

## 일관성(Consistency)
### 트렌잭션은 일관성 있는 데이터베이스 상태를 유지한다.

## 격리성(Isolation)
### 동시에 실행되는 트랜잭션들이 서로 영향을 미치지 않도록 격리해야한다.

## 영속성(Durability)
### 트랜잭션을 성공적으로 마치면 결과는 항상 저장되어야 한다.


