package infnet.edu.br.at.repository;

import infnet.edu.br.at.model.entities.Assessment;
import infnet.edu.br.at.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {

    List<Assessment> findByUser(User user);

}
