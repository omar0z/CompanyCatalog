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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;

 @WebService(endpointInterface = "com.pluralsight.catalog.rpc.DepartmentSupplierService")
 public class DepartmentSupplierServiceImpl  implements DepartmentSupplierService{

    Logger LOG = Logger.getLogger(DepartmentSupplierServiceImpl.class.getName());

    private Map<String, Integer> departmentSupplierMap;

    public DepartmentSupplierServiceImpl(){
        this.departmentSupplierMap = new HashMap<>();
        this.departmentSupplierMap.put("Painting", 1);
        this.departmentSupplierMap.put("Electrical", 2);
        this.departmentSupplierMap.put("Gardening", 3);
        this.departmentSupplierMap.put("Plumbing", 4);
        this.departmentSupplierMap.put("Flooring", 5);
        this.departmentSupplierMap.put("Roofing", 6);
        this.departmentSupplierMap.put("Insulation", 7);
        this.departmentSupplierMap.put("Windows", 8);
        this.departmentSupplierMap.put("Woodwork", 9);
    }

    @Override
    public int getSupplierPerDepartment(String department) {
        return this.departmentSupplierMap.get(department);
    }

}
