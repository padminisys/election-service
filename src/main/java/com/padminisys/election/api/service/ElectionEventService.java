package com.padminisys.election.api.service;

import com.padminisys.election.dal.entity.ElectionEvent;
import com.padminisys.election.dal.repository.ElectionEventRepository;
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
@RequestMapping("election-event")
public class ElectionEventService {

    private final ElectionEventRepository electionEventRepository;

    @RolesAllowed("admin")
    @PostMapping("/create")
    public @ResponseBody
    ElectionEvent newElectionEvent(@RequestBody ElectionEvent electionEvent, Principal principal) {
        LocalDateTime indiaTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));

        electionEvent.setUpdateTime(indiaTime);
        electionEvent.setCreationTime(indiaTime);

        electionEvent.setCreatedBy(principal.getName());
        electionEvent.setModifiedBy(principal.getName());

        electionEventRepository.save(electionEvent);
        log.info("new election event {} created by {}", electionEvent, principal.getName());
        return electionEvent;
    }
}
