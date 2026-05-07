package com.example.onboarding.model;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    private boolean documentSubmitted;
    private boolean itSetupDone;
    private boolean trainingCompleted;

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isDocumentSubmitted() { return documentSubmitted; }
    public void setDocumentSubmitted(boolean documentSubmitted) { this.documentSubmitted = documentSubmitted; }

    public boolean isItSetupDone() { return itSetupDone; }
    public void setItSetupDone(boolean itSetupDone) { this.itSetupDone = itSetupDone; }

    public boolean isTrainingCompleted() { return trainingCompleted; }
    public void setTrainingCompleted(boolean trainingCompleted) { this.trainingCompleted = trainingCompleted; }
}