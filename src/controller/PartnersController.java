package controller;

import org.springframework.beans.factory.annotation.Autowired;
import service.PartnersService;

@RestController
@RequestMapping("/api/v1/")
public class PartnersController {
    @Autowired
    private PartnersService partnersService;
}
