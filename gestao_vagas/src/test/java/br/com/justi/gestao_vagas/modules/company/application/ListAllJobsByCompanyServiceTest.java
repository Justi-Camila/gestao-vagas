package br.com.justi.gestao_vagas.modules.company.application;

import br.com.justi.gestao_vagas.modules.company.domain.Job;
import br.com.justi.gestao_vagas.modules.company.domain.port.out.JobRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
public class ListAllJobsByCompanyServiceTest {

    @Mock
    private JobRepository jobRepository;

    Job job = new Job(UUID.randomUUID(), "aaaaaa", "Gympass, Plano de saude, vale alimentação",
            "junior", UUID.randomUUID(), LocalDateTime.now());

    @Test
    public void deveDevolverListaComAsVagas() {
        List<Job> jobs = List.of(job);
        ListAllJobsByCompanyService listAllJobsByCompanyService = new ListAllJobsByCompanyService(jobRepository);
        Mockito.when(jobRepository.findByCompany(job.getCompanyId())).thenReturn(jobs);

        var resultado = listAllJobsByCompanyService.listAllJobsByCompanyUseCase(job.getCompanyId());

        Assert.assertEquals(jobs, resultado);

        Mockito.verify(jobRepository).findByCompany(job.getCompanyId());
    }

    @Test
    public void deveDevolverListaVaziaQuandoNaoHaVagas() {
        List<Job> jobs = List.of();
        ListAllJobsByCompanyService listAllJobsByCompanyService = new ListAllJobsByCompanyService(jobRepository);
        Mockito.when(jobRepository.findByCompany(job.getCompanyId())).thenReturn(List.of());

        var resultado = listAllJobsByCompanyService.listAllJobsByCompanyUseCase(job.getCompanyId());

        Assert.assertEquals(jobs, resultado);

        Mockito.verify(jobRepository).findByCompany(job.getCompanyId());

    }

}
