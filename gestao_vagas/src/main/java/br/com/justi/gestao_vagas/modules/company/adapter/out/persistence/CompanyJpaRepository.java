package br.com.justi.gestao_vagas.modules.company.adapter.out.persistence;

import br.com.justi.gestao_vagas.modules.company.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyJpaRepository extends JpaRepository<CompanyEntity, UUID> {
}
