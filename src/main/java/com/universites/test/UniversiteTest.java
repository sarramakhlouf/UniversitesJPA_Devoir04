package com.universites.test;

import com.universites.dao.UniversiteDao;
import com.universites.entities.Universite;

public class UniversiteTest {

    public static void main(String[] args) {
        UniversiteDao uniDao = new UniversiteDao();
        
        // Ajouter une université
        Universite u1 = new Universite();
        u1.setNomUni("Université de Tunis");
        u1.setAdresseUni("Tunis, Tunisie");
        u1.setEmail("contact@univ-tunis.tn");
        u1.setNbEtudiants(15000);
        uniDao.ajouter(u1);
        System.out.println("Université ajoutée : " + u1.getNomUni());
        
        // Ajouter une autre université
        Universite u2 = new Universite();
        u2.setNomUni("Université de Sfax");
        u2.setAdresseUni("Sfax, Tunisie");
        u2.setEmail("contact@univ-sfax.tn");
        u2.setNbEtudiants(10000);
        uniDao.ajouter(u2);
        System.out.println("Université ajoutée : " + u2.getNomUni());

        // Lister toutes les universités
        System.out.println("Liste de toutes les universités :");
        for (Universite uni : uniDao.listerToutes()) {
            System.out.println(uni.getIdUni() + " - " + uni.getNomUni());
        }

        // Rechercher une université par nom
        System.out.println("Recherche des universités contenant 'Tunis' :");
        for (Universite uni : uniDao.listerParNom("Tunis")) {
            System.out.println(uni.getIdUni() + " - " + uni.getNomUni());
        }

        // Modifier une université
        u1.setNbEtudiants(16000);
        uniDao.modifier(u1);
        System.out.println("Université modifiée : " + u1.getNomUni() + " - Nombre d'étudiants : " + u1.getNbEtudiants());

        // Consulter une université par ID
        Universite consultedUni = uniDao.consulter(Universite.class, u1.getIdUni());
        if (consultedUni != null) {
            System.out.println("Université consultée : " + consultedUni.getNomUni());
        } else {
            System.out.println("Université non trouvée");
        }

        // Supprimer une université
        uniDao.supprimer(u2);
        System.out.println("Université supprimée : " + u2.getNomUni());

        // Lister les universités après suppression
        System.out.println("Liste après suppression :");
        for (Universite uni : uniDao.listerToutes()) {
            System.out.println(uni.getIdUni() + " - " + uni.getNomUni());
        }
    }
}
