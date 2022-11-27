/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.ServiceImpl;

import reopsitory.EmailRepository;
import service.QuanLyGuiEmailServices;

/**
 *
 * @author vuong
 */
public class EmailServicesImpl implements QuanLyGuiEmailServices {

    private EmailRepository EmailR = new EmailRepository();

    @Override
    public String sendEmail(String email) {
        return EmailR.sendEmail(email);
    }

}
