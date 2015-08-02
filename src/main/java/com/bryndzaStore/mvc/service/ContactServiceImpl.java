package com.bryndzaStore.mvc.service;

import com.bryndzaStore.mvc.DAO.ContactDAO;
import com.bryndzaStore.mvc.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service//-- используем данную аннотацию, чтобы объявить, что этот класс представляет сервис – компонент сервис-слоя.
// Сервис является подтипом класса @Component. Использование данной аннотации позволит искать бины-сервисы автоматически
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactDAO contactDAO;

    @Override
    @Transactional//Перед исполнением метода помеченного данной аннотацией начинается транзакция,
    // после выполнения метода транзакция коммитится, при выбрасывании RuntimeException откатывается.
    public void addContact(Contact contact) {
        contactDAO.addContact(contact);

    }

    @Override
    @Transactional
    public List<Contact> listContact() {
        return contactDAO.listContact();
    }

    @Override
    @Transactional
    public void removeContact(Integer id) {
        contactDAO.removeContact(id);
    }
}
