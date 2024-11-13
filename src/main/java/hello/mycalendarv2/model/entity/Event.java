package hello.mycalendarv2.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "event")
public class Event extends DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVENT_ID")
    Long id;

    String title;

    String contexts;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

}
