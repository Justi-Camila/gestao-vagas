package br.com.justi.gestao_vagas.modules.company.domain.port.in;

import br.com.justi.gestao_vagas.modules.company.domain.Job;

import java.util.List;
import java.util.UUID;

public interface ListAllJobsByCompanyUseCase {
    List<Job> listAllJobsByCompanyUseCase(UUID id);
}
