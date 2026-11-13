package br.com.justi.gestao_vagas.modules.company.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Job {
     private UUID id;
     private String description;
     private String benefits;
     private String level;
     private UUID companyId;
     private LocalDateTime createdAt;

    public Job(UUID id, String description, String benefits, String level, UUID companyId, LocalDateTime createdAt) {
        this.id = id;
        this.description = description;
        this.benefits = benefits;
        this.level = level;
        this.companyId = companyId;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getBenefits() {
        return benefits;
    }

    public String getLevel() {
        return level;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
