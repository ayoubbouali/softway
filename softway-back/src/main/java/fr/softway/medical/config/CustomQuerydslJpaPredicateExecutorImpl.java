package fr.softway.medical.config;

import com.querydsl.core.JoinExpression;
import com.querydsl.core.QueryMetadata;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.data.jpa.repository.support.QuerydslJpaPredicateExecutor;
import org.springframework.data.querydsl.EntityPathResolver;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import javax.persistence.EntityManager;
import java.util.List;

public class CustomQuerydslJpaPredicateExecutorImpl<T> extends QuerydslJpaPredicateExecutor<T> implements CustomQuerydslJpaPredicateExecutor<T> {

    private final EntityPath<T> path;
    private final Querydsl querydsl;

    public CustomQuerydslJpaPredicateExecutorImpl(final JpaEntityInformation<T, ?> entityInformation, final EntityManager entityManager, final EntityPathResolver resolver, @Nullable CrudMethodMetadata metadata) {
        super(entityInformation, entityManager, resolver, metadata);
        this.path = resolver.createPath(entityInformation.getJavaType());
        this.querydsl = new Querydsl(entityManager, new PathBuilder<>(path.getType(), path.getMetadata()));
    }

    @Override
    public Page<T> findAll(final Predicate predicate, final Pageable pageable, final List<JoinExpression> joinExpressions) {
        Assert.notNull(predicate, "Predicate must not be null!");
        Assert.notNull(pageable, "Pageable must not be null!");

        final JPQLQuery<?> countQuery = createCountQuery(predicate);
        JPQLQuery<T> query = querydsl.applyPagination(pageable, createQuery(predicate).select(path));

        final QueryMetadata queryMetadata = query.getMetadata();
        for (JoinExpression jp : joinExpressions) {
            queryMetadata.addJoin(jp.getType(), jp.getTarget());
            query = query.fetchJoin();
        }

        return PageableExecutionUtils.getPage(query.fetch(), pageable, countQuery::fetchCount);
    }
}
