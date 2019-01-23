package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CurrencyController {

    @RequestMapping("/currency/to/{to}/from/{from}")
    public String currency(@PathVariable("to") String to, @PathVariable("from") String from,
            @RequestParam("value") double value, Model model) {
        String conversion = convert(to, from, value);
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
                return "EUR: €" + value + "   GPB: £" + (value * 0.87200);
            }
        } else if (from.equals("GBP")) {
            switch (to) {
            case "USD":
                return "GBP: £" + value + "   USD: $" + (value * 1.30);
            case "EUR":
                return "GBP: £" + value + "   EUR: €" + (value * 1.15);
            }
        }
        return "Working on it";
    }
}
