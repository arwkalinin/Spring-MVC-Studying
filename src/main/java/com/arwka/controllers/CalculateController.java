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
    public String calculateWithParams(@RequestParam("a") double a,
                                      @RequestParam("b") double b,
                                      @RequestParam("action") String action,
                                      Model model) {
        double result = 0;
        try {
            switch (action) {
                case "multiplication": result = a * b; break;
                case "addition": result = a + b; break;
                case "subtraction": result = a - b; break;
                case "division": result = a / b; break;
            }
        } finally {
            model.addAttribute("result", result);
        }
        return "calculator/calculate";
    }
}
