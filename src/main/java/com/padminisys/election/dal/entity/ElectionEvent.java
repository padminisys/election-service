package com.padminisys.election.dal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = "pollingEvents")
public class ElectionEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "houseId", referencedColumnName = "id", nullable = false)
    private House house;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "electionEvent", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PollingEvent> pollingEvents;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "frozenEventId", referencedColumnName = "id")
    private PollingEvent frozenEvent;

    private LocalDateTime creationTime;
    private LocalDateTime updateTime;
    private String createdBy;
    private String modifiedBy;
}