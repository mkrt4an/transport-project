package com.mkrt4an.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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

    @OneToOne (mappedBy = "routepoint")
    private CityEntity city;

    @OneToOne (mappedBy = "routePoint")
    @LazyCollection(LazyCollectionOption.FALSE)
    private CargoEntity cargo;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private OrderEntity order;


    public RoutePointEntity(){}

    public RoutePointEntity(Integer type, CityEntity city, CargoEntity cargo, OrderEntity order) {
        this.type = type;
        this.city = city;
        this.cargo = cargo;
        this.order = order;
    }

    public Integer getOrder() {
        return id;
    }
    public void setOrder(Integer order) {
        this.id = order;
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
