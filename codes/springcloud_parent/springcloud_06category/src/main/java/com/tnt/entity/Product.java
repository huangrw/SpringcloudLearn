package com.tnt.entity;

import java.util.Date;

/**
 * @author huangrw
 * @program: codes
 * @Description
 * @createTime 2022年01月20日 10:07:00
 */
public class Product {
    private Integer id;
    private String name;
    private Double price;
    private Date bir;

    public Product(Integer id, String name, Double price, Date bir) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.bir = bir;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", bir=" + bir +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Date getBir() {
        return bir;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }
}
