package service.ServiceImpl;

import java.util.ArrayList;
import model.MonTheThao;
import reopsitory.MonTheThaoRepository;
import service.QuanLyMonTheThao;

public class MonTheThaoServiceImpl implements QuanLyMonTheThao{
    private MonTheThaoRepository mttR;
    
    public MonTheThaoServiceImpl(){
        this.mttR = new MonTheThaoRepository();
    }

    @Override
    public ArrayList<MonTheThao> getList() {
        return this.mttR.getList();
    }

    @Override
    public void insert(MonTheThao mtt) {
        this.mttR.insert(mtt);
    }

    @Override
    public void update(MonTheThao mtt, Integer id) {
        this.mttR.update(id, mtt);
    }

    @Override
    public void delete(Integer id) {
        this.mttR.delete(id);
    }

    @Override
    public ArrayList<String> selectma() {
        return this.mttR.selectMa();
    }
}
