package org.genesiscode.mockwebsis.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @SequenceGenerator(name = "subject_sequence", sequenceName = "subject_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_sequence")
    private Long id;

    private String name;

    @Column(unique = true)
    private String code;

    @Enumerated(value = EnumType.STRING)
    private Semester semester;

    public Subject(String name, String code, Semester semester) {
        this.name = name;
        this.code = code;
        this.semester = semester;
    }
}
