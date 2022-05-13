package com.saitej.springormjpa.repos;

import com.saitej.springormjpa.entities.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
@Repository("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {


    private final EntityManagerFactory entityManagerFactory;

    public CustomerRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void insert(Customer customer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();

    }

    @Override
    public int remove(Long phoneNo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        int result = 0;
        try {
            Customer emp = entityManager.find(Customer.class, phoneNo);
            entityManager.remove(emp);
            result = 1;
            entityManager.getTransaction().commit();
        } catch (Exception exp) {
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
        return result;
    }

    @Override
    public List<Customer> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("Select c from Customer c ");
        return (List<Customer>)query.getResultList();
    }

    @Override
    public void update(Long phoneNo, String address) {
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Customer cust =  entityManager.find(Customer.class, phoneNo);
        cust.setAddress(address);
        entityManager.getTransaction().commit();
    }
}
