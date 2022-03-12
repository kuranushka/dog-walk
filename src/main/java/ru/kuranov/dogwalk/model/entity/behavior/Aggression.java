package ru.kuranov.dogwalk.model.entity.behavior;

import lombok.*;
import ru.kuranov.dogwalk.model.entity.dog.Dog;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "aggression")
public class Aggression {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "label")
    private String label;

    @ManyToOne(targetEntity = Dog.class)
    @JoinColumn(name = "dog_id")
    private Dog dog;
}
