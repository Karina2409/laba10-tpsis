package controller;

import entity.Product;
import entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import service.ReportService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/report")
    public List<Report> getAllReport(){
        return reportService.listReport();
    }

    @GetMapping("/report")
    public Report getReportByName(String name) {
        return reportService.getReportByName(name);
    }

    @PostMapping("/report")
    public void addReport(Report report){reportService.createReport(report);}

    @PostMapping("/report")
    public void deleteReport(Long id){
        reportService.deleteReport(id);
    }
}
