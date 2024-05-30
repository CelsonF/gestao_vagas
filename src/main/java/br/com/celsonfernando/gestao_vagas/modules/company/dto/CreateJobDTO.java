package br.com.celsonfernando.gestao_vagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;

@Data
public class CreateJobDTO {
    
    @Schema(example = "Vaga para pessoa",requiredMode = RequiredMode.REQUIRED)
    private String description;

    @Schema(example = "GYM Pass, Plano de Saúde",requiredMode = RequiredMode.REQUIRED)
    private String benefits;

    @Schema(example = "Junior/Pleno/Senior",requiredMode = RequiredMode.REQUIRED)
    private String level; 

}
