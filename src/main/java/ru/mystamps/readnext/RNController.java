import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Controller
@EnableAutoConfiguration
public class RNController {

    @RequestMapping("/")
    String home() {
        return "index.html";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RNController.class, args);
    }

}
