package Keith.Keithproject;

import Keith.Keithproject.discount.DiscountPolicy;
import Keith.Keithproject.discount.FixDiscountPolicy;
import Keith.Keithproject.discount.RateDiscountPolicy;
import Keith.Keithproject.member.MemberService;
import Keith.Keithproject.member.MemberServiceImpl;
import Keith.Keithproject.member.MemoryMemberRepository;
import Keith.Keithproject.order.OrderService;
import Keith.Keithproject.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), new FixDiscountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }



}
