package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Calendar;
import java.text.SimpleDateFormat;

@Controller
public class ErrorPageController {

    @GetMapping("/**")
    public String error(Model model) {
        return "error";
    }

}