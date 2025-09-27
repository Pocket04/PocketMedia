package app.simplesocialmediaapp.posts.services;

import app.simplesocialmediaapp.posts.models.Post;
import app.simplesocialmediaapp.posts.repositories.PostRepository;
import app.simplesocialmediaapp.web.requests.CreatePostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(CreatePostRequest dto){
        Post post = new Post();
        post.setBody(dto.getBody());
        post.setHeader(dto.getHeader());
        post.setPoster(dto.getPoster());

        return postRepository.save(post);
    }
}
