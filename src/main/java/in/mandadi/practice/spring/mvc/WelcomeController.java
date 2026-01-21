package in.mandadi.practice.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/welcome")
public class WelcomeController {

    @Autowired
    private PrototypeService prototypeService;

    @GetMapping
    public String testActive(){
        prototypeService.printCount();
        return "Application is active";
    }
}
