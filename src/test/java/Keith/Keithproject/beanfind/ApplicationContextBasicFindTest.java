package Keith.Keithproject.beanfind;

import Keith.Keithproject.AppConfig;
import Keith.Keithproject.member.MemberService;
import Keith.Keithproject.member.MemberServiceImpl;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        //이름 지우고 타입으로만 검색 가능
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    //유연성이 떨어지는 단점을 가지고 있음
    void findBeanByName2(){
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByNameX(){
        //ac.getBean("XXXXX", MemberService.class);
//        MemberService xxxxx = ac.getBean("XXXXX", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("XXXXX",MemberService.class));
        //람다함수를 이용해서 위 코드를 실행시켜봤다
    }
}


