package com.example.importaccess.model.filter;

import java.time.LocalDateTime;

import com.example.importaccess.model.Access;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

public class AccessFilter extends Access {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SS")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SS")
    private LocalDateTime dataInicio;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SS")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SS")
    private LocalDateTime dataFim;

    public AccessFilter() {
        super();
    }

    public AccessFilter(String ip, LocalDateTime data, String request, String userAgent, Integer status) {
        super.setIp(ip);
        super.setData(data);
        super.setRequest(request);
        super.setUserAgent(userAgent);
        super.setStatus(status);
    }

    public AccessFilter(String ip, LocalDateTime data, String request, String userAgent, Integer status, LocalDateTime dataInicio, LocalDateTime dataFim) {
        super.setIp(ip);
        super.setData(data);
        super.setRequest(request);
        super.setUserAgent(userAgent);
        super.setStatus(status);
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public AccessFilter(String ip) {
        super.setIp(ip);
    }

    /**
     * @return the dataInicio
     */
    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataFim
     */
    public LocalDateTime getDataFim() {
        return dataFim;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
        result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        AccessFilter other = (AccessFilter) obj;
        if (dataFim == null) {
            if (other.dataFim != null)
                return false;
        } else if (!dataFim.equals(other.dataFim))
            return false;
        if (dataInicio == null) {
            if (other.dataInicio != null)
                return false;
        } else if (!dataInicio.equals(other.dataInicio))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AccessFilter [dataFim=" + dataFim + ", dataInicio=" + dataInicio + "]";
    }

}