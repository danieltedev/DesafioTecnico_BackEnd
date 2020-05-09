package com.example.importaccess.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.example.importaccess.model.Access;
import com.example.importaccess.model.RequestForIp;
import com.example.importaccess.repository.custom.RequestForIpRepositoryCustom;

import org.springframework.stereotype.Repository;

@Repository
public class RequestForIpRepositoryImpl implements RequestForIpRepositoryCustom {

    EntityManager em;

    public RequestForIpRepositoryImpl(final EntityManager em) {
        this.em = em;
    }

    @Override
    public List<RequestForIp> countRequestForIp() {
        final CriteriaBuilder criteria = em.getCriteriaBuilder();
        final CriteriaQuery<RequestForIp> query = criteria.createQuery(RequestForIp.class);

        final Root<Access> access = query.from(Access.class);
        query.multiselect(access.get("ip").as(String.class).alias("ip"),
                criteria.count(access.get("request")).as(Integer.class).alias("count"));
        query.groupBy(access.get("ip").as(String.class));

        final TypedQuery<RequestForIp> tquery = em.createQuery(query);
        return tquery.getResultList();
    }

}