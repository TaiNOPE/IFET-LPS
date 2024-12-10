package com.mycompany.lps_semana10;

import java.util.List;
import javax.persistence.*;


@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String manufacturer;
    private String model;
    private String color;
    
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Wheel> wheels;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CarOwner owner;
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * @param manufacturer the manufacturer to set
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the wheels
     */
    public List<Wheel> getWheels() {
        return wheels;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(CarOwner owner) {
        this.owner = owner;
    }


}
