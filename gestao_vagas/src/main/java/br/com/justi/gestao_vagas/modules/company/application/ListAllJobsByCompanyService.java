package br.com.justi.gestao_vagas.modules.company.application;

import br.com.justi.gestao_vagas.modules.company.domain.Job;
import br.com.justi.gestao_vagas.modules.company.domain.port.in.ListAllJobsByCompanyUseCase;
import br.com.justi.gestao_vagas.modules.company.domain.port.out.JobRepository;

import java.util.List;
import java.util.UUID;

public class ListAllJobsByCompanyService implements ListAllJobsByCompanyUseCase {

    private final JobRepository jobRepository;

    public ListAllJobsByCompanyService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // Escolha: devolver a lista vazia
    @Override
    public List<Job> listAllJobsByCompanyUseCase(UUID id) {
        return jobRepository.findByCompany(id);
    }
}
