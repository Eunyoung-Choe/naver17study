//json 형태로 출력됨
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"controller.test", "lombok.test"}) //여러개 추가할 경우 {}안에 넣어서 출력
@ComponentScan("*.test") // wild card도 가능
@ComponentScan("bitcamp.study")
public class SpringMvc1Application {

   public static void main(String[] args) {
      SpringApplication.run(SpringMvc1Application.class, args);
   }

}
