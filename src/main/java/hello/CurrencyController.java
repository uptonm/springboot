package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CurrencyController {

    @RequestMapping("/currency/to/{to}/from/{from}")
    public String currency(@PathVariable("to") String to, @PathVariable("to") String from, Model model) {
        model.addAttribute("to", to);
        model.addAttribute("from", from);
        return "currency";
    }
}
