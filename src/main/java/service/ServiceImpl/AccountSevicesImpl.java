/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.ServiceImpl;

import model.Account;
import reopsitory.AccountRepository;
import service.QuanLyAccountServices;

/**
 *
 * @author vuong
 */
public class AccountSevicesImpl implements QuanLyAccountServices {

    private AccountRepository AccountR = new AccountRepository();
    private static String pass = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    @Override
    public boolean checkPass(Account acc) {
        if (acc.getPassWord().matches(pass)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void insert(Account acc) {
        AccountR.insert(acc);
    }

    @Override
    public boolean update(String user, String pass) {
        if (pass.matches(pass)) {
            AccountR.update(user, pass);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void delete(String email) {
        AccountR.delete(email);
    }

    @Override
    public Account search(String user, String pass) {
        return AccountR.search(user, pass);
    }

}
