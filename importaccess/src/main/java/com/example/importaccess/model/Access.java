package com.example.importaccess.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@IdClass(AccessId.class)
public class Access implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    private String ip;
    @Id
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SS")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SS")
    private LocalDateTime data;
    private String request;
    private String userAgent;
    private Integer status;

    public Access() {
    }

    public Access(final String ip, final LocalDateTime date, final String request, final String userAgent,
            final Integer status) {
        this.ip = ip;
        this.data = date;
        this.request = request;
        this.userAgent = userAgent;
        this.status = status;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(final String ip) {
        this.ip = ip;
    }

    /**
     * @return the data
     */
    public LocalDateTime getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(final LocalDateTime data) {
        this.data = data;
    }

    /**
     * @return the request
     */
    public String getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(final String request) {
        this.request = request;
    }

    /**
     * @return the userAgent
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * @param userAgent the userAgent to set
     */
    public void setUserAgent(final String userAgent) {
        this.userAgent = userAgent;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(final Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Log [data=" + data + ", ip=" + ip + ", request=" + request + ", status=" + status + ", userAgent="
                + userAgent + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((ip == null) ? 0 : ip.hashCode());
        result = prime * result + ((request == null) ? 0 : request.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((userAgent == null) ? 0 : userAgent.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Access other = (Access) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (ip == null) {
            if (other.ip != null)
                return false;
        } else if (!ip.equals(other.ip))
            return false;
        if (request == null) {
            if (other.request != null)
                return false;
        } else if (!request.equals(other.request))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        if (userAgent == null) {
            if (other.userAgent != null)
                return false;
        } else if (!userAgent.equals(other.userAgent))
            return false;
        return true;
    }

}