package com.mkrt4an.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 123 on 28.09.2016.
 */
@Entity
@Table(name = "passport", schema = "transportProject")
public class PassportEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "serial", nullable = false, length = 20)
    private Integer serial;

    @OneToOne (mappedBy = "passport")
//    @LazyCollection(LazyCollectionOption.FALSE)
    private UserEntity user;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSerial() {
        return serial;
    }
    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }

    //Constructors
    public PassportEntity(){}

    public PassportEntity(Integer id, Integer serial){
        this.id = id;
        this.serial = serial;
    }

    public PassportEntity(Integer serial){
        this.serial = serial;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassportEntity that = (PassportEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (serial != null ? !serial.equals(that.serial) : that.serial != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (serial != null ? serial.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PassportEntity{" +
                "id=" + id +
                ", serial=" + serial +
                ", user=" + (user == null ? "NULL" :  user.getId())+
                '}' + '\n';
    }
}
