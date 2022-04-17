package org.genesiscode.mockwebsis.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "groups")
public class Group {

    @Id
    private String id;

    private Integer numberOfStudent;

    @ManyToMany(mappedBy = "groups")
    private Set<Subject> subjects = new HashSet<>();

    public Group(String id, Integer numberOfStudent) {
        this.id = id;
        this.numberOfStudent = numberOfStudent;
    }
}
