package com.universites.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import com.universites.entities.Universite;
import com.universites.util.JPAutil;

public class UniversiteDao {
    private EntityManager entityManager = JPAutil.getEntityManager("MonProjetJPA");

    // Ajouter une université à la BD
    public void ajouter(Universite u) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(u);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    // Modifier une université existante
    public void modifier(Universite u) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(u);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    // Supprimer une université
    public void supprimer(Universite u) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            u = entityManager.merge(u); // Important pour s'assurer que l'entité est managée
            entityManager.remove(u);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    // Consulter une université par ID
    public Universite consulter(Class<Universite> clazz, Object id) {
        return entityManager.find(clazz, id);
    }

    // Lister toutes les universités
    public List<Universite> listerToutes() {
        TypedQuery<Universite> query = entityManager.createQuery("SELECT u FROM Universite u", Universite.class);
        return query.getResultList();
    }

    // Lister les universités dont le nom contient un texte donné
    public List<Universite> listerParNom(String nom) {
        TypedQuery<Universite> query = entityManager.createQuery(
            "SELECT u FROM Universite u WHERE u.nomUni LIKE :pnom", Universite.class);
        query.setParameter("pnom", "%" + nom + "%");
        return query.getResultList();
    }
}
