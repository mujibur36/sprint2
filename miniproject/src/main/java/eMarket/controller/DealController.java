package eMarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deal")
public class DealController {
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
    		binder.addValidators(new DealValidator());
    }
    
    // TODO: implement handler methods
}
