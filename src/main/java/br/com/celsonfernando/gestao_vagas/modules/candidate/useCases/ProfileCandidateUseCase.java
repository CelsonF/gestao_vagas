package br.com.celsonfernando.gestao_vagas.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.celsonfernando.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.celsonfernando.gestao_vagas.modules.candidate.dto.ProfileCadidateResponseDTO;

@Service
public class ProfileCandidateUseCase {
    
    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCadidateResponseDTO execute(UUID idCandidate) {
        var candidate = this.candidateRepository.findById(idCandidate)
            .orElseThrow(() -> {
                throw new UsernameNotFoundException("User not found");
            });

        var candidateDTO = ProfileCadidateResponseDTO.builder()
            .description(candidate.getDescription())
            .username(candidate.getUsername())
            .email(candidate.getEmail())
            .name(candidate.getName())
            .id(candidate.getId())
            .build();

        return candidateDTO;
    }


}
