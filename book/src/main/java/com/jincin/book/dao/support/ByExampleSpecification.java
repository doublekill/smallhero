package com.jincin.book.dao.support;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.convert.QueryByExamplePredicateBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.Assert;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/******************************************
 * Created by dongwujing on 2017/6/28.
 *
 ******************************************/
public class ByExampleSpecification<T> implements Specification<T> {
    private final Example<T> example;

    public ByExampleSpecification(Example<T> example) {

        Assert.notNull(example, "Example must not be null!");
        this.example = example;
    }


    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return QueryByExamplePredicateBuilder.getPredicate(root, cb, example);
    }
}
