package app.simplesocialmediaapp.web;

import app.simplesocialmediaapp.web.modules.SiteFooter;
import app.simplesocialmediaapp.web.modules.SiteHeader;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.component.html.H1;
import app.simplesocialmediaapp.users.services.UserService;
import app.simplesocialmediaapp.web.requests.CreateUserRequest;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.flow.component.button.Button;

@Route("register")
public class RegisterPage extends VerticalLayout {

    private final UserService userService;

    private H1 h1 = new H1("Register");
    private TextField usernameField = new TextField("Username");
    private EmailField emailField = new EmailField("Email");
    private PasswordField passwordField = new PasswordField("Password");
    private Button registerButton = new Button("Register", e -> {
        usernameField.blur();
        emailField.blur();
        passwordField.blur();
        register();
    });
    private VerticalLayout div = new VerticalLayout(h1, usernameField, emailField, passwordField, registerButton);

    @Autowired
    public RegisterPage(UserService userService) {
        this.userService = userService;
        setSizeFull();

        addClassName("back");

        SiteHeader header = new SiteHeader("Register", "/login", "Login");
        SiteFooter footer = new SiteFooter();

        usernameField.setRequired(true);
        emailField.setRequired(true);
        passwordField.setRequired(true);

        div.getThemeList().add("dark");
        div.setWidth("20vw");
        div.setMargin(true);
        div.getStyle().set("margin-top", "auto");
        div.getStyle().set("margin-bottom", "auto");
        div.getStyle().set("background-color", "#00000000");
        div.getStyle().set("border-radius", "8px");
        div.getStyle().set("box-shadow", "inset 0px 0px 10px grey");
        div.addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.JustifyContent.CENTER, LumoUtility.Padding.MEDIUM);

        registerButton.addClickShortcut(Key.ENTER);

        add(header, div, footer);
        addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.JustifyContent.CENTER);

    }

    private void register(){
        CreateUserRequest dto = new CreateUserRequest(emailField.getValue(), usernameField.getValue(), passwordField.getValue());

        try{
            userService.createUser(dto);
            Notification.show("Registered Successfully!");
        }catch (Exception e){
            Notification.show("Oh no! Something went wrong!");
        }
    }
}
