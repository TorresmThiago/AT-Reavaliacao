package infnet.edu.br.at.service;

import infnet.edu.br.at.model.entities.Assessment;
import infnet.edu.br.at.model.entities.User;
import infnet.edu.br.at.repository.AssessmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssessmentService{

    private final AssessmentRepository assessmentRepository;

    public List<Assessment> findByUser(User user){
        return assessmentRepository.findByUser(user);
    }

    public Optional<Assessment> findById(Integer id){
        return assessmentRepository.findById(id);
    }

    public Assessment create(Assessment assessment, Optional<User> user){
        user.ifPresent(assessment::setUser);
        return assessmentRepository.save(assessment);
    }

    public Assessment update(Assessment assessment){
        return assessmentRepository.save(assessment);
    }

    public void delete(Assessment assessment){
        assessmentRepository.delete(assessment);
    }

}
