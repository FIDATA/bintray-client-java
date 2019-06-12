package com.jfrog.bintray.client.api.handle;

import com.jfrog.bintray.client.api.BintrayCallException;
import com.jfrog.bintray.client.api.details.ProprietaryLicenseDetails;
import com.jfrog.bintray.client.api.model.ProprietaryLicense;

import java.io.IOException;

/**
 * @author Basil Peace
 */
public interface ProprietaryLicenseHandle extends Handle<ProprietaryLicense> {

    String name();

    SubjectHandle owner();

    ProprietaryLicense get() throws IOException, BintrayCallException;

    ProprietaryLicenseHandle update(ProprietaryLicenseDetails productDetails) throws IOException, BintrayCallException;

    ProprietaryLicenseHandle delete() throws BintrayCallException;

    boolean exists() throws BintrayCallException;
}