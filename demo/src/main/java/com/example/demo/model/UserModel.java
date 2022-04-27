package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;



@Data
@Builder
@Table("USER")
public class UserModel {
    @Id
    private int ID;
    private String userId;
	private String usersName;
	private String usersPassword;
	private String userEmail;
	private int userAge;

    public int getId() {
        return this.ID;
    }

	public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

	public String getPassword() {
        return this.usersPassword;
    }

    public void setPassword(String usersPassword) {
        this.usersPassword = usersPassword;
    }

	public String getUserName() {
        return this.usersName;
    }

    public void setUserName(String usersName) {
        this.usersName = usersName;
    }

    public String getCorreo() {
        return this.userEmail;
    }

    public void setCorreo(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getEdad() {
        return this.userAge;
    }

    public void setEdad(int userAge) {
        this.userAge = userAge;
    }
}
