package com.universites.test;

import com.universites.dao.UniversiteDao;
import com.universites.entities.Universite;

public class UniversiteTest {

    public static void main(String[] args) {
        // Créer un objet Université
        Universite u = new Universite();
        u.setNomUni("Université de Tunis");
        u.setAdresseUni("Tunis, Tunisie");
        u.setEmail("contact@univ-tunis.tn");
        u.setNbEtudiants(15000);

        // Ajouter l'université à la BD
        UniversiteDao uniDao = new UniversiteDao();
        uniDao.ajouter(u);

        System.out.println("Appel de la méthode listerToutes");
        for (Universite uni : uniDao.listerToutes())
            System.out.println(uni.getIdUni() + " " + uni.getNomUni());

        System.out.println("Appel de la méthode listerParNom");
        for (Universite uni : uniDao.listerParNom("Tunis"))
            System.out.println(uni.getIdUni() + " " + uni.getNomUni());

        // Tester les autres méthodes de la classe UniversiteDao
    }
}
