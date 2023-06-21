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


# 상속관계(mapping)
객체는 상속관계가 존재하지만, 관계형 데이터베이스(RDBMS)에서는 상속 관계가 없다.
슈퍼키 서브키 관계 모델링 기법이 객체 상속과 유사하다.
상속관계 매핑이라는 것은 객체의 상속 구조와 DB의 슈퍼키, 서브키 관계를 매핑하는 것이다.

-> 구현 방법
객체는 상속을 지원하므로 모델링과 구현이 똑같지만, DB는 상속을 지원하지 않으므로 논리 모델을 물리 모델로 구현할 방법이 필요하다.
DB의 슈퍼키, 서브키 논리 모델은 실제 물리 모델로 구현하는 방법은 세가지가 있다.
이때 중요한 것은 DB입장에서 3가지로 구현하지만 JPA에서는 어떤 방식을 선택하던 매핑이 가능하다.
-> JPA 매핑 
@Inheritance(strategy=InheritanceType.XXX)의 stategy를 설정해주면 된다.
default 전략은 SINGLE_TABLE(단일 테이블 전략)이다.
InheritanceType 종류
JOINED
SINGLE_TABLE
TABLE_PER_CLASS

@DiscriminatorColumn(name="DTYPE")
부모 클래스에 선언한다. 하위 클래스를 구분하는 용도의 컬럼이다. 관례는 default = DTYPE
@DiscriminatorValue("XXX")
하위 클래스에 선언한다. 엔티티를 저장할 때 슈퍼타입의 구분 컬럼에 저장할 값을 지정한다.
어노테이션을 선언하지 않을 경우 기본값으로 클래스 이름이 들어간다.
