package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositorytest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // System.out.println("result = " + (result == member));
        // Assertions.assertEquals(member, result); 성공했을때 예시
        // Assertions.assertEquals(member, null); 실패했을때 예시

        // Assertions.assertThat(member).isEqualTo(result); 요즘 많이 사용하고 있는 방법
        // assertThat(member).isEqualTo(result); Alt + Enter 하게되면 Assertions 생략된다.
        assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        // Tip : Shift + F6 하게되면 한번에 1 -> 2로 변경가능
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);

    }
}
