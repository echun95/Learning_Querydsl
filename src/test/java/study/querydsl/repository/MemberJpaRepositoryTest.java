package study.querydsl.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.entity.Member;

import javax.persistence.EntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberJpaRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Test
    public void basicTest() throws Exception  {
        //given
        Member member1 = new Member("member1", 10);
        memberJpaRepository.save(member1);


        //when
        Member findMember = memberJpaRepository.findById(member1.getId()).get();
        List<Member> result = memberJpaRepository.findAll_Querydsl();
        List<Member> result2 = memberJpaRepository.findByUsername_Querydsl("member1");
        //then
        assertThat(findMember).isEqualTo(member1);
        assertThat(result).containsExactly(member1);
        assertThat(result2).containsExactly(member1);
    }


}