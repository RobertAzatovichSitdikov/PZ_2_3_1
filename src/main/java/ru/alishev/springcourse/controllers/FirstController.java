package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(/*HttpServletRequest request*/
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "surname", required = false) String surname,
            Model model) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");

//        System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {


        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(name = "a", required = false) int a,
                                 @RequestParam(name = "b", required = false) int b,
                                 @RequestParam(name = "action", required = false) String action,
                                 Model model) {
        switch (action) {
            case "multiplication":
                model.addAttribute("result", a*b);
                break;
            case "addition":
                model.addAttribute("result", a+b);
                break;
            case "substraction":
                model.addAttribute("result", a-b);
                break;
            case "division":
                model.addAttribute("result", a/(double)b);
                break;
            default:
                model.addAttribute("result", 0);
                break;
        }
        return "first/calculator";
    }
}
