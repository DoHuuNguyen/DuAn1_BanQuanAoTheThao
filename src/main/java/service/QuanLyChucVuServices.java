/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.ChucVu;

/**
 *
 * @author vuong
 */
public interface QuanLyChucVuServices {

    ArrayList<ChucVu> getList();

    void insert(ChucVu cv);

    void update(ChucVu cv, Integer id);

    void delete(Integer id);

    ArrayList<String> selectMa();
}
