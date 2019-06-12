package com.jfrog.bintray.client.api.model;

/**
 * @author Basil Peace
 */
public interface OssLicense {

  String name();

  String longname();

  String url();

  Object getFieldByKey(String key);
}
