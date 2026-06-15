package org.example;

import org.example.config.AppConfig;
import org.example.service.ArticleService;
import org.example.sub1.Greeting;
import org.example.sub1.Hello;
import org.example.sub1.Welcome;
import org.example.sub2.Computer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 날짜 : 2026/05/15
 * 이름 : 강채은
 * 내용 : 2장 스프링 Ioc/DI 실습
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        // 기존 전통적인 객체 생성
        Hello hello = new Hello();
        hello.show();

        Welcome welcome = new Welcome();
        welcome.show();

        Greeting greeting = new Greeting();
        greeting.show();

        // 스프링 컨테이너 생성
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 주입하기
        Hello helloBean = context.getBean(Hello.class);
        helloBean.show();


        Welcome welcomeBean = (Welcome) context.getBean("w"); //빈 name 값으로 가져오기
        welcomeBean.show();

        Greeting greetingBean = (Greeting) context.getBean("g");
        greetingBean.show();


        // IoC/DI 방식(피아의 역전)
        Computer dell = (Computer) context.getBean("dell");
        dell.show();


        //AOP 실습
        ArticleService service = context.getBean(ArticleService.class);

        System.out.println("----------------------------");
        service.register();
        System.out.println("----------------------------");
        service.getArticle(null);
        System.out.println("----------------------------");
    }
}
