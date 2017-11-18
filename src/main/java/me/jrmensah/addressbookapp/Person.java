package me.jrmensah.addressbookapp;

        import org.hibernate.validator.constraints.Email;

        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.GenerationType;
        import javax.persistence.Id;
        import javax.validation.constraints.NotNull;
        import javax.validation.constraints.Size;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Size(min=2, message = "Please enter at least {min} characters")
    private String name;

    @NotNull
    @Email(message = "Please enter a valid email address")
    private String email;

    @NotNull
    @Size(min=3, max=10, message= "Please enter phone number")
    private String phoneNum;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}