package com.dmdevtraining.entity;

import com.dmdevtraining.converter.BirthDateConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Convert;
import javax.persistence.Embeddable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class PersonalInfo {

    private String firstname;
    private String lastname;

    @Convert(converter = BirthDateConverter.class)
//    @Column(name = "birth_date")
    private Birthdate birthdate;

    @Override
    public String toString() {
        return "PersonalInfo{" +
               "firstname='" + firstname + '\'' +
               ", lastname='" + lastname + '\'' +
               ", birthdate=" + birthdate +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonalInfo that)) return false;
        return Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(birthdate, that.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, birthdate);
    }
}
