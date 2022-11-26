/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    @Column(name = "UserName")
    private String userName;
    
    @Column(name = "Pass")
    private String passWord;
    
    @OneToOne
    @JoinColumn(name = "idNguoiDung")
    private NguoiDung idNguoiDung;
    
    @Column(name = "TrangThai")
    private int trangThai;

    public Account() {
    }

    public Account(Integer id, String userName, String passWord, NguoiDung idNguoiDung, int trangThai) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.idNguoiDung = idNguoiDung;
        this.trangThai = trangThai;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public NguoiDung getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(NguoiDung idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    @Override
    public String toString() {
        return userName;
    }
}