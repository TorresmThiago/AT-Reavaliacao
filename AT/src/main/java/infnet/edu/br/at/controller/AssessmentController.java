package infnet.edu.br.at.controller;

import infnet.edu.br.at.model.entities.Assessment;
import infnet.edu.br.at.model.entities.User;
import infnet.edu.br.at.model.enums.DemandEnum;
import infnet.edu.br.at.model.enums.EnvironmentEnum;
import infnet.edu.br.at.service.AssessmentService;
import infnet.edu.br.at.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AssessmentController {

    private final AssessmentService assessmentService;

    private final UserService userService;

    @GetMapping("/home")
    public String viewHome(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        Optional<User> user = userService.findByUsername(userDetails.getUsername());
        user.ifPresent(value -> model.addAttribute("assessments", assessmentService.findByUser(value)));
        user.ifPresent(value -> model.addAttribute("username", user.get().getUsername()));
        return "home";
    }

    @GetMapping("/assessment/{id}")
    public String viewAssessment(@PathVariable Integer id, Model model) {
        Optional<Assessment> assessment = assessmentService.findById(id);
        assessment.ifPresent(value -> model.addAttribute("assessment", value));
        assessment.ifPresent(value -> model.addAttribute("vulns", value.getVulns()));
        return "assessment/detail";
    }

    @PostMapping("/assessment/create")
    public String createAssessment(Assessment assessment, @AuthenticationPrincipal UserDetails userDetails) {
        Optional<User> user = userService.findByUsername(userDetails.getUsername());
        assessmentService.create(assessment, user);
        return "redirect:/home";
    }

    @GetMapping("/assessment/create")
    public String createAssessment(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        Optional<User> user = userService.findByUsername(userDetails.getUsername());
        model.addAttribute("assessment", new Assessment());
        model.addAttribute("user", user);
        model.addAttribute("demands", DemandEnum.values());
        model.addAttribute("environments", EnvironmentEnum.values());
        return "assessment/create";
    }

    @GetMapping("/assessment/remove/{id}")
    public String removeAssessment(@PathVariable Integer id, @AuthenticationPrincipal UserDetails userDetails, Model model) {
        Optional<User> user = userService.findByUsername(userDetails.getUsername());
        Optional<Assessment> assessment = assessmentService.findById(id);
        assessment.ifPresent(assessmentService::delete);
        return "redirect:/home";
    }
}
