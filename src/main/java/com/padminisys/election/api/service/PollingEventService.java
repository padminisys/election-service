package com.padminisys.election.api.service;

import com.padminisys.election.dal.entity.PollingEvent;
import com.padminisys.election.dal.repository.PollingEventRepository;
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
@RequestMapping("polling-event")
public class PollingEventService {

    private final PollingEventRepository pollingEventRepository;

    @RolesAllowed("admin")
    @PostMapping("/create")
    public @ResponseBody
    PollingEvent newPollingEvent(@RequestBody PollingEvent pollingEvent, Principal principal) {
        LocalDateTime indiaTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));

        pollingEvent.setUpdateTime(indiaTime);
        pollingEvent.setCreationTime(indiaTime);

        pollingEvent.setCreatedBy(principal.getName());
        pollingEvent.setModifiedBy(principal.getName());

        pollingEventRepository.save(pollingEvent);
        log.info("new polling event {} created by {}", pollingEvent, principal.getName());
        return pollingEvent;
    }

}
