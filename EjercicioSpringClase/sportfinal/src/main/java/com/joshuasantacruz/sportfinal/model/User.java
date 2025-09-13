package com.joshuasantacruz.sportfinal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.PartitionKey;

@Entity
@Table(name = "users")
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@NotBlank (message = "El nombre es un campo obligatorio")
@Column(name = "first_name")
private String firstName;

@NotBlank (message = "El apellido es un campo obligatorio")
@Column(name = "last_name")
private String lastName;

// VALIDACION DE EMAIL
@NotBlank(message = "El campo no debe estar vacio")
@Email(message = "EL correo no es valido")
// VALIDACION CON CAMPOS EN CORREO ELECTRONICO
@Pattern(regexp = "^[A-Za-z0-9._%-]+@(gmail\\.com|yahoo\\.com|kinal\\.edu.gt|kinal\\.org.gt|hotmail\\.com)$",
        message = "El campo de email no permite ese campo valido solamente permite: gmail, yahoo, edu, org, hotmail")
@Column(name = "email")
private String email;


// getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
