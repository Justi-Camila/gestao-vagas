package br.com.justi.gestao_vagas.modules.company.controllers;

import br.com.justi.gestao_vagas.modules.company.domain.port.in.CreateJobUseCase;
import br.com.justi.gestao_vagas.modules.company.entities.JobEntity;
import br.com.justi.gestao_vagas.modules.company.useCases.ListAllJobsByCompanyUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/company/job")
public class JobController {

    @Autowired
    private ListAllJobsByCompanyUseCase listAllJobsByCompanyUseCase;

    @GetMapping("/")
    @PreAuthorize("hasRole('COMPANY')")
    @Tag(name = "Vagas", description = "Listagem das vagas")
    @Operation(summary = "Listagem de vagas", description = "Essa função é responsavel por listar as vagas dentro da empresa")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(
                            schema = @Schema(implementation = JobEntity.class)
                    )
            })
    })
    @SecurityRequirement(name = "jwt_auth")
    public ResponseEntity<Object> listByCompany(HttpServletRequest request) {
        var companyId = request.getAttribute("company_id");
        var result = this.listAllJobsByCompanyUseCase.execute(UUID.fromString(companyId.toString()));
        return ResponseEntity.ok().body(result);
    }
}
