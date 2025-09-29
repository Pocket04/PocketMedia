package app.simplesocialmediaapp.web;

import com.vaadin.flow.theme.lumo.LumoUtility;

import app.simplesocialmediaapp.posts.models.Post;
import app.simplesocialmediaapp.posts.services.PostService;
import app.simplesocialmediaapp.web.modules.SiteFooter;
import app.simplesocialmediaapp.web.modules.SiteHeader;
import app.simplesocialmediaapp.web.requests.CreatePostRequest;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.security.AuthenticationContext;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("")
@PermitAll
public class HomePage extends VerticalLayout {

    private final PostService postService;
    private TextField header = new TextField();
    private VerticalLayout div = new VerticalLayout();
    private TextArea body = new TextArea();
    private SiteFooter siteFooter = new SiteFooter();

    @Autowired
    public HomePage(AuthenticationContext context, PostService postService){
        this.postService = postService;

        setSizeFull();

        addClassName("back");
        List<Post> posts = postService.getAllPosts();

        SiteHeader siteHeader = new SiteHeader(context);

        header.setWidthFull();
        header.getStyle().set("color", "white");
        header.setPlaceholder("What do you think?");
        body.setWidthFull();
        body.setPlaceholder("Write your post here...");
        body.setHeight("100px");
        body.getStyle().set("color", "white");
        div.setWidth("50vw");
        div.setMargin(true);
        div.getStyle().set("margin-top", "auto");
        div.getStyle().set("margin-bottom", "auto");
        div.getStyle().set("border-radius", "8px");
        div.getStyle().set("box-shadow", "inset 0px 0px 10px grey");
        Button button = new Button("Post", e -> postService.createPost(new CreatePostRequest(header.getValue(), body.getValue())));
        button.getStyle().set("margin-left", "auto");
        div.add(header, body, button);

        add(siteHeader, div);
        VerticalLayout postsContainer = new VerticalLayout();
        postsContainer.getStyle().set("overflow", "auto");
        postsContainer.setWidthFull();
        postsContainer.addClassName("scrollable-layout");
        postsContainer.getStyle().set("padding", "0");

        for (Post post : posts) {
            VerticalLayout postDiv = new VerticalLayout();
            H3 header = new H3(post.getHeader());
            header.getStyle().set("color", "white");
            Paragraph p = new Paragraph(post.getBody());
            postDiv.add(header, p);
            postDiv.getStyle().set("white-space", "normal");
            postDiv.getStyle().set("word-break", "break-word");
            postDiv.getStyle().set("line-height", "1.6");
            postDiv.getStyle().set("margin-left", "0");
            postDiv.getStyle().set("margin-bottom", "5px");
            postDiv.getStyle().set("width", "50vw");
            postDiv.getStyle().set("color", "white");
            postDiv.getStyle().set("background-color", "#00000000");
            postDiv.getStyle().set("border-radius", "8px");
            postDiv.getStyle().set("box-shadow", "inset 0px 0px 10px grey");
            postsContainer.add(postDiv);
            postsContainer.addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.JustifyContent.START);
            postsContainer.setSpacing(false);
        }

        add(postsContainer, siteFooter);
        addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.JustifyContent.START);
    }


}
