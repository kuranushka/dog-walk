package ru.kuranov.dogwalk.model.entity.walker;

import lombok.*;
import ru.kuranov.dogwalk.model.entity.location.Citizenship;
import ru.kuranov.dogwalk.model.entity.location.City;

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
public class Walker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

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

    @Column(name = "is_have_previous_conviction")
    private boolean isHavePreviousConviction;

    @Column(name = "social_links")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> socialLinks;

    @OneToOne(targetEntity = Citizenship.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "walker")
    private Citizenship citizenship;
}
