package com.padminisys.election.api.service;

import com.padminisys.election.dal.entity.PollParticipant;
import com.padminisys.election.dal.repository.PollParticipantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("polling-participant")
public class PollParticipantService {

    private final PollParticipantRepository pollParticipantRepository;

    @RolesAllowed("admin")
    @PostMapping("/create")
    public @ResponseBody
    PollParticipant newPollParticipant(@RequestBody PollParticipant pollParticipant, Principal principal) {
        LocalDateTime indiaTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));

        pollParticipant.setUpdateTime(indiaTime);
        pollParticipant.setCreationTime(indiaTime);

        pollParticipant.setCreatedBy(principal.getName());
        pollParticipant.setModifiedBy(principal.getName());

        pollParticipantRepository.save(pollParticipant);
        log.info("new poll participant {} created by {}", pollParticipant, principal.getName());
        return pollParticipant;
    }
}