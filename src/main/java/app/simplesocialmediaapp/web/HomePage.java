package app.simplesocialmediaapp.web;

import app.simplesocialmediaapp.web.modules.SiteFooter;
import app.simplesocialmediaapp.web.modules.SiteHeader;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.security.AuthenticationContext;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
@PermitAll
public class HomePage extends VerticalLayout {

    private TextField header = new TextField("Header");
    private TextArea body = new TextArea("Body");
    private SiteFooter siteFooter = new SiteFooter();

    public HomePage(@Autowired AuthenticationContext context){
        setSizeFull();
        addClassName("back");

        SiteHeader siteHeader = new SiteHeader(context);

        body.setPlaceholder("Write your post here...");
        body.setWidthFull();
        body.setHeight("200px");

        add(siteHeader, header, body, siteFooter);
    }


}
