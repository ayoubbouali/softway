package fr.softway.medical.config;

import com.querydsl.core.JoinExpression;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import java.util.List;

public interface CustomQuerydslJpaPredicateExecutor<T> extends QuerydslPredicateExecutor<T> {

    Page<T> findAll(Predicate predicate, Pageable pageable, List<JoinExpression> joinExpressions);
}
