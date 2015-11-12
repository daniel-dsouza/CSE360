package org.teamone.core.users;

/**
 * Created by daniel on 10/11/15.
 */
public class PatientInformation {
    private String name;
    private String firstName = "";
    private String lastName = "";
    private String age;
    private String address = "";
    private String city = "";
    private String state = "";
    private String zipcode = "";
    private String homePhone;
    private String email;
    private String insurance;
    private String ssn;
    private String gender;

    public PatientInformation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {

        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toStringName()//to SQL
    {
        name = firstName + ":" + lastName;
        return name;
    }

    public void splitName(String nam)//from SQL
    {
        String[] data = nam.split(":");
        firstName = data[0];
        lastName = data[1];
    }

    public String toStringAddress()//to SQL
    {
        address = address + ":" + city + ":" + state + ":" + zipcode;
        return address;
    }

    public void splitAddress(String add)//from SQL
    {
        String[] data = add.split(":");
        address = data[0];
        city = data[1];
        state = data[2];
        zipcode = data[3];
    }
}
