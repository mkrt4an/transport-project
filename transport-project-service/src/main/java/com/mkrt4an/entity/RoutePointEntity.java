package com.mkrt4an.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 123 on 02.10.2016.
 */

@Entity
@Table(name = "routepoint", schema = "transportproject")
public class RoutePointEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "type", nullable = false)
    private Integer type;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private CargoEntity cargo;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private OrderEntity order;


    public RoutePointEntity(){}

    public RoutePointEntity(CityEntity city, CargoEntity cargo, Integer type) {
        this.type = type;
        this.city = city;
        this.cargo = cargo;
    }

    public RoutePointEntity(Integer type, CityEntity city, CargoEntity cargo, OrderEntity order) {
        this.type = type;
        this.city = city;
        this.cargo = cargo;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }

    public CityEntity getCity() {
        return city;
    }
    public void setCity(CityEntity city) {
        this.city = city;
    }

    public CargoEntity getCargo() {
        return cargo;
    }
    public void setCargo(CargoEntity cargo) {
        this.cargo = cargo;
    }

    public OrderEntity getOrder() {
        return order;
    }
    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoutePointEntity that = (RoutePointEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RoutePointEntity{" +
                "id=" + id +
                ", type=" + type + '\'' +
                ", city=" + city +
                ", cargo=" + cargo +
                '}' + "\n";
    }
}
