package com.mkrt4an.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 123 on 02.10.2016.
 */
@Entity
@Table(name = "cargo", schema = "transportProject")
public class CargoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "weight", nullable = false)
    private Integer weight;

    @Column(name = "status", nullable = false)
    private Integer status;

    @OneToOne
    private RoutePointEntity routePoint;

    public CargoEntity(){
    }

    public CargoEntity(String name, Integer weight, Integer status){
        this.name = name;
        this.weight = weight;
        this.status = status;
//        this.routePoint = routePoint;
    }

    public CargoEntity(Integer id, String name, Integer weight, Integer status){
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.status = status;
//        this.routePoint = routePoint;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setRoutinPoint(RoutePointEntity routinPoint) {
        this.routePoint = routinPoint;
    }
    public RoutePointEntity getRoutinPoint() {

        return routePoint;
    }

    //Constructors
//    CargoEntity(){
//
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CargoEntity that = (CargoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CargoEntity{" +
                "id=" + id +
                ", name=" + name + '\'' +
                ", weight=" + weight +
                ", status=" + status +
                '}' + "\n";
    }
}
