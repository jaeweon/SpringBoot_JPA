package com.jpa.basic.repository;

import com.jpa.basic.entity.Member;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class MemberDAO {

    @PersistenceContext
    private EntityManager entityManager;

    //  등록
    public Member save(Member member){
        entityManager.persist(member);
        return member;
    }

    // 조회
    public Optional<Member> findById(Long id){
        return Optional.ofNullable(entityManager.find(Member.class, id));
    }

    // 삭제
    public void delete(Member member){
        entityManager.remove(member);
    }


}
