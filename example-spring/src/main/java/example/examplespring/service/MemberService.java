package example.examplespring.service;

import example.examplespring.domain.Member;
import example.examplespring.repository.MemberRepository;
import example.examplespring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        validateExistingMember(member); // 이름 중복 회원 X
        memberRepository.save(member);
        return member.getId();
    }

    private void validateExistingMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOneById(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public Optional<Member> findOneByName(String name) {
        return memberRepository.findByName(name);
    }
}
