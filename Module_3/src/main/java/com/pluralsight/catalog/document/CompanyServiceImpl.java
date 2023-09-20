package com.pluralsight.catalog.document;

import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;

import java.util.List;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;

@WebService(endpointInterface = "com.pluralsight.catalog.document.CompanyService")
public class CompanyServiceImpl implements CompanyService {

    Logger LOG = Logger.getLogger(CompanyServiceImpl.class.getName());

    @PersistenceContext
    EntityManager em;

    @Override
    public Company findById(Long id) {
        LOG.info("Getting company #" + id + "from DB...");
        return (Company) em
                .createQuery(String.format("select c from Company c where c.id = '%d'", id))
                .getSingleResult();
    }

    @Override
    public List<Company> findAll() {
        LOG.info("Getting all companies from DB...");
        TypedQuery<Company> query = em.createQuery(String.format("select c from Company c"), Company.class);
        return query.getResultList();
    }

    @Override
    public Company save(Company company) {
        LOG.info("Saving company: " + company.getName() + "...");
        UserTransaction transaction;
        try {
            transaction = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
            transaction.begin();
            em.joinTransaction();
            if (!em.contains(company)) {
                company = em.merge(company);
            }
            em.persist(company);
            transaction.commit();
            return company;
        } catch (SecurityException | IllegalStateException | NamingException | NotSupportedException
                | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Company remove(Long id) {
        Company company = this.findById(id);
        LOG.info("Removing company: " + company.getName() + " from DB...");
        UserTransaction transaction;

        try {
            transaction = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
            transaction.begin();
            em.joinTransaction();
            if (!em.contains(company)) {
                company = em.merge(company);
            }
            em.remove(company);
            transaction.commit();
            return company;
        } catch (SecurityException | IllegalStateException | NamingException | NotSupportedException
                | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
            e.printStackTrace();
        }
        return null;
    }

}
