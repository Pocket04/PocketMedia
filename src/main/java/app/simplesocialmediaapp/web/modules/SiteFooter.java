package app.simplesocialmediaapp.web.modules;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class SiteFooter extends HorizontalLayout {

    public SiteFooter(){
        setWidthFull();

        getStyle().set("margin-top", "auto");
        getStyle().set("background-color", "#00000000");
        getStyle().set("border-radius", "8px");
        getStyle().set("box-shadow", "inset 0px 0px 10px grey");
        getStyle().set("color", "hsla(214, 87%, 92%, 0.69)");
        addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.JustifyContent.CENTER);

        Paragraph copyright = new Paragraph("© Pocket Entertainment 2025");

        add(copyright);
    }

}
