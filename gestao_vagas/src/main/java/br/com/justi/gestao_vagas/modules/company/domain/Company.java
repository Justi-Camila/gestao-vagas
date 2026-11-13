package br.com.justi.gestao_vagas.modules.company.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Company {
    private UUID id;
    private String username;
    private String password;
    private String email;
    private String website;
    private String name;
    private String description;
    private LocalDateTime createdAt;

    public Company(UUID id, String username, String password, String email, String website, String name, String description, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.website = website;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
