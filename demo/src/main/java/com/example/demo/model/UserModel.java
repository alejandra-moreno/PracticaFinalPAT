package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("USER")
public class UserModel {
    private @Column("USER_ID") @Id String userId;
	private @Column("USERS_NAME") String usersName;
	private @Column("USERS_PASSWORD") String usersPassword;
	private @Column("EMAIL") String userEmail;
	private @Column("AGE") int userAge;

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
