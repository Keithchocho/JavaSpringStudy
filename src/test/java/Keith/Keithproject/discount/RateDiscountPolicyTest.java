package Keith.Keithproject.discount;

import Keith.Keithproject.member.Grade;
import Keith.Keithproject.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%g할인이 적용 되어야 한다!!")
    void vip_o(){
        //given
        Member member = new Member(1l,"Keith Cho_VIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //than
        assertThat(discount).isEqualTo(1000); //JAVA에서는 assertions를 static에 붙여 사용하는게 좋음 ALt + enter 두번째꺼
    }

    @Test
    @DisplayName("NONe VIP는 10%g할인이 적용 안된다!!")
    void vip_x(){
        //given
        Member member = new Member(2l,"Jays Cho_Basic", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //than
        assertThat(discount).isEqualTo(0);
    }

}