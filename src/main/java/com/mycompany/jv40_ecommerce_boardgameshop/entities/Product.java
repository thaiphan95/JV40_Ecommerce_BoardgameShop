/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv40_ecommerce_boardgameshop.entities;

import com.mycompany.jv40_ecommerce_boardgameshop.enums.ProductStatus;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author Admin
 */
@Entity
@Table
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    
    @Column(length = 100)
    private String name;
    
    private double price;
    
    private int quantity;
    
    @Column(name = "total_player", length = 2)
    private String totalPlayer;
    
    @Column(length = 2)
    private String age;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    
    @ManyToOne
    @JoinColumn(name = "publisher_id") 
    private Publisher publisherId;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "productId")
    private Set<Image> image;
    
    @ManyToOne
    @JoinColumn(name = "product_id" )
    private Category categoryId;
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "productId")
    private List<CartDetail> cartDetail;
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "productId")
    private List<Comment> comment;
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "productId")
    private List<Vote> vote;
    
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "product_promotion",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "promotion_id")} )
    private Set<Promotion> promotion;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTotalPlayer() {
        return totalPlayer;
    }

    public void setTotalPlayer(String totalPlayer) {
        this.totalPlayer = totalPlayer;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public Publisher getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publisher publisherId) {
        this.publisherId = publisherId;
    }

    public Set<Image> getImage() {
        return image;
    }

    public void setImage(Set<Image> image) {
        this.image = image;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public List<CartDetail> getCartDetail() {
        return cartDetail;
    }

    public void setCartDetail(List<CartDetail> cartDetail) {
        this.cartDetail = cartDetail;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public List<Vote> getVote() {
        return vote;
    }

    public void setVote(List<Vote> vote) {
        this.vote = vote;
    }

    public Set<Promotion> getPromotion() {
        return promotion;
    }

    public void setPromotion(Set<Promotion> promotion) {
        this.promotion = promotion;
    }
    
    
}
