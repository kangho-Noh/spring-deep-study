package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

     //AnnotationConfigApplicationContext로 사용하는 이유: ApplicationContext에는 getBean 함수가 없음. Annotation-이 더 하위 구현체라 함수가 더 많다.
     AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

     @Test
     @DisplayName("빈 이름으로 조회")
     void findBeanByName(){
         MemberService memberService = ac.getBean("memberService", MemberService.class);
         assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
     }

     @Test
     @DisplayName("이름 없이 타입으로만 조회")
     void findBeanByType(){
          MemberService memberService = ac.getBean(MemberService.class);
          assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
     }

     @Test
     @DisplayName("구체 타입으로 조회")
     void findBeanByName2(){
          //역할에 의존해야하기 때문에 좋은 코드는 아니다. 유연성이 떨어진다. 그래도 언젠가 사용할 수 있으므로 알아두기.
          MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
          assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
     }

     //실패 케이스에 대한 테스트케이스도 존재해야한다.
     @Test
     @DisplayName("빈 이름으로 조회 x")
     void findBeanByNameX(){
          //ac.getBean("xxxxx", MemberService.class);
          assertThrows(NoSuchBeanDefinitionException.class,
                  () -> ac.getBean("xxxxx", MemberService.class)); //assertThrows는 junit Assertions에 있다. 람다식이 실행됐을 때 저 예외가 터지면 테스트 성공.
     }
}
