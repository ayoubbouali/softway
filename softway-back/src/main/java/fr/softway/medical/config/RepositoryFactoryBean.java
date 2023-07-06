package fr.softway.medical.config;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.querydsl.EntityPathResolver;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryComposition.RepositoryFragments;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import javax.persistence.EntityManager;
import java.io.Serializable;

import static org.springframework.data.querydsl.QuerydslUtils.QUERY_DSL_PRESENT;

public class RepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable> extends JpaRepositoryFactoryBean<R, T, I> {

    public RepositoryFactoryBean(final Class<? extends R> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new SimpleJpaExecutorFactory<>(entityManager);
    }

    private static class SimpleJpaExecutorFactory<T, I extends Serializable> extends JpaRepositoryFactory {

        public SimpleJpaExecutorFactory(EntityManager entityManager) {
            super(entityManager);
        }

        @Override
        protected RepositoryFragments getRepositoryFragments(final RepositoryMetadata metadata, final EntityManager entityManager, final EntityPathResolver resolver, final CrudMethodMetadata crudMethodMetadata) {
            boolean isQueryDslRepository = QUERY_DSL_PRESENT
                    && QuerydslPredicateExecutor.class.isAssignableFrom(metadata.getRepositoryInterface());

            if (isQueryDslRepository) {

                if (metadata.isReactiveRepository()) {
                    throw new InvalidDataAccessApiUsageException(
                            "Cannot combine Querydsl and reactive repository support in a single interface");
                }

                return RepositoryFragments.just(new CustomQuerydslJpaPredicateExecutorImpl<>(getEntityInformation(metadata.getDomainType()),
                        entityManager, resolver, crudMethodMetadata));
            }

            return RepositoryFragments.empty();
        }
    }
}