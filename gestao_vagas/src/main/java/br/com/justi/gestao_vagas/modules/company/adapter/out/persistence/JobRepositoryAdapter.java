package br.com.justi.gestao_vagas.modules.company.adapter.out.persistence;

import br.com.justi.gestao_vagas.modules.company.domain.Job;
import br.com.justi.gestao_vagas.modules.company.domain.port.out.JobRepository;

public class JobRepositoryAdapter implements JobRepository {
    private final JobJpaRepository jobJpaRepository;

    public JobRepositoryAdapter(JobJpaRepository jobJpaRepository) {
        this.jobJpaRepository = jobJpaRepository;
    }

    @Override
    public Job save(Job job) {
        JobJpaEntity saved = jobJpaRepository.save(JobMapper.toEntity(job));
        return JobMapper.toDomain(saved);
    }
}
