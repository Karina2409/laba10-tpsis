package reports;

public class PdfReportGenerator extends ReportGenerator {
    @Override
    public String generate(String data, int month) {
        private final PdfCreator pdfCreator;

        public PdfReportGenerator(PdfCreator pdfCreator) {
            this.pdfCreator = pdfCreator;
        }

        @Override
        public String generate (String data,int month){
            byte[] reportData = generateReportData(data, month);

            String pdfFilePath = pdfCreator.createPdf(reportData);

            return pdfFilePath;
        }

        private byte[] generateReportData (String data,int month){

            return reportData;
        }
    }
}
