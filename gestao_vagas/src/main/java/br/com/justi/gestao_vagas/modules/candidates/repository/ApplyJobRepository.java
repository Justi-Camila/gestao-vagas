package br.com.justi.gestao_vagas.modules.candidates.repository;

import br.com.justi.gestao_vagas.modules.candidates.entity.ApplyJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID> {
}
