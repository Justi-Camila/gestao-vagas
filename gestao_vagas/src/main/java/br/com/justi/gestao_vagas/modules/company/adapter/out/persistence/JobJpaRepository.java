package br.com.justi.gestao_vagas.modules.company.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobJpaRepository extends JpaRepository<JobJpaEntity, UUID> {
    List<JobJpaEntity> findByCompanyID(UUID id);
}
