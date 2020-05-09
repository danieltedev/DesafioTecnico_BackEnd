package com.example.importaccess.repository.specification;

import java.util.Objects;

import com.example.importaccess.model.Access;
import com.example.importaccess.model.filter.AccessFilter;

import org.springframework.data.jpa.domain.Specification;

public class AccessSpec {
    
    private AccessFilter accessFilter;

    public AccessSpec(AccessFilter accessFilter) {
        this.accessFilter = accessFilter;
    }

    private Specification<Access> ip() {
        if (Objects.isNull(this.accessFilter.getIp())) {
            return null;
        }
        return (root, query, builder) -> builder.like(root.get("ip"), "%" + this.accessFilter.getIp() + "%");
    }

    private Specification<Access> dataBetween() {
        if (Objects.isNull(this.accessFilter.getDataInicio()) || Objects.isNull(this.accessFilter.getDataFim())) {
            return null;
        }
        return (root, query, builder) -> builder.between(root.get("data"), this.accessFilter.getDataInicio(), this.accessFilter.getDataFim());
    }

    private Specification<Access> data() {
        if (Objects.isNull(this.accessFilter.getData())) {
            return null;
        }
        return (root, query, builder) -> builder.equal(root.get("data"), this.accessFilter.getData());
    }

    private Specification<Access> request() {
        if (Objects.isNull(this.accessFilter.getRequest())) {
            return null;
        }
        return (root, query, builder) -> builder.like(root.get("request"), "%" + this.accessFilter.getRequest() + "%");
    }

    private Specification<Access> userAgent() {
        if (Objects.isNull(this.accessFilter.getUserAgent())) {
            return null;
        }
        return (root, query, builder) -> builder.like(root.get("userAgent"), "%" + this.accessFilter.getUserAgent() + "%");
    }

    public Specification<Access> build() {
        return Specification.where(this.ip()).and(this.request()).and(this.userAgent()).and(this.dataBetween()).and(this.data());
    }
}