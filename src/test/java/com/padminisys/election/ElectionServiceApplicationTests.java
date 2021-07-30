package com.padminisys.election;

import com.padminisys.election.dal.entity.House;
import com.padminisys.election.dal.entity.Member;
import com.padminisys.election.dal.repository.HouseRepository;
import com.padminisys.election.dal.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZoneId;

@SpringBootTest
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class ElectionServiceApplicationTests {

    private final HouseRepository houseRepository;
    private final MemberRepository memberRepository;

    @Test
    void contextLoads() {
    }

    @Test
    @Disabled
    public void createInitial() {

        LocalDateTime indiaTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));

        House house = new House();
        house.setCreatedBy("ramanuj");
        house.setName("PADMINISYS");
        house.setUpdateTime(indiaTime);
        house.setCreationTime(indiaTime);
        house.setModifiedBy("ramanuj");
        House padmini = houseRepository.save(house);

        Member member = new Member();
        member.setAadhar("518357406505");
        member.setAddress("1204, C WING, ROYAL OASIS, JANKALYAN NAGAR, MALAD WEST, MUMBAI - 400095");
        member.setName("RAMANUJ");
        member.setEmail("ramanuj@padminisys.com");
        member.setMobile("9004481082");
        member.setPan("AKCPD6321P");
        member.setUnit("A1");
        member.setModifiedBy(member.getName());
        member.setCreatedBy(member.getName());
        member.setCreationTime(indiaTime);
        member.setUpdateTime(indiaTime);
        member.setPhotoKey("s3://profile/pic_ramanuj.jpg");
        member.setUsername("ramanuj");
        member.setHouse(padmini);
        Member createdMember = memberRepository.save(member);
    }
}
