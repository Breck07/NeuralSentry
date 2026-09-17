package com.simplyscan.backend.server.one;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IpGeoResponseDTO {
    private String status;
    private String country;
    private String regionName;
    private String city;
    private String query; // ip-api returns the IP address in a field named "query"

    // Default constructor is required by Jackson
    public IpGeoResponseDTO() {}

    // Getters and Setters must follow standard camelCase naming
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getRegionName() { return regionName; }
    public void setRegionName(String regionName) { this.regionName = regionName; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getQuery() { return query; }
    public void setQuery(String query) { this.query = query; }
}
