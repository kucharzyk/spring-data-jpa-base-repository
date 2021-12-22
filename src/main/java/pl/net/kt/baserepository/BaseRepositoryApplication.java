package pl.net.kt.baserepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class BaseRepositoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseRepositoryApplication.class, args);
    }

}
