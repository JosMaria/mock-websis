package org.genesiscode.mockwebsis.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @SequenceGenerator(name = "classroom_sequence", sequenceName = "classroom_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classroom_sequence")
    private Long id;

    private String code;
    private Integer capacity;
    @Enumerated(EnumType.STRING)
    private RoomType type;

    public Room(String code, Integer capacity, RoomType type) {
        this.code = code;
        this.capacity = capacity;
        this.type = type;
    }
}
