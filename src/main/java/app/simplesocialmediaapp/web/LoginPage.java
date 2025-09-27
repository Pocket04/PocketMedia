package app.simplesocialmediaapp.web;

import app.simplesocialmediaapp.users.models.User;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.spring.security.AuthenticationContext;
import com.vaadin.flow.theme.lumo.LumoUtility;

import app.simplesocialmediaapp.users.services.UserService;
import app.simplesocialmediaapp.web.modules.SiteFooter;
import app.simplesocialmediaapp.web.modules.SiteHeader;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Route("login")
public class LoginPage extends VerticalLayout {

    private final UserService userService;
    private LoginForm loginForm = new LoginForm();
    private SiteFooter siteFooter = new SiteFooter();

    @Autowired
    public LoginPage(UserService userService, AuthenticationContext context) {
        this.userService = userService;
        loginForm.addClassName("login-form");
        loginForm.setAction("login");
        setSizeFull();

        SiteHeader siteHeader = new SiteHeader(context);
        getThemeList().add("dark");
        loginForm.getStyle().set("margin-top", "auto");
        loginForm.getStyle().set("margin-bottom", "auto");

        addClassName("back");

        add(siteHeader, loginForm, siteFooter);
        addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.JustifyContent.START);
    }
}
