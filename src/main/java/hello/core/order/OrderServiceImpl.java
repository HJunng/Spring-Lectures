package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    // 멤버 찾아야 되니까 repository 필요.
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //고청 할인 정책
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        //단일 책임의 원칙 잘 지킨 것!
        // 주문 시스템은 할인 몰라 -> discountPolicy 너가 해.
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    
    
}
