package com.example.simple_crm;

import java.util.List;

import jakarta.persistence.CascadeType;

// import java.util.UUID;

// import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customer")

public class Customer {
    // Instance Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank(message = "First name is mandatory")
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Email(message = "Email is not valid")
    @Column(name = "email")
    private String email;
    @Column(name = "contact_no")
    private String contactNo;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Interaction> interactions;

}
