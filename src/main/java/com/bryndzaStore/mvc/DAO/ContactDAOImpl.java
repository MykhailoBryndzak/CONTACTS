package com.bryndzaStore.mvc.DAO;

import com.bryndzaStore.mvc.domain.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactDAOImpl implements ContactDAO {

    private SessionFactory sesionFactory;

    @Override
    @Autowired//Аннотация позволяет автоматически установить значение поля SessionFactory.
    public void addContact(Contact contact) {
        sesionFactory.getCurrentSession().save(contact);
    }

    @Override
    @SuppressWarnings("uncheked")
    public List listContact() {
        return sesionFactory.getCurrentSession().createQuery("from Contact").list();
    }

    @Override
    public void removeContact(Integer id) {
        Contact contact = (Contact) sesionFactory.getCurrentSession().load(Contact.class, id);
            if(null != contact){
                sesionFactory.getCurrentSession().delete(contact);
            }

    }
}
