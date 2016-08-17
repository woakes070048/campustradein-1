import com.google.common.base.MoreObjects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author ifeify
 */
public class RegistrationData {
    private String username;
    private String email;
    private String passwordOne;
    private String passwordTwo;
    private Gender gender;
    private String college;

    @NotNull(message = "username is not specified")
    @Size(min = 3, max = 20, message = "username must be between 3 and 20 characters")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordOne() {
        return passwordOne;
    }

    public void setPasswordOne(String passwordOne) {
        this.passwordOne = passwordOne;
    }

    public String getPasswordTwo() {
        return passwordTwo;
    }

    public void setPasswordTwo(String passwordTwo) {
        this.passwordTwo = passwordTwo;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("username", username)
                .add("email", email)
                .add("gender", gender)
                .add("passwordOne", passwordOne)
                .add("passwordTwo", passwordTwo)
                .add("college", college)
                .toString();
    }
}
