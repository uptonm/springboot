package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Fella") String name, @RequestParam(name="sex", required=false, defaultValue="Male") String sex, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("sex", sex);
        return "greeting";
    }

}