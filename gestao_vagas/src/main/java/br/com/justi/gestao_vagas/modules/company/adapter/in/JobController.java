package br.com.justi.gestao_vagas.modules.company.adapter.in;

// Traduz a requisicao em uma chamada à porta de entrada

import br.com.justi.gestao_vagas.modules.company.domain.Job;
import br.com.justi.gestao_vagas.modules.company.domain.port.in.CreateJobUseCase;
import br.com.justi.gestao_vagas.modules.company.dto.CreateJobDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/company/job")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @PostMapping
    public ResponseEntity<Job> create(@RequestBody CreateJobDTO dto, @RequestAttribute UUID companyId) {
        Job job = new Job(null, dto.getDescription(), dto.getBenefits(), dto.getLevel(), companyId, LocalDateTime.now());
        Job created = createJobUseCase.execute(job);
        return ResponseEntity.ok(created);
    }

}
