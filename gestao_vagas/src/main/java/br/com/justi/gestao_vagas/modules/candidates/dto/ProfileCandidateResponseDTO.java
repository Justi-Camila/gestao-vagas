package br.com.justi.gestao_vagas.modules.candidates.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCandidateResponseDTO {

    @Schema(example = "Desenvolvedora java")
    private String description;

    @Schema(example = "maria")
    private String username;

    @Schema(example = "maria de souza")
    private String name;

    @Schema(example = "maria@gmail.com")
    private String email;

    private UUID id;
}
