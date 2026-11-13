package br.com.justi.gestao_vagas.modules.company.adapter.out.persistence;


import br.com.justi.gestao_vagas.modules.company.domain.Company;
import br.com.justi.gestao_vagas.modules.company.domain.port.out.CompanyRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class CompanyRepositoryAdapter implements CompanyRepository {

    private final CompanyJpaRepository companyJpaRepository;

    public CompanyRepositoryAdapter(CompanyJpaRepository companyJpaRepository) {
        this.companyJpaRepository = companyJpaRepository;
    }

    @Override
    public boolean existsById(UUID companyId) {
        return companyJpaRepository.existsById(companyId);
    }

    @Override
    public boolean existsByUsernameOrEmail(String username, String email) {
        return false;
    }

    @Override
    public Company save(Company company) {
        return null;
    }

}
