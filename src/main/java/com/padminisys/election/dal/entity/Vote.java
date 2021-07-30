package com.padminisys.election.dal.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pollingEventId", referencedColumnName = "id")
    private PollingEvent pollingEvent;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pollParticipantId", referencedColumnName = "id")
    private PollParticipant pollParticipant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pollingNominationId", referencedColumnName = "id")
    private PollingNomination pollingNomination;

    private LocalDateTime creationTime;
    private LocalDateTime updateTime;
    private String createdBy;
    private String modifiedBy;
}
