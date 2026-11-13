package br.com.justi.gestao_vagas.modules.company.application;

import br.com.justi.gestao_vagas.modules.company.domain.port.in.AuthCompanyUseCase;
import br.com.justi.gestao_vagas.modules.company.dto.AuthCompanyDTO;
import br.com.justi.gestao_vagas.modules.company.dto.AuthCompanyResponseDTO;

public class AuthCompanyService implements AuthCompanyUseCase {

    @Override
    public AuthCompanyResponseDTO execute(AuthCompanyDTO authCompanyDTO) {
        return null;
    }
}
