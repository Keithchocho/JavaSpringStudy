package Keith.Keithproject;

import Keith.Keithproject.member.Grade;
import Keith.Keithproject.member.Member;
import Keith.Keithproject.member.MemberService;


public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1l, "Keith", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = "  + findMember.getName());
    }
}
