package br.com.celsonfernando.gestao_vagas.modules.candidate.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCadidateResponseDTO {
    
    private String description;
    private String username;
    private String email;
    private UUID id;
    private String name;

}