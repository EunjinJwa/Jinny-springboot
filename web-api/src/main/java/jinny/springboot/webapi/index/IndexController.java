package jinny.springboot.webapi.index;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @GetMapping
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello!", HttpStatus.OK);
    }
}
