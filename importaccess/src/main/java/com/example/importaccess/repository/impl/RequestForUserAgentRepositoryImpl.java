package com.example.importaccess.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.example.importaccess.model.Access;
import com.example.importaccess.model.RequestForUserAgent;
import com.example.importaccess.repository.custom.RequestForUserAgentRepositoryCustom;

import org.springframework.stereotype.Repository;

@Repository
public class RequestForUserAgentRepositoryImpl implements RequestForUserAgentRepositoryCustom {

    EntityManager em;

    public RequestForUserAgentRepositoryImpl(final EntityManager em) {
        this.em = em;
    }

    @Override
    public List<RequestForUserAgent> countRequestForUserAgent() {
        final CriteriaBuilder criteria = em.getCriteriaBuilder();
        final CriteriaQuery<RequestForUserAgent> query = criteria.createQuery(RequestForUserAgent.class);

        final Root<Access> access = query.from(Access.class);
        query.multiselect(access.get("userAgent").as(String.class).alias("userAgent"),
                criteria.count(access.get("request")).as(Integer.class).alias("count"));
        query.groupBy(access.get("userAgent").as(String.class));

        final TypedQuery<RequestForUserAgent> tquery = em.createQuery(query);
        return tquery.getResultList();
    }

}