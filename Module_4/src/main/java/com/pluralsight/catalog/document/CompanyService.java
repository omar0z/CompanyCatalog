package com.pluralsight.catalog.document;

import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface CompanyService {

    Company findById(Long id);

    List<Company> findAll();

    Company save(Company company);

    Company remove(Long id);
}
