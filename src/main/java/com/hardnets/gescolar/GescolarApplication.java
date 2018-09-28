package com.hardnets.gescolar;

import com.hardnets.gescolar.entity.UsuariosEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class GescolarApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(GescolarApplication.class, args);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("gescolar");
            EntityManager em = emf.createEntityManager();

            //Select person   id is 3
            UsuariosEntity usuariosEntity = (UsuariosEntity) em.find(UsuariosEntity.class, "14081226-9");
            System.out.println(String.format("Firstname Lastname: %s, DateOfBirth: %s", usuariosEntity.getUsurNombre(), usuariosEntity.getUsurMail()));
            EntityTransaction tx = em.getTransaction();

        /*//update his date of birth
        Calendar cal = Calendar.getInstance();
        cal.set(1970, 1, 1);
        Date date = cal.getTime();

        tx.begin();
        usuariosEntity.setDob(date);
        tx.commit();*/

        } catch (Exception e) {
            e.printStackTrace();
        }




        /*// Create a variable for the connection string.
        List<String> strConn = Arrays.asList(
                "jdbc:sqlserver://216.155.90.149:1433;databaseName=qa_BDGestion;user=sa;password=Kumple22*zu+",
                "jdbc:sqlserver://LAPTOP-9T8FEB81\\MSSQLSERVER01;databaseName=kimeltu;integratedSecurity=true"
        );
        try {
            // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(strConn.get(0))) {
                System.out.println("Done.");
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }*/

    }
}
