package service;

import java.util.ArrayList;
import model.Size;

public interface QuanLySize {
    public ArrayList<Size> getList();
    public void insert(Size size);
    public void update(Integer id, Size size);
    public void delete(Integer id);
    boolean checkMa(Size size);
}
