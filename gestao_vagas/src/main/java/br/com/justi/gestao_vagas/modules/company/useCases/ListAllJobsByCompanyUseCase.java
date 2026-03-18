package br.com.justi.gestao_vagas.modules.company.useCases;

import br.com.justi.gestao_vagas.modules.company.entities.JobEntity;
import br.com.justi.gestao_vagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ListAllJobsByCompanyUseCase {

    @Autowired
    private JobRepository jobRepository;

    public List<JobEntity> execute(UUID companyID) {
        return this.jobRepository.findByCompanyID(companyID);
    }
}
