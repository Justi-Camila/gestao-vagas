package br.com.justi.gestao_vagas.modules.company.adapter.out.persistence;

import br.com.justi.gestao_vagas.modules.company.domain.Job;

public class JobMapper {
    static JobJpaEntity toEntity(Job job) {
        return JobJpaEntity.builder()
                .id(job.getId())
                .description(job.getDescription())
                .benefits(job.getBenefits())
                .level(job.getLevel())
                .companyID(job.getCompanyId())
                .createdAt(job.getCreatedAt())
                .build();
    }

    static Job toDomain(JobJpaEntity entity) {
        return new Job(entity.getId(), entity.getDescription(), entity.getBenefits(), entity.getLevel(), entity.getCompanyID(), entity.getCreatedAt());
    }
}
