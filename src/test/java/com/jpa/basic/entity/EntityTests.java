package com.jpa.basic.entity;

import com.jpa.basic.type.MemberType;
import com.jpa.basic.type.SuperCarType;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class EntityTests {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    @Rollback(false)
    public void memberEntityTest(){
        Member member1 = new Member();
//        Member member2 = new Member();
//
        member1.setMemberName("LEE");
        member1.setMemberEmail("fhfkfk7894@gmail.com");
        member1.setMemberAge(20);
        member1.setMemberPassword("1234");
        member1.setMemberType(MemberType.MEMBER);

//        member2.setMemberName("홍길동");
//        member2.setMemberEmail("hgd9999@gmail.com");
//        member2.setMemberAge(40);
//        member2.setMemberPassword("9999");
//        member2.setMemberType(MemberType.ADMIN);

        entityManager.persist(member1);
//        entityManager.persist(member2);

        Member foundMember1 = entityManager.find(Member.class, 25L);
//        1차 캐시에 조회된 엔티티가 이미 있다면, SQL 조회 없이 1차 캐시에서 가져온다.
        final Member foundMember2 = entityManager.find(Member.class, 25L);

//        1차 캐시에 등록된 엔티티가 있다면, 동일성이 보장된다.
        assertThat(foundMember1).isEqualTo(foundMember2);
        log.info("result: {}", foundMember1 == foundMember2);

//        변경 감지
        foundMember1.setMemberAge(30);

//        1차 캐시는 그대로 유지하되, 쓰기 지연 저장소에 있었던 SQL을 즉시 DB로 전송
//        commit() 전에 실행하고자 할 때 사용한다.
        entityManager.flush();

//        1차 캐시 전체 삭제
//        update 쿼리 이전에 clear()가 실행되기 때문에 flush() 후 clear()를 진행해야 한다.
//        clear()는 commit() 전에 실행되기 때문이다.
        entityManager.clear();

        foundMember1 = entityManager.find(Member.class, 25L);

//        entityManager.clear();

        entityManager.remove(foundMember1);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void superCarEntityTest(){
        SuperCar superCar1 = new SuperCar();

        superCar1.setSuperCarBrand("BENZ");
        superCar1.setSuperCarColor("BLACK");
        superCar1.setSuperCarPrice(10000000L);
        superCar1.setSuperCarName("E300");
        superCar1.setSuperCarType(SuperCarType.BENZ);
//        entityManager.persist(superCar1);

        SuperCar foundSuperCar1 = entityManager.find(SuperCar.class, 8L);
        entityManager.remove(foundSuperCar1);
    }
}

















