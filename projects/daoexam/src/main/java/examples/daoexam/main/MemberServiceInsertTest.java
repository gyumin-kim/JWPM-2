package examples.daoexam.main;

import examples.daoexam.config.ApplicationConfig;
import examples.daoexam.dto.Member;
import examples.daoexam.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class MemberServiceInsertTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MemberService memberService = context.getBean(MemberService.class);

        Member member = new Member();
        member.setId(1L);
        member.setName("Kim");
        member.setEmail("kim@gmail.com");
        member.setPassword("1234");
        member.setRegDate(new Date());

        Member result = memberService.addMember(member);
        System.out.println(result);
    }
}
