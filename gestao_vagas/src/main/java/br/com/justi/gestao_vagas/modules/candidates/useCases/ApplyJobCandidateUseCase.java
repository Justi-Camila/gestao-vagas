package br.com.justi.gestao_vagas.modules.candidates.useCases;

import br.com.justi.gestao_vagas.exceptions.JobNotFoundException;
import br.com.justi.gestao_vagas.exceptions.UserNotFoundException;
import br.com.justi.gestao_vagas.modules.candidates.CandidateRepository;
import br.com.justi.gestao_vagas.modules.candidates.entity.ApplyJobEntity;
import br.com.justi.gestao_vagas.modules.candidates.repository.ApplyJobRepository;
import br.com.justi.gestao_vagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {
        //validar se candidato existe
        this.candidateRepository.findById(idCandidate).orElseThrow(() -> {
            throw new UserNotFoundException();
        });

        //validar se vaga existe
        this.jobRepository.findById(idJob).orElseThrow(() -> {
            throw new JobNotFoundException();
        });

        //candidato se inscreve na vaga
        var applyJob = ApplyJobEntity.builder()
                .candidateId(idCandidate)
                .jobId(idJob)
                .build();

        applyJob = applyJobRepository.save(applyJob);
        return applyJob;
    }

}
