package ru.kuranov.dogwalk.model.entity.location;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "district")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "district_name")
    private String districtName;

    @OneToOne(targetEntity = WalkingPlace.class,
            mappedBy = "district")
    private WalkingPlace walkingPlace;
}
