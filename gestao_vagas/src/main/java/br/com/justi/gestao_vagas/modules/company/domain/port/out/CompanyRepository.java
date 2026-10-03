package br.com.justi.gestao_vagas.modules.company.domain.port.out;

import java.util.UUID;

public interface CompanyRepository {
    boolean existsById(UUID companyId);
}
