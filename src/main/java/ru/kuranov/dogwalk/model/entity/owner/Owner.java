package ru.kuranov.dogwalk.model.entity.owner;

import lombok.*;
import ru.kuranov.dogwalk.model.entity.dog.Dog;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone")
    private String phone;

    @OneToMany(targetEntity = Dog.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "owner")
    private Set<Dog> dogs;

}
