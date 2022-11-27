/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reopsitory;

import hibernateConfig.HibernateConfig;
import java.util.List;
import javax.persistence.Query;
import model.Account;
import org.hibernate.Session;

/**
 *
 * @author vuong
 */
public class AccountRepository {

    private Session session;

    public AccountRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public void insert(Account acc) {
        session.beginTransaction();
        session.save(acc);
        session.getTransaction().commit();
    }

    public void update(String userName, String pass) {
        session.beginTransaction();
        String query = "update Account set passWord =:passWord where userName =:userName";
        Query q = session.createQuery(query);
        q.setParameter("passWord", pass);
        q.setParameter("userName", userName);
        q.executeUpdate();
        session.getTransaction().commit();
    }

    public void delete(String email) {
        session.beginTransaction();
        String query = "update Account set trangThai =:trangThai where email =:email";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 0);
        q.setParameter("email", email);
        q.executeUpdate();
        session.getTransaction().commit();
    }

    public Account search(String user, String pass) {
        String query = "from Account where userName =:userName and passWord =:passWord";
        Query q = session.createQuery(query);
        q.setParameter("userName", user);
        q.setParameter("passWord", pass);
        List<Account> list = q.getResultList();
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
