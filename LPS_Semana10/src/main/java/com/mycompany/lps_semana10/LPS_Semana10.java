/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lps_semana10;

import javax.persistence.*;


public class LPS_Semana10 {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("LPS_Sem10");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        
        
        // Cria proprietario do carro
        CarOwner co = new CarOwner();
        co.setName("Fulano de Tal");
        co.setCpf("123.456.789-10");
        co.setEmail("exemplo@email.com");

        // Adiciona carros
        int carCount = 4;
        for(int c = 0; c < carCount; c++){
            System.out.println(c);
            Car car = new Car();
            car.setOwner(co);
            car.setColor("Cor " + c);
            car.setManufacturer("Fabricante " + c);
            car.setModel("Modelo " + c);
            
            manager.persist(car);
            
            // Cria rodas do carro
            for(int w = 0; w < 4; w++){
                Wheel wh = new Wheel();
                wh.setCar(car);
                wh.setMaterial("Material " + w);
                wh.setMaxSupport(Float.toString(13.5f * w));
                wh.setRadius(Float.toString(3.4f * w));
                wh.setWeight(Float.toString(5.2f * w));

                manager.persist(wh);
            }            
        }
        manager.getTransaction().commit();
        manager.close();
        
        // Demonstracao Eager e Lazy
        manager = factory.createEntityManager();
        
        System.out.println("\n\n\nConsulta no Banco de Dados:");
        System.out.println("Dono do carro com ID 1:");
        CarOwner cown = manager.find(CarOwner.class, 1);
        System.out.println("Nome: " + cown.getName());
        
        // Eager
        System.out.println("\nCarro 1:");
        System.out.println(cown.getCars().get(0).getModel());
        
        // Lazy
        System.out.println("Material da roda 1 do carro 1:");
        System.out.println(cown.getCars().get(0).getWheels().get(0).getMaterial());
        
        // Cache
        System.out.println("[Cache] - Cor do carro 1");
        System.out.println(cown.getCars().get(0).getColor());
        manager.close();
        
        factory.close();
    }
}
