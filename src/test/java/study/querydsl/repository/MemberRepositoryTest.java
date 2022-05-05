package study.querydsl.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.entity.Member;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void basicTest() throws Exception  {
        //given
        Member member1 = new Member("member1", 10);
        memberRepository.save(member1);

        //when
        Member findMember = memberRepository.findById(member1.getId()).get();
        List<Member> result = memberRepository.findAll();
        List<Member> result2 = memberRepository.findByUsername("member1");
        //then
        assertThat(findMember).isEqualTo(member1);
        assertThat(result).containsExactly(member1);
        assertThat(result2).containsExactly(member1);
    }

    @Test
    public void findMemberTeam() throws Exception  {
        //given
        memberRepository.findMemberTeam();
        //when

        //then
    }
}