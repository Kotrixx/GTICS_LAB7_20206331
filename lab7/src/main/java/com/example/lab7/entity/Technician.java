package com.example.lab7.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "technician", schema = "gticslab6")
public class Technician {
    @Id
    @Column(name = "TechnicianID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min=3,max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Pattern(regexp="^[a-zA-Z]+$",message="Su nombre de debe contener nombres ni digitos")
    @Column(name = "FirstName", nullable = false, length = 100)
    private String firstName;

    @Size(max = 100)
    @NotBlank
    @Pattern(regexp="^[a-zA-Z]+$",message="Su nombre de debe contener nombres ni digitos")
    @Size(min=3,max = 100, message = "El apellido debe tener entre 3 y 100 caracteres")
    @Column(name = "LastName", nullable = false, length = 100)
    private String lastName;

    @NotBlank(message = "No puede dejar vacio este item")
    @Max(value = 99999999, message = "DNI incorrecto (8 digitos)")
    @Min(value = 10000000, message = "DNI incorrecto (8 digitos)")
    @Column(name = "Dni", nullable = false, length = 8)
    private String dni;

    @Size(max = 9)
    @NotBlank(message = "No puede dejar vacio este item")
    @Max(value = 99999999, message = "9 digitos")
    @Min(value = 10000000, message = "9 digitos")
    @Column(name = "Phone", nullable = false, length = 9)
    private String phone;

    @NotNull(message = "No puede dejar vacio este item")
    @Positive(message = "Debe ingresar un numero postiivo")
    @Digits(integer = 3, fraction = 0, message = "Solo se admite edades menores a 100")
    @Column(name = "Age", nullable = false)
    private Integer age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}