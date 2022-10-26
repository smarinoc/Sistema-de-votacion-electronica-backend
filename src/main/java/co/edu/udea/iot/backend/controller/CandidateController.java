package co.edu.udea.iot.backend.controller;

import co.edu.udea.iot.backend.dto.CandidateDTO;
import co.edu.udea.iot.backend.model.Candidate;
import co.edu.udea.iot.backend.service.CandidateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/candidate")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }


    @Operation(description = "View a list of available candidate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully list",
                    content = @Content(schema = @Schema(implementation = CandidateDTO.class))),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")
    })
    @GetMapping("/getAllCantidate")
    public List<Candidate> getAllCandidate() {
        return candidateService.getAllCandidate();
    }
}
