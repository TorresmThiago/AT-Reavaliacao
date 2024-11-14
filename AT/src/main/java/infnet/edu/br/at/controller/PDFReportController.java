package infnet.edu.br.at.controller;

import infnet.edu.br.at.model.entities.Assessment;
import infnet.edu.br.at.service.AssessmentService;
import infnet.edu.br.at.service.PDFReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PDFReportController {

    private final PDFReportService pdfReportService;

    private final AssessmentService assessmentService;

    @GetMapping("/export/{id}")
    public ResponseEntity<byte[]> exportVulnerabilityReport(@PathVariable int id) {
        Optional<Assessment> assessment = assessmentService.findById(id);
        Map<String, Object> data = new HashMap<>();
        String logoPath = Paths.get("src/main/resources/static/logo.png").toAbsolutePath().toString();
        data.put("logoPath", logoPath);
        data.put("assessment", assessment.get());
        data.put("date", LocalDate.now().format(DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy")));

        String htmlContent = pdfReportService.renderHtmlTemplate("report", data);
        byte[] pdfContent = pdfReportService.generatePdfFromHtml(htmlContent);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + assessment.get().getName() + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfContent);
    }
}
