package com.padminisys.election.api.service;

import com.padminisys.election.dal.entity.PollingNomination;
import com.padminisys.election.dal.entity.constant.ApprovalStatus;
import com.padminisys.election.dal.repository.PollingNominationRepository;
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
@RequestMapping("polling-nomination")
public class PollingNominationService {

    private final PollingNominationRepository pollingNominationRepository;

    @RolesAllowed("admin")
    @PostMapping("/create")
    public @ResponseBody
    PollingNomination newPollingNomination(@RequestBody PollingNomination pollingNomination, Principal principal) {
        LocalDateTime indiaTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));

        pollingNomination.setUpdateTime(indiaTime);
        pollingNomination.setCreationTime(indiaTime);

        pollingNomination.setCreatedBy(principal.getName());
        pollingNomination.setModifiedBy(principal.getName());
        pollingNomination.setNominationApprovalStatus(ApprovalStatus.PENDING);
        pollingNominationRepository.save(pollingNomination);
        log.info("new polling nomination {} created by {}", pollingNomination, principal.getName());
        return pollingNomination;
    }
}