package reports;

public class MonthlyReportGenerator {
    private final ReportGenerator reportGenerator;

    public MonthlyReportGenerator(ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    public String generateReport(String data, int month) {
        return reportGenerator.generate(data, month);
    }
}
