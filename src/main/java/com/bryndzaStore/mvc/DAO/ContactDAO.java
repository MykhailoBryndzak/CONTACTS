package com.bryndzaStore.mvc.DAO;

import com.bryndzaStore.mvc.domain.Contact;

import java.util.List;

public interface ContactDAO {

    public void addContact(Contact contact);

    public List listContact();

    public void removeContact(Integer id);
}
