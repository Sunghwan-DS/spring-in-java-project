package jsh.spring.app;

import jsh.spring.member.infra.MemberService;
import jsh.spring.member.infra.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class InquirySpringBeanTest {

    @Autowired
    ApplicationContext ac;

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + "object = " + bean);
        }
    }

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberServiceImpl", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로만 조회")
    void findBeanByType2() {
        MemberService memberService = ac.getBean(MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 실패")
    void findBeanByNameFail() {
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("failName", MemberService.class));
    }

    @Test
    @DisplayName("@Repository 어노테이션이 붙은 빈 모두 조회")
    void findAllRepositoryBean() {
        Map<String, Object> repositoryBeans = ac.getBeansWithAnnotation(Repository.class);

        for (Map.Entry<String, Object> entry : repositoryBeans.entrySet()) {
            String beanName = entry.getKey();
            Object beanInstance = entry.getValue();

            System.out.println("Bean Name : " + beanName + " Bean Type : " + beanInstance.getClass().getName());
        }
    }
}
