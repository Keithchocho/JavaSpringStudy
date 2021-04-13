package Keith.Keithproject.order;

import Keith.Keithproject.AppConfig;
import Keith.Keithproject.member.Grade;
import Keith.Keithproject.member.Member;
import Keith.Keithproject.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach //테스트를 실행하기 전에 무조건 실행
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1l;
        Member member=  new Member(memberId, "keith", Grade.VIP);
        memberService.join(member);

       Order order =  orderService.createOrder(memberId, "Milk", 3000);
       Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
       //Test 검증은 Assertions.org.assertj 로 합니다.

    }
}
