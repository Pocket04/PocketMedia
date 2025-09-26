package app.simplesocialmediaapp.web;

import com.vaadin.flow.theme.lumo.LumoUtility;

import app.simplesocialmediaapp.users.services.UserService;
import app.simplesocialmediaapp.web.modules.SiteFooter;
import app.simplesocialmediaapp.web.modules.SiteHeader;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("login")
public class LoginPage extends VerticalLayout {

    private final UserService userService;
    private LoginForm loginForm = new LoginForm();
    private SiteHeader siteHeader = new SiteHeader("Login", "/register", "Register");
    private SiteFooter siteFooter = new SiteFooter();


    @Autowired
    public LoginPage(UserService userService) {
        this.userService = userService;
        loginForm.addClassName("login-form");

        setSizeFull();

        getThemeList().add("dark");
        loginForm.getStyle().set("margin-top", "auto");
        loginForm.getStyle().set("margin-bottom", "auto");

        addClassName("back");




        add(siteHeader, loginForm, siteFooter);
addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.JustifyContent.START);
    }
}
