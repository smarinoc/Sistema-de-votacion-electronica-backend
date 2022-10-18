package co.edu.udea.iot.backend.dto;

import javax.validation.constraints.NotBlank;

public class CandidateDTO {

    private Integer id;
    @NotBlank(message = "Name is required")
    private String firstName;
    private String lastName;
    @NotBlank(message = "The document is required")
    private String document;
    @NotBlank(message = "The document type is required")
    private String documentType;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
}
