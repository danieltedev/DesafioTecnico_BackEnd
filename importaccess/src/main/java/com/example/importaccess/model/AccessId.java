package com.example.importaccess.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AccessId implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String ip;

    private LocalDateTime data;

    public AccessId() {
        
    }

    public AccessId(String ip, LocalDateTime data) {
        this.ip = ip;
        this.data = data;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((ip == null) ? 0 : ip.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AccessId other = (AccessId) obj;
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
        return true;
    }
    
}