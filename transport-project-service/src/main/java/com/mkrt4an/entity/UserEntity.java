package com.mkrt4an.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 123 on 28.09.2016.
 */
@Entity
@Table(name = "user", schema = "transportProject")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @OneToOne
    @JoinColumn(name = "passport_id")
    private PassportEntity passport;


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

    public PassportEntity getPassport() {
        return passport;
    }
    public void setPassport(PassportEntity passport) {
        this.passport = passport;
    }


    //Constructors
    public UserEntity(){}

    public UserEntity(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public UserEntity(String name){
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name=" + name +
                ", passport=" + (passport == null ? "NULL" : passport.getId()) +
                '}' + '\n';
    }
}
