package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;


//스프링 코드가 1도 없는 순수한 자바로 짠 테스트코드
//메인 메서드로 테스트하는 것은 한계가 있다.
//그래서 JUnit 이라는 테스트 프레임워크를 사용한다.
public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);// Long타입 1L 아니고 1치면 오류남
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
