package com.jfrog.bintray.client.impl.model;

import com.jfrog.bintray.client.api.ObjectMapperHelper;
import com.jfrog.bintray.client.api.details.OssLicenseDetails;
import com.jfrog.bintray.client.api.model.OssLicense;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * @author Basil Peace
 */
public class OssLicenseImpl implements OssLicense {
    private static final Logger log = LoggerFactory.getLogger(OssLicenseImpl.class);

    private String name;
    private String longname;
    private String url;
    private Map<String, Object> other;

    public OssLicenseImpl(OssLicenseDetails ossLicenseDetails) {
        this.name = ossLicenseDetails.getName();
        this.longname = ossLicenseDetails.getLongname();
        this.url = ossLicenseDetails.getUrl();
        this.other = ossLicenseDetails.other();
    }

    public OssLicenseImpl(String name, String longname, String url) {
        this.name = name;
        this.longname = longname;
        this.url = url;
    }

    public static String getCreateUpdateJson(OssLicenseDetails packageDetails) throws IOException {
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
    public String longname() {
        return longname;
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

        OssLicenseImpl aPackage = (OssLicenseImpl) o;

        if (!name.equals(aPackage.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "OssLicense{" +
                "getName='" + name + '\'' +
                ", longname='" + longname + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
