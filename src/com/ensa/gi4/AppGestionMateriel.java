package com.ensa.gi4;

import com.ensa.gi4.bootstrap.DataBootsrapper;
import com.ensa.gi4.controller.GestionMaterielController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


@SuppressWarnings("all")
@ComponentScan(basePackages = "com.ensa.gi4")
@PropertySource("classpath:application.properties")
public class AppGestionMateriel {
    private static ApplicationContext APPLICATION_CONTEXT;


    static { // bloc static pour initilialisation
        //APPLICATION_CONTEXT = new ClassPathXmlApplicationContext("/beans/app-context.xml");
        APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(AppGestionMateriel.class);
    }



    public static void main(String[] args) {
        final GestionMaterielController gestionMaterielController = APPLICATION_CONTEXT.getBean(GestionMaterielController.class);
        final DataBootsrapper dataBootsrapper = APPLICATION_CONTEXT.getBean(DataBootsrapper.class);
        dataBootsrapper.initTables();
        while (true) { // pour que l'appliation tourne jusqu'à la demande de l'utilisateur de l'arrêter
            gestionMaterielController.afficherMenu();
            System.out.println("\n");
        }

    }


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
