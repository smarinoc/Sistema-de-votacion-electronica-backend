package co.edu.udea.iot.backend.dto;

import javax.validation.constraints.NotBlank;

public class CampaignDTO {

    private Integer id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "The start date is required")
    private String startDate;

    @NotBlank(message = "The end date is required")
    private String endDate;


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
