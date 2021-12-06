package com.booking.repository;

import com.booking.model.CategoryEquipment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryEquipmentRepositoryImpl implements CategoryEquipmentRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveCategoryEquipment(CategoryEquipment categoryEquipment) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save or Update Method
        currentSession.saveOrUpdate(categoryEquipment);
    }

    @Override
    public void deleteCategoryEquipment(int id) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete a category equipment by Id using Hibernate query
        Query query =
                currentSession.createQuery("delete from CategoryEquipment where id=:categoryEquipmentId");
        query.setParameter("categoryEquipmentId", id);

        query.executeUpdate();
    }

    @Override
    public CategoryEquipment getCategoryEquipment(int id) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // get specific categoryEquipment
        return currentSession.get(CategoryEquipment.class,id);
    }

    @Override
    public List<CategoryEquipment> getCategoriesEquipments() {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // get all Categories equipments using a querry
        Query<CategoryEquipment> query = currentSession.createQuery("from CategoryEquipment",CategoryEquipment.class);

        List<CategoryEquipment> categoriesEquipments =  query.getResultList();

        return categoriesEquipments;
    }
}
