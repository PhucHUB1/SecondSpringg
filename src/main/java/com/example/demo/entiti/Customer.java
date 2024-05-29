package com.example.demo.entiti;

import jakarta.persistence.*;

import javax.naming.Name;
import java.util.HashSet;
import java.util.Set;

@Entity(name="Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long    id;
    private String name;
    private String email;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "customer_order",
            joinColumns = @JoinColumn(name = "customers_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )

    private Set<Order> orders = new HashSet<Order>();

    public Customer() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer(long id, String name,  String email) {
        this.id = id;
        this.name = name;

        this.email = email;
    }


}
