package app.simplesocialmediaapp.web.modules;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.spring.security.AuthenticationContext;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.springframework.beans.factory.annotation.Autowired;

public class SiteHeader extends HorizontalLayout {


    public SiteHeader(AuthenticationContext context){
        setWidthFull();
        setPadding(true);
        getThemeList().add("dark");

        getStyle().set("margin-bottom", "auto");
        getStyle().set("background-color", "#00000000");
        getStyle().set("border-radius", "8px");
        getStyle().set("box-shadow", "inset 0px 0px 10px grey");
        getStyle().set("color", "hsla(214, 87%, 92%, 0.69)");
        addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.JustifyContent.CENTER);

        H1 text = new H1("PocketMedia");
        text.getStyle().set("color", "hsl(214, 100%, 98%)");
        expand(text);

        Button log = new Button();
        add(text, log);
        if (context.isAuthenticated()){
            log.setText("Logout");
            log.addClickListener(e -> context.logout());
        }else {
            Button register = new Button("Register", e -> getUI().ifPresent(ui -> ui.getPage().setLocation("/register")));
            log.setText("LogIn");
            log.addClickListener(e -> getUI().ifPresent(ui -> ui.getPage().setLocation("/login")));
            add(register);
        }
    }


}
