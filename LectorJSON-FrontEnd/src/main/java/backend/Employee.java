package backend;

public class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private String photo;

    public Employee(String id, String firstName, String lastName, String photo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
    }

    public Employee() {
        this.id = "default";
        this.firstName = "firstName";
        this.lastName = "lastName";
        this.photo = "photo";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return this.id + ";" + this.firstName + ";" + this.lastName + ";" + this.photo;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof Employee)) {
            return false;
        }

        Employee other = (Employee) o;

        if (other.getId().equals(this.getId())) {
            return true;
        }
        return false;
    }

}
