package controller;

import org.springframework.beans.factory.annotation.Autowired;
import service.RawService;

@RestController
@RequestMapping("/api/v1/")
public class RawController {
    @Autowired
    private RawService rawService;
}
