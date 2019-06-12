package com.jfrog.bintray.client.api.details;

import com.jfrog.bintray.client.api.ObjectMapperHelper;
import org.codehaus.jackson.annotate.*;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to serialize and deserialize the needed json to
 * pass to or receive from Bintray when performing actions on an OSS license
 * NOTE: when serializing this class use getObjectMapper to obtain a suitable mapper for this class
 *
 * @author Dan Feldman
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OssLicenseDetails {

    //Properties marked with @JsonPropery here are serialized to the create \ update package requests, the rest are
    // only deserialized when getting the package info
    @JsonProperty
    private String name;
    @JsonProperty
    private String longname;
    @JsonProperty
    private String url;

    //All other props that don't have specific fields
    private Map<String, Object> other = new HashMap<>();

    @JsonAnySetter
    public void set(String name, Object value) {
        other.put(name, value);
    }

    @JsonAnyGetter
    public Map<String, Object> other() {
        return other;
    }

    @JsonCreator
    public OssLicenseDetails() {
    }

    public static ObjectMapper getObjectMapper() {
        return ObjectMapperHelper.get();
    }

    public OssLicenseDetails name(String name) {
        this.name = name;
        return this;
    }

    public OssLicenseDetails longname(String longname) {
        this.longname = longname;
        return this;
    }

    public OssLicenseDetails url(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongname() {
        return longname;
    }

    public void setLongname(String longname) {
        this.longname = longname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
