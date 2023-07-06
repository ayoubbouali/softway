package fr.softway.medical.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = {
                "fr.softway.medical.repository"
        },
        repositoryFactoryBeanClass = RepositoryFactoryBean.class
)
public class RepositoryConfig {
}
