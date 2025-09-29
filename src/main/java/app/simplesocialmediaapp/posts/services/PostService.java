package app.simplesocialmediaapp.posts.services;

import app.simplesocialmediaapp.posts.models.Post;
import app.simplesocialmediaapp.posts.repositories.PostRepository;
import app.simplesocialmediaapp.web.requests.CreatePostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return postRepository.save(post);
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

}
