package autotests.model;

public class ClientData {
    private String salutation;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String country;
    private String postCode;
    private String phoneNumber;
    private String emailAddress;
    private String confirmEmailAddress;

    @Override
    public String toString() {
        return "ClientData{" +
                "salutation='" + salutation + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", postCode='" + postCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", confirmEmailAddress='" + confirmEmailAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientData that = (ClientData) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (postCode != null ? !postCode.equals(that.postCode) : that.postCode != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        return emailAddress != null ? emailAddress.equals(that.emailAddress) : that.emailAddress == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (postCode != null ? postCode.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        return result;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public String getAddress() {
        return address;
    }


    public String getCity() {
        return city;
    }


    public String getCountry() {
        return country;
    }


    public String getPostCode() {
        return postCode;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getEmailAddress() {
        return emailAddress;
    }

    public String getConfirmEmailAddress() {
        return confirmEmailAddress;
    }


    public ClientData withSalutation(String salutation) {
        this.salutation = salutation;
        return this;
    }

    public ClientData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ClientData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ClientData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ClientData withCity(String city) {
        this.city = city;
        return this;
    }

    public ClientData withCountry(String country) {
        this.country = country;
        return this;
    }

    public ClientData withPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public ClientData withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ClientData withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public ClientData withConfirmEmailAddress(String confirmEmailAddress) {
        this.confirmEmailAddress = confirmEmailAddress;
        return this;
    }

}
