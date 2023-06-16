package com.jpa.basic.repository;

import com.jpa.basic.entity.Member;
import com.jpa.basic.type.MemberType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class MemberDAOTests {

    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void saveTest(){
        Member member = new Member();
        member.setMemberName("LEE");
        member.setMemberEmail("fhfkfk7894@gmail.com");
        member.setMemberAge(22);
        member.setMemberPassword("1234");
        member.setMemberType(MemberType.MEMBER);
        memberDAO.save(member);
    }
}
