/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.NguoiDung;

/**
 *
 * @author thean
 */
public interface QuanLyNguoiDung {
    ArrayList<NguoiDung> getList();
    void insert(NguoiDung nd);
    void update(NguoiDung nd, Integer id);
    void delete(Integer id);
    ArrayList<String> selectma();
    NguoiDung email(String email);
}
