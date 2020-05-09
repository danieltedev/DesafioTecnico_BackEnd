package com.example.importaccess.model;

public class RequestForUserAgent {
    
    private String userAgent;
    private Integer count;

    public RequestForUserAgent() {
    }

    public RequestForUserAgent(String userAgent, Integer count) {
        this.userAgent = userAgent;
        this.count = count;
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
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    /**
     * @return the count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((count == null) ? 0 : count.hashCode());
        result = prime * result + ((userAgent == null) ? 0 : userAgent.hashCode());
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
            RequestForUserAgent other = (RequestForUserAgent) obj;
        if (count == null) {
            if (other.count != null)
                return false;
        } else if (!count.equals(other.count))
            return false;
        if (userAgent == null) {
            if (other.userAgent != null)
                return false;
        } else if (!userAgent.equals(other.userAgent))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RequestForUserAgent [count=" + count + ", userAgent=" + userAgent + "]";
    }
}