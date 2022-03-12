package ru.kuranov.dogwalk.model.entity.location;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "metro")
public class Metro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "metro_name")
    private String metroName;

    @OneToOne(targetEntity = WalkingPlace.class,
            mappedBy = "metro")
    private WalkingPlace walkingPlace;
}
