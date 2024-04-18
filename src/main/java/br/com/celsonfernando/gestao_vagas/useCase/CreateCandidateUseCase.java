package br.com.celsonfernando.gestao_vagas.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.celsonfernando.gestao_vagas.exceptions.UserFoundExecption;
import br.com.celsonfernando.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.celsonfernando.gestao_vagas.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateUseCase {
    
     @Autowired
    private CandidateRepository candidateRepository;


    public CandidateEntity execute(CandidateEntity candidateEntity) {
        
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((user) -> {
            throw new UserFoundExecption();
        });

        return this.candidateRepository.save(candidateEntity);
    }

}
