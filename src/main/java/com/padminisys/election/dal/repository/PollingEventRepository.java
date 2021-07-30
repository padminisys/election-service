package com.padminisys.election.dal.repository;

import com.padminisys.election.dal.entity.PollingEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollingEventRepository extends JpaRepository<PollingEvent, Long> {

}
