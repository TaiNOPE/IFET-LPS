package com.mycompany.lps_semana10;

import javax.persistence.*;

@Entity
class Wheel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String radius;
    private String material;
    private String weight;
    private String maxSupport;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="car_id")
    private Car car;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the radius
     */
    public String getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(String radius) {
        this.radius = radius;
    }

    /**
     * @return the material
     */
    public String getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * @return the weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * @return the maxSupport
     */
    public String getMaxSupport() {
        return maxSupport;
    }

    /**
     * @param maxSupport the maxSupport to set
     */
    public void setMaxSupport(String maxSupport) {
        this.maxSupport = maxSupport;
    }

    /**
     * @param car the car to set
     */
    public void setCar(Car car) {
        this.car = car;
    }
}
