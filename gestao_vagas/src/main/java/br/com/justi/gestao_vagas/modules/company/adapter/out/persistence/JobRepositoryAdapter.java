package br.com.justi.gestao_vagas.modules.company.adapter.out.persistence;

import br.com.justi.gestao_vagas.modules.company.domain.Job;
import br.com.justi.gestao_vagas.modules.company.domain.port.out.JobRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
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

    @Override
    public List<Job> findByCompany(UUID id) {
        // pedindo as entidades da empresa
        List<JobJpaEntity> entities = jobJpaRepository.findByCompanyID(id);
        
        // convertendo elas para o dominio
        List<Job> jobs = entities.stream().map(JobMapper::toDomain).toList();

        // devolver a lista de vagas
        return jobs;
    }

}
