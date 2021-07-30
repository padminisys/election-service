package com.padminisys.election.dal.entity;

import com.padminisys.election.dal.entity.constant.ApprovalStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = "votes")
public class PollingNomination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    private String slogan;
    private String comment;
    private ApprovalStatus nominationApprovalStatus;

    @OneToOne
    @JoinColumn(name = "pollParticipantId", referencedColumnName = "id", nullable = false)
    private PollParticipant pollParticipant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pollingEventId", referencedColumnName = "id", nullable = false)
    private PollingEvent pollingEvent;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pollingNomination", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Vote> votes;

    private LocalDateTime creationTime;
    private LocalDateTime updateTime;
    private String createdBy;
    private String modifiedBy;

}
