package com.padminisys.election.dal.repository;

import com.padminisys.election.dal.entity.PollParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollParticipantRepository extends JpaRepository<PollParticipant, Long> {
}
