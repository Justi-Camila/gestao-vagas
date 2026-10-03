package br.com.justi.gestao_vagas.modules.company.application;

// Implementa ports (interfaces)
// Não tem nenhuma anotação do Spring

import br.com.justi.gestao_vagas.exceptions.CompanyNotFoundException;
import br.com.justi.gestao_vagas.modules.company.domain.Job;
import br.com.justi.gestao_vagas.modules.company.domain.port.in.CreateJobUseCase;
import br.com.justi.gestao_vagas.modules.company.domain.port.out.CompanyRepository;
import br.com.justi.gestao_vagas.modules.company.domain.port.out.JobRepository;

public class CreateJobService implements CreateJobUseCase {

    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;

    public CreateJobService(JobRepository jobRepository, CompanyRepository companyRepository) {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public Job execute(Job job) {
        if (!companyRepository.existsById(job.getCompanyId())) {
            throw new CompanyNotFoundException();
        }
        return jobRepository.save(job);
    }
}
