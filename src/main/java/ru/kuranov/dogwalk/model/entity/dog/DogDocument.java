package ru.kuranov.dogwalk.model.entity.dog;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "dog_document")
public class DogDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(targetEntity = Dog.class)
    @JoinColumn(name = "dog_id")
    private Dog dog;
}
