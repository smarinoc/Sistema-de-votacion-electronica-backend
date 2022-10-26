package co.edu.udea.iot.backend.controller;

import co.edu.udea.iot.backend.dto.VoteDTO;
import co.edu.udea.iot.backend.dto.VotesByCandidate;
import co.edu.udea.iot.backend.service.VoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vote")
public class VoteController {

    private final VoteService voteService;


    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @Operation(description = "View a votes count")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully",
                    content = @Content(schema = @Schema(implementation = VoteDTO.class))),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")
    })
    @GetMapping("/getVotesCount")
    public Integer getVotesCount() {
        return voteService.votesCount();
    }

    @Operation(description = "View a votes count by candidate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully",
                    content = @Content(schema = @Schema(implementation = VoteDTO.class))),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")
    })
    @GetMapping("/getVotesByCandidate")
    public List<VotesByCandidate> getVotesByCandidate() {
        return voteService.getVotesByCandidates();
    }


}
