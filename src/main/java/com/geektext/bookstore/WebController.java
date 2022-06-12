package com.geektext.bookstore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    
    @RequestMapping("sample")
    public String mySample() {
        System.out.println("Opening sample page...");
        
        return "sample.html";
    }
    
}
