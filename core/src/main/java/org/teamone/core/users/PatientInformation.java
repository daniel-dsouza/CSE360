package org.teamone.core.users;

/**
 * Created by daniel on 10/11/15.
 */
public class PatientInformation {
    private String name;
    private String firstName ="";
    private String lastName ="";
    private String age;
    private String address;
    private String city;
    private String state;
    private String zipcode;
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
        splitAddress();
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        concatAddress();
    }

    public String getCity() {
        splitAddress();
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        concatAddress();
    }

    public String getState() {
        splitAddress();
        return state;
    }

    public void setState(String state) {
        this.state = state;
        concatAddress();
    }

    public String getZipcode() {

        splitAddress();
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
        concatAddress();
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
        concatName();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        concatName();
    }
    public void concatName()
    {
        name = lastName + ":" + firstName;
    }
    public void splitName()
    {
        String[] data = name.split(":");
        firstName = data[0];
        lastName = data[1];
    }
    public void concatAddress()
    {
        address = address + ":" + city + ":" + state + ":" + zipcode;
    }
    public void splitAddress()
    {
        String[] data = address.split(":");
        address = data[0];
        city = data[1];
        state = data[2];
        zipcode =data[3];
    }
}
