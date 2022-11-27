/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import model.Account;

/**
 *
 * @author vuong
 */
public interface QuanLyAccountServices {

    boolean checkPass(Account acc);

    void insert(Account acc);

    boolean update(String user, String pass);

    void delete(String email);

    Account search(String user, String pass);
}
