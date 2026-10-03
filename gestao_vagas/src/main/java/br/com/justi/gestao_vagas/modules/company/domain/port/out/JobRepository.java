package br.com.justi.gestao_vagas.modules.company.domain.port.out;

import br.com.justi.gestao_vagas.modules.company.domain.Job;

public interface JobRepository {
    Job save(Job job);
}
