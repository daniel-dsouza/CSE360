package org.teamone.client.generic;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Person;

/**
 * Created by daniel on 10/7/15.
 */
@Component
@Scope("session")
public class User{

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Person person;
    public Patient patient;

    public User() {
        super();
    }
}