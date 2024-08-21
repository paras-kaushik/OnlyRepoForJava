package com.investment.e_commerce.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity // Marks this class as a JPA entity, which will map to a database table.
public class User {

    @Id // Specifies the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.AUTO)
    // Specifies how the primary key should be generated.
    // AUTO means the persistence provider (e.g., Hibernate) will pick an appropriate strategy for the database.
    private Long id;

    private String firstName; // This will map to a column named 'first_name' in the database (default behavior).

    private String lastName; // This will map to a column named 'last_name' in the database (default behavior).

    private LocalDate dob; // This will map to a date column in the database.

    private String city; // This will map to a column named 'city' in the database.

    private String password; // This will map to a column named 'password' in the database.

    private String email; // This will map to a column named 'email' in the database.

    @Enumerated(EnumType.STRING)
    // Maps an enum to a database column as a string. This makes the values human-readable in the database.
    private UserRole role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    // Defines a one-to-many relationship with the 'UserOrder' entity.
    // 'mappedBy = "user"' indicates that the 'user' field in the 'UserOrder' entity owns the relationship.
    // 'cascade = CascadeType.ALL' means any operations (e.g., persist, remove) will also cascade to associated 'UserOrder' entities.
    // 'orphanRemoval = true' ensures that any 'UserOrder' entities no longer referenced by a 'User' are removed from the database.
    private List<UserOrder> userOrders = new ArrayList<>();

    @ElementCollection
    // Indicates that this field is a collection of basic types or embeddable objects.
    // In this case, it's a collection of Strings representing the user's interests.
    private List<String> interests = new ArrayList<>();

    @ElementCollection
    @MapKeyColumn(name = "address_type")
    // Specifies the column name for the map's keys in the collection table.
    @Column(name = "address")
    // Specifies the column name for the map's values in the collection table.
    private Map<String, String> addresses = new HashMap<>();
    public User(){}
    public User(String firstName, String lastName, LocalDate dob, String city, String password, String email, UserRole role, List<UserOrder> userOrders, List<String> interests, Map<String, String> addresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.city = city;
        this.password = password;
        this.email = email;
        this.role = role;
        this.userOrders = userOrders;
        this.interests = interests;
        this.addresses = addresses;
    }

    // Getters and setters for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public List<UserOrder> getOrders() {
        return userOrders;
    }

    public void setOrders(List<UserOrder> userOrders) {
        this.userOrders = userOrders;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public Map<String, String> getAddresses() {
        return addresses;
    }

    public void setAddresses(Map<String, String> addresses) {
        this.addresses = addresses;
    }
}
