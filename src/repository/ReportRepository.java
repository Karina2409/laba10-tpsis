package repository;

import entity.Report;

import java.util.List;

@Repository
public class ReportRepository extends JpaRepository<Report, Long> {

    public List<Report> listReport() {
        return reportRepository.findAll();
    }

    public Report getReportByName(String name){
        return reportRepository.findReportByName(name);
    }

    public void createReport(Report report) { reportRepository.createReport(report); }

    public void deleteReport(Long id){
        reportRepository.deleteById(id);
    }

}
