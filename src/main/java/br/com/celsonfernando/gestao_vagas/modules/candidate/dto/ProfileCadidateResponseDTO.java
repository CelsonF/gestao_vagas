package br.com.celsonfernando.gestao_vagas.modules.candidate.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCadidateResponseDTO {
    
    @Schema(example = "Desenvolvedora JAVA")
    private String description;

    @Schema(example = "AnaB")
    private String username;

    @Schema(example = "anabeatriz@gmail.com")
    private String email;

    private UUID id;
    
    @Schema(example = "Ana Beatriz")
    private String name;

}
