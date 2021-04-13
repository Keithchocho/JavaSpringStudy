package Keith.Keithproject;

import Keith.Keithproject.discount.FixDiscountPolicy;
import Keith.Keithproject.member.MemberService;
import Keith.Keithproject.member.MemberServiceImpl;
import Keith.Keithproject.member.MemoryMemberRepository;
import Keith.Keithproject.order.OrderService;
import Keith.Keithproject.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }



}
