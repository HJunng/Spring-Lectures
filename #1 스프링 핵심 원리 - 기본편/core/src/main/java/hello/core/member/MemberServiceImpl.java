package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{
// 이 클래스 안에 MemoryMemberRespository에 대한 코드 없음.
// 오로지 Member Repository란 인터페이스만 있음!
// 구현체는 밖에(AppConfig)에서 생성해서 넣어준다.

    private final MemberRepository memberRepository;

    @Autowired // 자동 의존관계 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용.
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
