package controller;

import entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import partner.ReportService;

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

    @GetMapping("/report/report-by-name/{name}")
    public Report getReportByName(String name) {
        return reportService.getReportByName(name);
    }

    @PostMapping("/report/add-report")
    public void addReport(Report report){reportService.createReport(report);}

    @PostMapping("/report")
    public void deleteReport(Long id){
        reportService.deleteReport(id);
    }
}
