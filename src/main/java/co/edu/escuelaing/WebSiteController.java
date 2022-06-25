package co.edu.escuelaing;

import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebSiteController {

    @Resource
    private HttpServletRequest request;

    public static void main(String[] args) {
        SpringApplication.run(WebSiteController.class, args);
    }

    @GetMapping("/status")
    public String status() {
        sessionManagement();
        String name = (String) request.getSession().getAttribute("name");
        return "{\"status\":\"Greetings from Spring Boot "
                + name + ". " + java.time.LocalDate.now() + ", "
                + java.time.LocalTime.now()
                + ". " + "The server is Running!\"}";
    }

    @GetMapping("/delname")
    public void delName() {
        request.getSession().removeAttribute("name");
    }

    @GetMapping("/getnames")
    public String getNames() {
        Enumeration<String> nombres = request.getSession().getAttributeNames();
        System.out.println(nombres.nextElement());
        return "";
    }

    @GetMapping("/setname")
    public String setName(@RequestParam(value = "name", defaultValue = "Anónimo") String name) {
        request.getSession().setAttribute("name", name);
        return "{\"response\":\"Hello " + name + "!\"}";
    }

    @GetMapping("/getname")
    public String getName() {
        String name = (String) request.getSession().getAttribute("name");
        return "{\"name\":\"" + name + "\"}";
    }

    public void sessionManagement() {
        System.out.println(request.getSession(true).getId());
    }
}
