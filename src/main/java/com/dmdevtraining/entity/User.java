package com.dmdevtraining.entity;

import com.dmdevtraining.converter.BirthDateConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Users")
public class User {

    @Id
    private String username;
    private String firstname;
    private String lastname;
//    @Convert(converter = BirthDateConverter.class)
    @Column(name = "birth_date")
    private Birthdate birthDate;
    @Enumerated(EnumType.STRING)
    private Role role;


    @Override
    public String toString() {
        return "User{" +
               "username='" + username + '\'' +
               ", firstname='" + firstname + '\'' +
               ", lastname='" + lastname + '\'' +
               ", birthDate=" + birthDate +
               ", role=" + role +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(username, user.username) && Objects.equals(firstname, user.firstname) && Objects.equals(lastname, user.lastname) && Objects.equals(birthDate, user.birthDate) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, firstname, lastname, birthDate, role);
    }
}
