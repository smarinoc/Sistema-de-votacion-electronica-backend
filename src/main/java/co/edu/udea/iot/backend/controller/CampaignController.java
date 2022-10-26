package co.edu.udea.iot.backend.controller;

import co.edu.udea.iot.backend.dto.CampaignDTO;
import co.edu.udea.iot.backend.service.CampaignService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/campaign")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @Operation(description = "View a campaign by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully campaign",
                    content = @Content(schema = @Schema(implementation = CampaignDTO.class))),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")
    })
    @GetMapping("/{id}")
    public CampaignDTO getCampaignById(@PathVariable Integer id) {
        return campaignService.campaignByID(id);
    }

}
