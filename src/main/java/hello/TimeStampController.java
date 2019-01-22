package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Calendar;
import java.text.SimpleDateFormat;

@Controller
public class TimeStampController {

    @GetMapping("/timestamp")
    public String timestamp(@RequestParam(name="name", required=false, defaultValue="Fella") String name, Model model) {
        model.addAttribute("name", name);
        String timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        model.addAttribute("date", timeStamp);
        return "timestamp";
    }

}