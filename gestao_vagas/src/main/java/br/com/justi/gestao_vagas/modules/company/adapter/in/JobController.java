package br.com.justi.gestao_vagas.modules.company.adapter.in;

// Traduz a requisicao em uma chamada à porta de entrada

import br.com.justi.gestao_vagas.modules.company.domain.Job;
import br.com.justi.gestao_vagas.modules.company.domain.port.in.CreateJobUseCase;
import br.com.justi.gestao_vagas.modules.company.domain.port.in.ListAllJobsByCompanyUseCase;
import br.com.justi.gestao_vagas.modules.company.dto.CreateJobDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/company/job")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @Autowired
    private ListAllJobsByCompanyUseCase listAllJobsByCompanyUseCase;

    @PostMapping("/")
    @PreAuthorize("hasRole('COMPANY')")
    @Tag(name = "Vagas", description = "Informações das vagas")
    @Operation(summary = "Cadastro de vagas", description = "Essa função é responsavel por cadastrar as vagas dentro da empresa")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(
                            schema = @Schema(implementation = Job.class)
                    )
            })
    })
    @SecurityRequirement(name = "jwt_auth")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request) {
        var companyId = request.getAttribute("company_id");

        try {
            var job= new Job(null, createJobDTO.getDescription(), createJobDTO.getBenefits(),
                    createJobDTO.getLevel(), UUID.fromString(companyId.toString()), LocalDateTime.now());

            var result = this.createJobUseCase.execute(job);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('COMPANY')")
    @Tag(name = "Vagas", description = "Listagem das vagas")
    @Operation(summary = "Listagem de vagas", description = "Essa função é responsavel por listar as vagas dentro da empresa")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(
                            schema = @Schema(implementation = Job.class)
                    )
            })
    })
    @SecurityRequirement(name = "jwt_auth")
    public ResponseEntity<Object> listByCompany(HttpServletRequest request) {
        var companyId = request.getAttribute("company_id");

        var result = listAllJobsByCompanyUseCase.listAllJobsByCompanyUseCase(UUID.fromString(companyId.toString()));

        return ResponseEntity.ok().body(result);
    }

}
