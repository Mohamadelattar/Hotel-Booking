package com.booking.repository;

import com.booking.model.Equipment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EquipmentRepositoryImpl implements EquipmentRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveEquipment(Equipment equipment) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save or Update Method
        currentSession.saveOrUpdate(equipment);
    }

    @Override
    public void deleteEquipment(int id) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete a equipment by Id using Hibernate query
        Query query = currentSession.createQuery("delete from Equipment where id=:equipmentId");
        query.setParameter("equipmentId", id);

        query.executeUpdate();
    }

    @Override
    public Equipment getEquipment(int id) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // get specific Equipment
        return currentSession.get(Equipment.class,id);
    }

    @Override
    public List<Equipment> getEquipments() {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // get all equipments using a querry
        Query<Equipment> query = currentSession.createQuery("from Equipment",Equipment.class);

        List<Equipment> equipments =  query.getResultList();

        return equipments;
    }
}
