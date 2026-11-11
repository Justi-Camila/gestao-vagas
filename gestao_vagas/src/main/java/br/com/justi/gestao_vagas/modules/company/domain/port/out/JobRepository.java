package br.com.justi.gestao_vagas.modules.company.domain.port.out;

import br.com.justi.gestao_vagas.modules.company.domain.Job;

import java.util.List;
import java.util.UUID;

public interface JobRepository {
    Job save(Job job);
    List<Job> findByCompany(UUID id);
}
