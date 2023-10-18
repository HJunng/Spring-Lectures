package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *  애플리케이션에 대한 설정은 모두 다 AppConfig가 하는 것.!!!
 */
@Configuration // 설정정보, 구성 정보 등록
public class AppConfig { // 나의 애플리케이션 전체를 설정하고 구성한다는 뜻

    @Bean // 스프링 컨테이너에 등록한다.
    public MemberService memberService(){
        return new MemberServiceImpl(getMemberRepository());
    }

    @Bean
    public static MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(getMemberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
