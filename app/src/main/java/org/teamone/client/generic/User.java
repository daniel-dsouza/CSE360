package org.teamone.client.generic;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Person;
import org.teamone.core.users.Staff;

import java.util.Date;

/**
 * Created by daniel on 10/7/15.
 */
@Component
@Scope("session")
public class User {

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

    public Staff getDoctor() {
        return doctor;
    }

    public void setDoctor(Staff doctor) {
        this.doctor = doctor;
    }

    public Date getSettingsTime() {
        return settingsTime;
    }

    public void setSettingsTime(Date settingsTime) {
        this.settingsTime = settingsTime;
    }

    public Person person;
    public Patient patient;
    public Staff doctor;
    private Date settingsTime = null;

    public User() {
        super();
    }
}