package co.edu.udea.iot.backend.service;

import co.edu.udea.iot.backend.dto.VoteDTO;
import co.edu.udea.iot.backend.dto.VotesByCandidate;
import co.edu.udea.iot.backend.mapper.VoteMapper;
import co.edu.udea.iot.backend.model.Vote;
import co.edu.udea.iot.backend.repository.VoteRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Service
@Validated
public class VoteService {

    private final VoteRepository voteRepository;
    private final VoteMapper mapper;


    public VoteService(VoteRepository voteRepository, VoteMapper mapper) {
        this.voteRepository = voteRepository;
        this.mapper = mapper;

    }


    public Integer votesCount() {
       return Math.toIntExact(voteRepository.count());
    }

    public VoteDTO saveVote(VoteDTO voteDTO) throws MqttException {
        Vote vote=  voteRepository.save(mapper.toEntity(voteDTO));
        return mapper.toDto(vote);
    }

    public List<VotesByCandidate> getVotesByCandidates(){
        return voteRepository.votesByCandidate();
    }

    public void raspberryVoting(String str){
        System.out.println(str);
        try{
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            VoteDTO vote = gson.fromJson(str,VoteDTO.class);
            voteRepository.save(mapper.toEntity(vote));

        }catch(JsonIOException err){
            System.out.println("Exception : "+err.toString());
        }
    }
}
