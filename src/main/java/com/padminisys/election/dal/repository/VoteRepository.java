package com.padminisys.election.dal.repository;

import com.padminisys.election.dal.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
