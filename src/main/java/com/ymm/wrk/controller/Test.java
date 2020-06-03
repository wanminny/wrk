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
        public int letCpuBusy() {
            int i=0;
            int sum =0;
            while(i<10000) {
                i++;
                sum+=i;
            }
            return sum;
        }
}
