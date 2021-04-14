package Keith.Keithproject;

import Keith.Keithproject.member.Grade;
import Keith.Keithproject.member.Member;
import Keith.Keithproject.member.MemberService;
import Keith.Keithproject.order.Order;
import Keith.Keithproject.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class OrderApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId =  1L;
        Member member = new Member(memberId, "Keith", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "ItemA", 10000);
        System.out.println("order = " + order);

    }
}
