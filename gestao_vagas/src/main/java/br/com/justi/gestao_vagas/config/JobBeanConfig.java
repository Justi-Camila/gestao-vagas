package br.com.justi.gestao_vagas.config;

import br.com.justi.gestao_vagas.modules.company.application.CreateJobService;
import br.com.justi.gestao_vagas.modules.company.domain.port.in.CreateJobUseCase;
import br.com.justi.gestao_vagas.modules.company.domain.port.out.CompanyRepository;
import br.com.justi.gestao_vagas.modules.company.domain.port.out.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobBeanConfig {

    @Bean
    public CreateJobUseCase createJobUseCase(JobRepository jobRepository, CompanyRepository companyRepository) {
        return new CreateJobService(jobRepository, companyRepository);
    }
}
