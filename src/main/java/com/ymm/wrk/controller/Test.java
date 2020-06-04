package com.ymm.wrk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class Test {
        @RequestMapping("/wrk")
        @ResponseBody
        public long busy() {
            int i=0;
            int sum =0;
            long min=1;
            long max=10000;
            long num = min + (long)(Math.random() * (max-min+1)) + 500000;
            while(i<num) {
                i++;
                sum+=i;
            }
            return sum;
        }

        @RequestMapping("/fab")
        @ResponseBody
        public long  fab(){
            long min=1;
            long max=10000;
            long num = min + (long)(Math.random() * (max-min+1)) + 10000;
//            System.out.println(num);
            long num1 = 1;
            long num2 = 1;
            long num3 = 0;
            for (int i = 1; i < num; i++) {
                num3 = num1 + num2;
                num1 = num2;
                num2 = num3;
            }
            return num3;
        }
}
