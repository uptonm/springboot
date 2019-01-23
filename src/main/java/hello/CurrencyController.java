package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CurrencyController {

    @RequestMapping("/currency/to/{to}/from/{from}")
    public String currency(@PathVariable("to") String to, @PathVariable("from") String from, Model model) {
        String conversion = convert(to, from, 50);
        model.addAttribute("to", to);
        model.addAttribute("from", from);
        model.addAttribute("result", conversion);
        return "currency";
    }

    public String convert(String to, String from, double value) {
        if (from.equals("USD")) {
            switch (to) {
            case "EUR":
                return "USD: $" + value + "   EUR: €" + (value * 0.87970);
            case "GBP":
                return "USD: $" + value + "   GBP: £" + (value * 0.767161);
            }
        } else if (from.equals("EUR")) {
            switch (to) {
            case "USD":
                return "EUR: €" + value + "   USD: $" + (value * 1.136501);
            case "GBP":
                return "EUR: €" + value + "   EUR: €" + (value * 0.87200);
            }
        }
        return "Working on it";
    }
}
