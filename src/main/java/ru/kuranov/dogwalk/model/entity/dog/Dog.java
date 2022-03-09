package ru.kuranov.dogwalk.model.entity.dog;

import lombok.*;
import ru.kuranov.dogwalk.model.entity.addition.HowGetPet;
import ru.kuranov.dogwalk.model.entity.addition.MeetingToWalker;
import ru.kuranov.dogwalk.model.entity.addition.WashPaws;
import ru.kuranov.dogwalk.model.entity.behavior.Aggression;
import ru.kuranov.dogwalk.model.entity.behavior.PickItUp;
import ru.kuranov.dogwalk.model.entity.behavior.PickUpFromGround;
import ru.kuranov.dogwalk.model.entity.behavior.PullingLeash;
import ru.kuranov.dogwalk.model.entity.location.WalkingPlace;
import ru.kuranov.dogwalk.model.entity.time.Schedule;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "dog")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "breed")
    private String breed;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "weight")
    private int weight;

    @Column(name = "weight_group")
    @Enumerated(EnumType.STRING)
    private WeightGroup weightGroup;

    @Column(name = "documents")
    @ElementCollection(fetch = FetchType.EAGER)
    private Map<DogDocuments, Boolean> documents;

    @OneToOne(targetEntity = Vet.class,
            cascade = CascadeType.ALL,
            optional = false)
    @JoinColumn(name = "vet_id")
    private Vet vet;

    @OneToOne(targetEntity = Injury.class,
            cascade = CascadeType.ALL,
            optional = false)
    @JoinColumn(name = "injury_id")
    private Injury injury;

    @Column(name = "pulling_leash")
    @Enumerated(EnumType.STRING)
    private PullingLeash pullingLeash;

    @Column(name = "pick_up_from_ground")
    @Enumerated(EnumType.STRING)
    private PickUpFromGround pickUpFromGround;

    @Column(name = "pick_it_up")
    @Enumerated(EnumType.STRING)
    private PickItUp pickItUp;

    @Column(name = "fear")
    private String fear;

    @Column(name = "aggression")
    @Enumerated(EnumType.STRING)
    private Aggression aggression;

    @Column(name = "is_go_without_leash")
    private boolean isGoWithoutLeash;

    @Column(name = "is_interact_with_other_dogs")
    private boolean isInteractWithOtherDogs;

    @Column(name = "is_wash_paws")
    private boolean isWashPaws;

    @Column(name = "wash_paws")
    @Enumerated(EnumType.STRING)
    private WashPaws washPaws;

    @Column(name = "feed_after_walk")
    private boolean isFeedAfterWalk;

    @Column(name = "feed")
    private String feed;

    @Column(name = "portion")
    private String portion;

    @Column(name = "walking_time")
    private String walkingTime;

    @OneToOne(targetEntity = Schedule.class,
            cascade = CascadeType.ALL,
            optional = false)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @Column(name = "meeting_to_walker")
    @Enumerated(EnumType.STRING)
    private MeetingToWalker meetingToWalker;

    @Column(name = "how_get_pet")
    private HowGetPet howGetPet;

    @Column(name = "addition_info")
    private String additionInfo;

    @OneToMany(mappedBy = "dog")
    private List<WalkingPlace> walkingPlace;
}
