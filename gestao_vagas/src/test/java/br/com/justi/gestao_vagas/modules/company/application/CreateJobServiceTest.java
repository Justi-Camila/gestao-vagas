package br.com.justi.gestao_vagas.modules.company.application;

import br.com.justi.gestao_vagas.exceptions.CompanyNotFoundException;
import br.com.justi.gestao_vagas.modules.company.domain.Job;
import br.com.justi.gestao_vagas.modules.company.domain.port.out.CompanyRepository;
import br.com.justi.gestao_vagas.modules.company.domain.port.out.JobRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
public class CreateJobServiceTest {

    @Mock
    private JobRepository jobRepository;

    @Mock
    private CompanyRepository companyRepository;


    Job job = new Job(UUID.randomUUID(), "aaaaaa", "Gympass, Plano de saude, vale alimentação",
            "junior", UUID.randomUUID(), LocalDateTime.now());

    @Test
    public void deveCriarVagaQuandoEmpresaExiste() {

        // ARRANGE (preparar) -> monta o cenário
        CreateJobService createJobService = new CreateJobService(jobRepository, companyRepository);
        Mockito.when(companyRepository.existsById(job.getCompanyId())).thenReturn(true);
        Mockito.when(jobRepository.save(job)).thenReturn(job);

        // ACT (agir) -> executa UMA coisa, a que está a ser testada
        var vaga = createJobService.execute(job);

        // ASSERT (verificar) -> compara o resultado com o esperado
        Assert.assertEquals(job, vaga);
    }

    @Test
    public void deveLancarExcecaoQuandoEmpresaNaoExiste() {

        // ARRANGE
        CreateJobService createJobService = new CreateJobService(jobRepository, companyRepository);
        Mockito.when(companyRepository.existsById(job.getCompanyId())).thenReturn(false);

        // ACT + ASSERT
        Assert.assertThrows(CompanyNotFoundException.class, () -> createJobService.execute(job));

        // VERIFY
        Mockito.verify(jobRepository, Mockito.never()).save(job);

    }

}

