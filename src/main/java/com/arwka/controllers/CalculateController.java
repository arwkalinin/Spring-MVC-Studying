package com.arwka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculateController {

    @GetMapping("calculate")
    public String calculateWithParams(@RequestParam("a") int a,
                                      @RequestParam("b") int b,
                                      @RequestParam("action") String action,
                                      Model model) {
        int result = 0;
        switch (action) {
            case "multiplication": result = a * b; break;
            case "addition": result = a + b; break;
            case "subtraction": result = a - b; break;
            case "division": result = a / b; break;
        }
        model.addAttribute("result", result);
        return "calculator/calculate";
    }
}
