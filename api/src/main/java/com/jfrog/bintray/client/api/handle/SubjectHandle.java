package com.jfrog.bintray.client.api.handle;

import com.jfrog.bintray.client.api.BintrayCallException;
import com.jfrog.bintray.client.api.details.ProductDetails;
import com.jfrog.bintray.client.api.details.ProprietaryLicenseDetails;
import com.jfrog.bintray.client.api.details.RepositoryDetails;
import com.jfrog.bintray.client.api.model.Subject;

import java.io.IOException;

/**
 * @author Noam Y. Tenne
 */
public interface SubjectHandle extends Handle<Subject> {

    String name();

    Subject get() throws IOException, BintrayCallException;

    RepositoryHandle repository(String name);

    RepositoryHandle createRepo(RepositoryDetails repoDetails) throws IOException, BintrayCallException;

    ProductHandle product(String name);

    ProductHandle createProduct(ProductDetails productDetails) throws IOException, BintrayCallException;

    ProprietaryLicenseHandle license(String name);

    ProprietaryLicenseHandle createLicense(ProprietaryLicenseDetails proprietaryLicenseDetails) throws IOException, BintrayCallException;
}