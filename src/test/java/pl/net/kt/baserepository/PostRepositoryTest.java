package pl.net.kt.baserepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    public void shouldReturnPostsUsingEntityManager() {
        postRepository.saveAll(List.of(
                new Post("D1", "D1 content"),
                new Post("D2", "D2 content")
        ));

        var post = postRepository.findByTitleUsingEntityManager("D1");

        Assertions.assertThat(post.getContent()).isEqualTo("D1 content");
    }

    @Test
    public void shouldReturnPostsUsingQuery() {
        postRepository.saveAll(List.of(
                new Post("Q1", "Q1 content"),
                new Post("Q2", "Q2 content")
        ));

        var post = postRepository.findByTitleUsingQuery("Q1");

        Assertions.assertThat(post.getContent()).isEqualTo("Q1 content");
    }

    @Test
    public void shouldReturnPostsUsingConvention() {
        postRepository.saveAll(List.of(
                new Post("C1", "C1 content"),
                new Post("C2", "C2 content")
        ));

        var post = postRepository.findByTitle("C1");

        Assertions.assertThat(post.getContent()).isEqualTo("C1 content");
    }

}