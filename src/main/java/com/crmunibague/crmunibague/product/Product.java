package com.crmunibague.crmunibague.product;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer code;

    private String name;

    public Product() {
    }

    public Product(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
