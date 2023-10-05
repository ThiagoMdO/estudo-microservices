package com.curso.Nav.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return Objects.equals(id, person.id)
                        && Objects.equals(firstName, person.firstName)
                        && Objects.equals(lastName, person.lastName)
                        && Objects.equals(address, person.address)
                        && Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, gender);
    }
}
