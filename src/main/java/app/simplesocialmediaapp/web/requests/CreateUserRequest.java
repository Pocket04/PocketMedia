package app.simplesocialmediaapp.web.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUserRequest {

    @Email(message = "Please enter a valid email.")
    private String email;
    @NotBlank(message = "Please enter a username!")
    private String userName;
    @NotBlank
    @Size(min = 6, max = 16, message = "Password must be between 6 and 16 characters!")
    private String password;

    public CreateUserRequest(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
