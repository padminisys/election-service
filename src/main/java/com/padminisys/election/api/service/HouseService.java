package com.padminisys.election.api.service;


import com.padminisys.election.api.exception.ObjectNotFoundException;
import com.padminisys.election.api.mappers.HouseMapper;
import com.padminisys.election.api.model.response.HouseResponse;
import com.padminisys.election.dal.entity.House;
import com.padminisys.election.dal.repository.HouseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("house")
public class HouseService {

    private final HouseRepository houseRepository;
    private final HouseMapper houseMapper;

    @RolesAllowed("admin")
    @PostMapping("/create")
    public @ResponseBody
    House newHouse(@RequestBody House house, Principal principal) {
        LocalDateTime indiaTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));

        house.setUpdateTime(indiaTime);
        house.setCreationTime(indiaTime);

        house.setCreatedBy(principal.getName());
        house.setModifiedBy(principal.getName());

        House newHouse = houseRepository.save(house);
        log.info("new house {} created by {}", newHouse, principal.getName());
        return newHouse;
    }

    @RolesAllowed("admin")
    @PostMapping("/update")
    public @ResponseBody
    House updateHouse(@RequestBody House house, Principal principal) {
        LocalDateTime indiaTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        house.setUpdateTime(indiaTime);
        house.setModifiedBy(principal.getName());
        House updatedHouse = houseRepository.save(house);
        log.info("updated House {} modified by {}", updatedHouse, principal.getName());
        return updatedHouse;
    }

    @RolesAllowed("admin")
    @GetMapping("/fetch/all")
    public @ResponseBody
    List<HouseResponse> getAllHouses() {
        return houseMapper.houseListToHouseResponseList(houseRepository.findAll());
    }

    @RolesAllowed("admin")
    @GetMapping("/fetch")
    public @ResponseBody
    HouseResponse getHouse(@RequestParam(required = false) Optional<Long> id, @RequestParam(required = false) Optional<String> name) throws ObjectNotFoundException {
        if (id.isPresent()) {
            Optional<House> house = houseRepository.findById(id.get());
            if (house.isPresent()) {
                return houseMapper.houseToHouseResponse(house.get());
            }
        } else if (name.isPresent()) {
            Optional<House> house = houseRepository.findHouseByName(name.get());
            if (house.isPresent()) {
                return houseMapper.houseToHouseResponse(house.get());
            }
        }
        throw new ObjectNotFoundException("Valid request parameter not provided.");
    }
}