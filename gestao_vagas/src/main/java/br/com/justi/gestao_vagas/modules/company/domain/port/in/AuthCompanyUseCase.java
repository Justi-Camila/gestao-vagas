package br.com.justi.gestao_vagas.modules.company.domain.port.in;

import br.com.justi.gestao_vagas.modules.company.dto.AuthCompanyDTO;
import br.com.justi.gestao_vagas.modules.company.dto.AuthCompanyResponseDTO;

public interface AuthCompanyUseCase {
    AuthCompanyResponseDTO execute(AuthCompanyDTO authCompanyDTO);
}
