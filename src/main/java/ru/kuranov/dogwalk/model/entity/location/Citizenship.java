package ru.kuranov.dogwalk.model.entity.location;

import lombok.*;
import ru.kuranov.dogwalk.model.entity.walker.Walker;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "citizenship")
public class Citizenship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "country")
    private String country;

    @OneToOne(targetEntity = Walker.class)
    @JoinColumn(name = "citizenship")
    private Walker walker;
}
