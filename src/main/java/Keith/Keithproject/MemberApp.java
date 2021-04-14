package Keith.Keithproject;

import Keith.Keithproject.member.Grade;
import Keith.Keithproject.member.Member;
import Keith.Keithproject.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
////        MemberService memberService = appConfig.memberService();


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService= applicationContext.getBean("memberService", MemberService.class);
        //AppConfig 에서 memberService 하이브 멤버 서비스(반환을)하겠다라는 말


        Member member = new Member(1l, "Keith", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = "  + findMember.getName());
    }
}
