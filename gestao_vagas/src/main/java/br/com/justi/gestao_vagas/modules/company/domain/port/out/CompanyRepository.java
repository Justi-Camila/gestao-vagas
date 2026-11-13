package br.com.justi.gestao_vagas.modules.company.domain.port.out;

import br.com.justi.gestao_vagas.modules.company.domain.Company;

import java.util.UUID;

public interface CompanyRepository {
    boolean existsById(UUID companyId);
    boolean existsByUsernameOrEmail(String username, String email);
    Company save(Company company);
}
