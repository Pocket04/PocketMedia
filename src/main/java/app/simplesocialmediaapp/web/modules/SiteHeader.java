package app.simplesocialmediaapp.web.modules;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class SiteHeader extends HorizontalLayout {

    public SiteHeader(String curr, String anchor, String name){
        setWidthFull();
        setPadding(true);
        getThemeList().add("dark");

        getStyle().set("background-color", "#00000000");
        getStyle().set("border-radius", "8px");
        getStyle().set("box-shadow", "inset 0px 0px 10px grey");
        getStyle().set("color", "hsla(214, 87%, 92%, 0.69)");
        addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.JustifyContent.CENTER);

        H1 text = new H1(curr);
        text.getStyle().set("color", "hsl(214, 100%, 98%)");
        Anchor a = new Anchor(anchor);
        Button button = new Button(name);
        a.add(button);
        expand(text);

        add(text, a);
    }


}
