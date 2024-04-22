package partner;

import entity.Report;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import repository.ReportRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;

    Report findAll(String name);

    Report findReportByName(String name);

    void createReport(Report report);

    void deleteById(Long id);

}
