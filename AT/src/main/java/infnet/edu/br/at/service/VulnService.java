package infnet.edu.br.at.service;

import infnet.edu.br.at.model.entities.Assessment;
import infnet.edu.br.at.model.entities.Vuln;
import infnet.edu.br.at.repository.VulnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VulnService {

    private final VulnRepository vulnRepository;

    public List<Vuln> findByAssessment(Assessment assessment) {
        return vulnRepository.findByAssessment(assessment);
    }

    public Optional<Vuln> findByVulnId(Long vulnId) {
        return vulnRepository.findById(vulnId);
    }

    public Vuln create(Vuln vuln, Optional<Assessment> assessment) {
        Vuln newVuln = new Vuln();
        newVuln.setName(vuln.getName());
        newVuln.setDescription(vuln.getDescription());
        newVuln.setRemediation(vuln.getRemediation());
        newVuln.setOwaspTop10(vuln.getOwaspTop10());
        newVuln.setScoreCVSS(vuln.getScoreCVSS());
        newVuln.setCWE(vuln.getCWE());
        newVuln.setAffectedItem(vuln.getAffectedItem());
        newVuln.setReference(vuln.getReference());
        newVuln.setAssessment(assessment.orElse(null));
        return vulnRepository.save(newVuln);
    }

    public void delete(Vuln vuln) {
        vulnRepository.delete(vuln);
    }
}
