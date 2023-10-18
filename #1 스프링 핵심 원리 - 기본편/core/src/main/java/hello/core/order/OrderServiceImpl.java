package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    //final은 초기화할때던 생성자를 사용하던 값을 무조건 부여해 줘야 한다.!
    // 멤버 찾아야 되니까 repository 필요.
    private final MemberRepository memberRepository;
    //고정 할인 정책
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private DiscountPolicy discountPolicy; // 인터페이스만 의존하도록 설계와 코드 변경.

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        //단일 책임의 원칙 잘 지킨 것!
        // 주문 시스템은 할인 몰라 -> discountPolicy 너가 해.
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    
    // 테스트용
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

}
