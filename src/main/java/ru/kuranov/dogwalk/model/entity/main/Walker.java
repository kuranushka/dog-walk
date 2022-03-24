package ru.kuranov.dogwalk.model.entity.main;

import lombok.*;
import ru.kuranov.dogwalk.model.entity.location.City;
import ru.kuranov.dogwalk.model.entity.security.AccountUser;
import ru.kuranov.dogwalk.model.entity.security.Role;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "walker")
public class Walker extends AccountUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Singular
    @ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "walker_role", joinColumns = @JoinColumn(name = "walker_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birthday")
    private LocalDate birthday;

    @OneToOne(targetEntity = City.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "social_links")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> socialLinks;

    @Column(name = "citizenship")
    private String citizenship;

    @OneToMany(targetEntity = Walking.class,
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY,
            mappedBy = "walker")
    private Set<Walking> walkings;
}
