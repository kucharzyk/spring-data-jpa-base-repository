package pl.net.kt.baserepository;

import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends BaseRepository<Post, Long> {

    Post findByTitle(String title);

    @Query("from Post where title = :title")
    Post findByTitleUsingQuery(String title);

    default Post findByTitleUsingEntityManager(String title) {
        return getEntityManager()
                .createQuery("select p from Post p where p.title = :title", Post.class)
                .setParameter("title", title)
                .getSingleResult();
    }

}
