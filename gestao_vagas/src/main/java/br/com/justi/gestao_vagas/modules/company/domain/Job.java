package br.com.justi.gestao_vagas.modules.company.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Job {
     private final UUID id;
     private String description;
     private String benefits;
     private String level;
     private final UUID companyId;
     private final LocalDateTime createdAt;

    public Job(UUID id, String description, String benefits, String level, UUID companyId, LocalDateTime createdAt) {
        this.id = id;
        this.description = description;
        this.benefits = benefits;
        this.level = level;
        this.companyId = companyId;
        this.createdAt = createdAt;
    }

    public boolean belongsTo(UUID otherCompanyId) {
        return this.companyId.equals(otherCompanyId);
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
