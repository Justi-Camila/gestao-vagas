package br.com.justi.gestao_vagas.modules.company.domain.port.in;

import br.com.justi.gestao_vagas.modules.company.domain.Company;

public interface CreateCompanyUseCase {
    Company execute(Company company);
}
