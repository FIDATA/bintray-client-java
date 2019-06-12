package com.jfrog.bintray.client.api.model;

/**
 * @author Basil Peace
 */
public interface ProprietaryLicense {

  String name();

  String description();

  String url();

  Object getFieldByKey(String key);
}
