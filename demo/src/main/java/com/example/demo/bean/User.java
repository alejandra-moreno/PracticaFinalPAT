package com.example.demo.bean;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotNull
    @Size(min=2, max=30)
    private String nombre;
    @NotNull
    @Size(min=2, max=30)
    private String apellido;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String cumpleaños;
    @NotNull
    @Max(value=9)
    @Min(value=9)
    private String dni;
    @Digits(fraction = 0, integer = 10)
    private Integer edad;
    @NotNull
    @Size(min=2, max=30)
    private String contraseña;
    @NotNull
    @Size(min=2, max=30)
    private String contraseña2;

    public User(String nombre, String apellido, String email, String cumpleaños, String dni, Integer edad, String contraseña, String contraseña2) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.cumpleaños = cumpleaños;
        this.dni = dni;
        this.edad = edad;
        this.contraseña = contraseña;
        this.contraseña2 = contraseña2;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCumpleaños() {
        return this.cumpleaños;
    }

    public void setCumpleaños(String cumpleaños) {
        this.cumpleaños = cumpleaños;
    }

    public String getdni() {
        return this.dni;
    }

    public void setdni(String dni) {
        this.dni = dni;
    }

    public Integer getEdad() {
        return this.edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setgetContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getgetContraseña2() {
        return this.contraseña2;
    }

    public void setgetContraseña2(String contraseña2) {
        this.contraseña2 = contraseña2;
    }

    

    @Override
    public String toString() {
        return "{" +
            " Nombre: '" + getNombre() + "'" +
            ", Apellido(s): '" + getApellido() + "'" +
            ", Email: '" + getEmail() + "'" +
            "; dni: '" + getdni() + "'" +
            "; Cumpleaños: '" + getCumpleaños() + "'" +
            ", Edad: '" + getEdad() + "'" +
            "}";
    }


}