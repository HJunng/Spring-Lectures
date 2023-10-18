package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // 원래는 구체 클래스 타입으로 불러오는 것은 안 좋음. get메소드를 사용하기 위해 어쩔 수 없이 사용함.
        MemberServiceImpl memberService1 = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService1 = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService1.getMemberRepository();
        MemberRepository memberRepository2 = orderService1.getMemberRepository();

        /**
         * 확인하기 위한 출력 -> 3개 모두 같은 것을 확인 가능!!!
         * memberRepository는 3번 new로 호출되었으니 3개의 값 모두 다른 것이 정상 아닐까? 하지만 아님. why?
         */
        System.out.println("MemberService -> memberRepository1 = " + memberRepository1);
        System.out.println("OrderService -> memberRepository2  = " + memberRepository2);
        System.out.println("memberRepository                   = " + memberRepository);

        assertThat(memberRepository1).isSameAs(memberRepository2);
    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
    }
}