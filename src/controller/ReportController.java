package controller;

import org.springframework.beans.factory.annotation.Autowired;
import service.ReportService;

@RestController
@RequestMapping("/api/v1/")
public class ReportController {
    @Autowired
    private ReportService reportService;
}
