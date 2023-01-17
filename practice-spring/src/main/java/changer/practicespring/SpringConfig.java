package changer.practicespring;

import changer.practicespring.repository.MemberRepository;
import changer.practicespring.repository.MemoryMemberRepository;
import changer.practicespring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
