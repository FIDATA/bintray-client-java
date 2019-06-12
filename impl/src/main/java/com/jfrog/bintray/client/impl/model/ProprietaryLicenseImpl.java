package com.jfrog.bintray.client.impl.model;

import com.jfrog.bintray.client.api.ObjectMapperHelper;
import com.jfrog.bintray.client.api.details.ProprietaryLicenseDetails;
import com.jfrog.bintray.client.api.model.ProprietaryLicense;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * @author Basil Peace
 */
public class ProprietaryLicenseImpl implements ProprietaryLicense {
    private static final Logger log = LoggerFactory.getLogger(ProprietaryLicenseImpl.class);

    private String name;
    private String description;
    private String url;
    private Map<String, Object> other;

    public ProprietaryLicenseImpl(ProprietaryLicenseDetails proprietaryLicenseDetails) {
        this.name = proprietaryLicenseDetails.getName();
        this.description = proprietaryLicenseDetails.getDescription();
        this.url = proprietaryLicenseDetails.getUrl();
        this.other = proprietaryLicenseDetails.other();
    }

    public ProprietaryLicenseImpl(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public static String getCreateUpdateJson(ProprietaryLicenseDetails packageDetails) throws IOException {
        ObjectMapper mapper = ObjectMapperHelper.get();
        String jsonContent;
        try {
            jsonContent = mapper.writeValueAsString(packageDetails);
        } catch (IOException e) {
            log.error("Can't process the json file: " + e.getMessage());
            throw e;
        }
        return jsonContent;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public Object getFieldByKey(String key) {
        return other.get(key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProprietaryLicenseImpl aPackage = (ProprietaryLicenseImpl) o;

        if (!name.equals(aPackage.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "ProprietaryLicense{" +
                "getName='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
