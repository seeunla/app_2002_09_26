package com.ll.exam.app_2022_09_22.app.base;

import com.ll.exam.app_2022_09_22.app.member.entity.Member;
import com.ll.exam.app_2022_09_22.app.member.service.MemberService;
import com.ll.exam.app_2022_09_22.app.product.entity.ProductOption;
import com.ll.exam.app_2022_09_22.app.product.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;


@Configuration
@Profile("dev")
public class DevInitData {
    public CommandLineRunner initData(MemberService memberService, ProductService productService ) {
        return args ->
        {
            String password= "{noop}1234";

            Member member1 = memberService.join("user1", password, "user1@test.com");
            Member member2 = memberService.join("user2", password, "user2@test.com");
            Member member3 = memberService.join("user3", password, "user3@test.com");
            Member member4 = memberService.join("user4", password, "user4@test.com");

            productService.create("단가라 OPS", 65000, "청평화 A-1-15", Arrays.asList(new ProductOption("RED", "44"), new ProductOption("BLUE", "44")));
        };
    }
}
