package com.padminisys.election.dal.repository;

import com.padminisys.election.dal.entity.PollingNomination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollingNominationRepository extends JpaRepository<PollingNomination, Long> {
}
