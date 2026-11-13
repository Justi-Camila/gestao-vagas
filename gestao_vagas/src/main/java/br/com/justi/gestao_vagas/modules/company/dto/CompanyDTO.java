package br.com.justi.gestao_vagas.modules.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyDTO {

    private String username;
    private String email;
    private String website;
    private String name;
    private String description;
}
