package com.springboot.dev_spring_boot_demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.dev_spring_boot_demo.entity.Coffee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CoffeeDAOImp implements CoffeeDAO {
    private EntityManager em;
    
    public CoffeeDAOImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Coffee> findAll() {
        TypedQuery<Coffee> query = em.createQuery("from Coffee", Coffee.class);
        return query.getResultList();
    }

    @Override
    public Coffee findById(int id) {
        return em.find(Coffee.class, id);
    }

    @Override
    @Transactional
    public Coffee save(Coffee coffee) {
        return em.merge(coffee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Coffee coffee = em.find(Coffee.class, id);
        if (coffee != null) {
            em.remove(coffee);
        }
    }
}
