package Keith.Keithproject.order;

import Keith.Keithproject.discount.DiscountPolicy;
import Keith.Keithproject.discount.FixDiscountPolicy;
import Keith.Keithproject.member.Member;
import Keith.Keithproject.member.MemberRepository;
import Keith.Keithproject.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor //Ctrl +F12 = final 이 붙은 필드를 모아서 생성자를 자동으로 만들어줌(룸북의 기능임)
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;



    //주문이 들어오면!!
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);  // 1. 회원정보를 확인하고
        int discountPrice = discountPolicy.discount(member,itemPrice); // 2. 할인정책에 회원정보를 넘긴다!!


        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


    //테스트 용도
    public MemberRepository getMemberRepository() {

        return memberRepository;
    }
}

