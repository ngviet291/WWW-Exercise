package _3660721_nguyentranquocviet_tuan6_jdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() { return "redirect:/employees"; }
}
