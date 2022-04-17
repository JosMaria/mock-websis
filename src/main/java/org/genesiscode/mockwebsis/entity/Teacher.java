package org.genesiscode.mockwebsis.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
    private Long id;

    private String name;
    private String lastName;

    @Column(unique = true)
    private String email;
    private String password;

    public Teacher(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
