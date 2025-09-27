package app.simplesocialmediaapp.web.requests;

import app.simplesocialmediaapp.users.models.User;

public class CreatePostRequest {

    private User poster;

    private String header;

    private String body;

    public CreatePostRequest(User poster, String header, String body) {
        this.poster = poster;
        this.header = header;
        this.body = body;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}