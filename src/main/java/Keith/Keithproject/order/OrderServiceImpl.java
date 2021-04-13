package Keith.Keithproject.order;

import Keith.Keithproject.discount.DiscountPolicy;
import Keith.Keithproject.discount.FixDiscountPolicy;
import Keith.Keithproject.member.Member;
import Keith.Keithproject.member.MemberRepository;
import Keith.Keithproject.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //주문이 들어오면!!
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);  // 1. 회원정보를 확인하고
        int discountPrice = discountPolicy.discount(member,itemPrice); // 2. 할인정책에 회원정보를 넘긴다!!


        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
