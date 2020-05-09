package com.example.importaccess.repository.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import com.example.importaccess.model.Access;
import com.example.importaccess.model.RequestForHour;
import com.example.importaccess.repository.custom.RequestForHourRepositoryCustom;

import org.springframework.stereotype.Repository;

@Repository
public class RequestForHourRepositoryImpl implements RequestForHourRepositoryCustom {

    EntityManager em;

    public RequestForHourRepositoryImpl(final EntityManager em) {
        this.em = em;
    }

    @Override
    public List<RequestForHour> countRequestForHour() {
        final CriteriaBuilder criteria = em.getCriteriaBuilder();
        final CriteriaQuery<RequestForHour> query = criteria.createQuery(RequestForHour.class);

        final Root<Access> access = query.from(Access.class);

        final Expression<Instant> dataGoup = criteria.function("date_trunc", Instant.class, criteria.literal("hour"),
                access.get("data"));

        query.multiselect(dataGoup.as(LocalDateTime.class).alias("date"),
                criteria.count(access.get("request")).as(Integer.class).alias("count"));
        query.groupBy(dataGoup);

        final TypedQuery<RequestForHour> tquery = em.createQuery(query);
        return tquery.getResultList();
    }

}