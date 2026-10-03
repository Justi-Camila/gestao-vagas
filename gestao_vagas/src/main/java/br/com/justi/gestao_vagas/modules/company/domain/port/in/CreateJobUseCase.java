package br.com.justi.gestao_vagas.modules.company.domain.port.in;

import br.com.justi.gestao_vagas.modules.company.domain.Job;

public interface CreateJobUseCase {

    Job execute(Job job);
}
