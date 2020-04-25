package com.little_pig_bot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Builder
@ToString(exclude = "notes")
@EqualsAndHashCode(exclude = "notes")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"user\"")
public class User {

    @Id
    private Integer id;

    private String firstName;

    private String lastName;

    private String username;

    @JsonIgnore
    @Setter(AccessLevel.NONE)
    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Group> groups = new HashSet<>();

    public void addGroup(Group note) {
        this.getGroups().add(note);
        note.setUser(this);
    }
}
