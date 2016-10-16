package com.mkrt4an.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 123 on 02.10.2016.
 */

@Entity
@Table(name = "city", schema = "transportProject")
public class CityEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 11)
    private String name;

    @Column(name = "x", nullable = false, length = 11)
    private Integer x;

    @Column(name = "y", nullable = false, length = 11)
    private Integer y;

    @OneToOne
//            (name = "routepoint_id")
    private RoutePointEntity routepoint;

    public CityEntity(){}

    public CityEntity(String name, Integer x, Integer y) {
        this.name = name;
        this.x = x;
        this.y = y;
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

    public Integer getX() {
        return x;
    }
    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }
    public void setY(Integer y) {
        this.y = y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityEntity city = (CityEntity) o;

        if (id != null ? !id.equals(city.id) : city.id != null) return false;
        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        if (x != null ? !x.equals(city.x) : city.x != null) return false;
        return y != null ? y.equals(city.y) : city.y == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (x != null ? x.hashCode() : 0);
        result = 31 * result + (y != null ? y.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name=" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}' + "\n";
    }
}