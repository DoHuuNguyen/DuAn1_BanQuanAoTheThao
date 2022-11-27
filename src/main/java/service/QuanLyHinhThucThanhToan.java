/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.HinhThucThanhToan;
/**
 *
 * @author duong
 */
public interface QuanLyHinhThucThanhToan {
    ArrayList<HinhThucThanhToan> getlist();
    void insert(HinhThucThanhToan Httt);
    void update(HinhThucThanhToan Httt, Integer id);
    void delete(Integer id);
    ArrayList<String> selectma();
}
