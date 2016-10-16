package com.mkrt4an.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by 123 on 02.10.2016.
 */

@Entity
@Table(name = "orders", schema = "transportproject")
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "uid", nullable = true)
    private Integer uid;

    @Column(name = "status", nullable = true)
    private Integer status;

    @OneToMany (mappedBy = "order")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<RoutePointEntity> routePointList;

    @OneToMany (mappedBy = "order")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<DriverEntity> driverList;

    @OneToOne (mappedBy = "orders")
    @LazyCollection(LazyCollectionOption.FALSE)
    private TruckEntity currentTruck;

    public OrderEntity(){}

    public OrderEntity(Integer uid, Integer status, List<RoutePointEntity> routePointList,
                                List<DriverEntity> driverList, TruckEntity currentTruck) {
        this.uid = uid;
        this.status = status;
        this.routePointList = routePointList;
        this.driverList = driverList;
        this.currentTruck = currentTruck;
    }

    public OrderEntity(Integer uid, Integer status, TruckEntity currentTruck) {
        this.uid = uid;
        this.status = status;
        this.currentTruck = currentTruck;
    }

    public OrderEntity(Integer uid, Integer status, TruckEntity currentTruck, List<DriverEntity> driverList) {
        this.uid = uid;
        this.status = status;
        this.currentTruck = currentTruck;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setCurrentTruck(TruckEntity currentTruck) {
        this.currentTruck = currentTruck;
    }
    public TruckEntity getCurrentTruck() {
        return currentTruck;
    }

    public List<RoutePointEntity> getRoutePointList() {
        return routePointList;
    }
    public void setRoutePointList(List<RoutePointEntity> routePointList) {
        this.routePointList = routePointList;
    }

    public List<DriverEntity> getDriverList() {
        return driverList;
    }
    public void setDriverList(List<DriverEntity> driverList) {
        this.driverList = driverList;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", uid=" + uid +
                ", status=" + status +
//                ", routePointList=" + routePointList +
                ", driverList=" + driverList +
//                ", currentTruck=" + currentTruck.getRegNumber() +
                ", currentTruck=" + (currentTruck == null ? "NULL" : currentTruck.getId()) +
                '}' + "\n";
    }
}
