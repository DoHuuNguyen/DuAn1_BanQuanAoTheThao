package service;

import java.util.ArrayList;
import model.MonTheThao;

public interface QuanLyMonTheThao {
    ArrayList<MonTheThao> getList();
    void insert(MonTheThao mtt);
    void update(MonTheThao mtt, Integer id);
    void delete(Integer id);
    ArrayList<String> selectma();
}
