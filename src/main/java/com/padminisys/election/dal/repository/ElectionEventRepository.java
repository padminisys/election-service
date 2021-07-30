package com.padminisys.election.dal.repository;

import com.padminisys.election.dal.entity.ElectionEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionEventRepository extends JpaRepository<ElectionEvent, Long> {

}
