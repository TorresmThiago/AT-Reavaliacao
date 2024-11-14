package infnet.edu.br.at.repository;

import infnet.edu.br.at.model.entities.Assessment;
import infnet.edu.br.at.model.entities.Vuln;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VulnRepository extends JpaRepository<Vuln, Long> {

    List<Vuln> findByAssessment(Assessment assessment);

}
