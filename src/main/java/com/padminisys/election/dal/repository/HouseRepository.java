package com.padminisys.election.dal.repository;

import com.padminisys.election.dal.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HouseRepository extends JpaRepository<House, Long> {

    Optional<House> findHouseByName(String name);

}
