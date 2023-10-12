package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach // 테스트를 실행하기 전에 무조건 실행 되는거
    public void beforeConfig(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }


    //눈으로 보면서 확인하는 print를 사용하지 않고, 검증 테스트를 통해 확인함.
    @Test
    void join(){

        //given
        Member member = new Member(1L,"memberA",Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
