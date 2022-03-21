package ru.kuranov.dogwalk.model.entity.location;

import lombok.*;
import ru.kuranov.dogwalk.model.entity.main.Walking;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(targetEntity = Walking.class,
            mappedBy = "city")
    private Walking walking;
}
