package infnet.edu.br.at.controller;

import infnet.edu.br.at.model.entities.Assessment;
import infnet.edu.br.at.model.entities.Vuln;
import infnet.edu.br.at.model.enums.OwaspTop10Enum;
import infnet.edu.br.at.service.AssessmentService;
import infnet.edu.br.at.service.VulnService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class VulnController {

    private final VulnService vulnService;

    private final AssessmentService assessmentService;

    @GetMapping("/vuln/{id}")
    public String viewVuln(@PathVariable Long id, Model model) {
        Optional<Vuln> vuln = vulnService.findByVulnId(id);
        vuln.ifPresent(value -> model.addAttribute("assessment", value.getAssessment()));
        vuln.ifPresent(value -> model.addAttribute("vuln", value));
        return "vuln/detail";
    }

    @PostMapping("/vuln/create/{id}")
    public String createVuln(@PathVariable Integer id, Vuln vuln) {
        Optional<Assessment> assessment = assessmentService.findById(id);
        vulnService.create(vuln, assessment);
        return "redirect:/assessment/" + id;
    }

    @GetMapping("/vuln/create/{id}")
    public String createVuln(@PathVariable Integer id, Model model) {
        Optional<Assessment> assessment = assessmentService.findById(id);
        assessment.ifPresent(value -> model.addAttribute("assessment", value));
        model.addAttribute("vuln", new Vuln());
        model.addAttribute("owaspTop10", OwaspTop10Enum.values());
        return "vuln/create";
    }

    @GetMapping("/vuln/remove/{id}")
    public String removeVuln(@PathVariable Long id, Model model) {
        Optional<Vuln> vuln = vulnService.findByVulnId(id);
        vuln.ifPresent(vulnService::delete);
        return "redirect:/assessment/" + vuln.get().getAssessment().getId();
    }

}
