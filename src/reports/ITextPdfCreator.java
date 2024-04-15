package reports;

import javax.swing.text.Document;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class ITextPdfCreator implements PdfCreator {

    @Override
    public String createPdf(byte[] data) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, outputStream);
            document.open();

            document.close();

            return Base64.getUrlEncoder().encodeToString(outputStream.toByteArray());
        } catch (DocumentException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}