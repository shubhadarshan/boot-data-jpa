package in.spdev.akit.boot.persistence.springbootdatajpaakit.service;

import in.spdev.akit.boot.persistence.springbootdatajpaakit.entities.ContactsMasterEntity;
import in.spdev.akit.boot.persistence.springbootdatajpaakit.repositories.ContactsMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContactsMasterService {

    private ContactsMasterRepo contactsMasterRepo;

    @Autowired
    public void setContactsMasterRepo(ContactsMasterRepo contactsMasterRepo) {
        this.contactsMasterRepo = contactsMasterRepo;
    }

    @Transactional(readOnly = false)
    public int saveAContact(ContactsMasterEntity contact) {
        ContactsMasterEntity save = contactsMasterRepo.save(contact);
        return save.getContactId();
    }

    @Transactional(readOnly = true)
    public Optional<ContactsMasterEntity> findARecord(int id) {
        return contactsMasterRepo.findById(id);
    }

    @Transactional(readOnly = false)
    public void saveContactList(List<ContactsMasterEntity> contactsMasterEntityList) {
        Iterable<ContactsMasterEntity> contactsMasterEntities = contactsMasterRepo.saveAll(contactsMasterEntityList);
        contactsMasterEntities.forEach(System.out::println);
    }

    @Transactional(readOnly = true)
    public ContactsMasterEntity findAContact(Integer id) {
        return contactsMasterRepo.findById(id).get();
    }

    @Transactional(readOnly = true)
    public boolean isExist(Integer id) {
        return contactsMasterRepo.existsById(id);
    }

    @Transactional(readOnly = true)
    public List<ContactsMasterEntity> findAllContact() {
        return (List<ContactsMasterEntity>) contactsMasterRepo.findAll();
    }

    @Transactional(readOnly = true)
    public List<ContactsMasterEntity> findAllById(List<Integer> idList) {
        return (List<ContactsMasterEntity>) contactsMasterRepo.findAllById(idList);
    }

    @Transactional(readOnly = true)
    public Integer countContact() {
        return Math.toIntExact(contactsMasterRepo.count());
    }

    @Transactional(readOnly = false)
    public void deleteAContact(Integer id) {
        contactsMasterRepo.deleteById(id);
    }

    @Transactional
    public void deleteContact(ContactsMasterEntity contactsMasterEntity) {
        contactsMasterRepo.delete(contactsMasterEntity);
    }

    @Transactional
    public void deleteAllContacts(List<Integer> ids) {
        contactsMasterRepo.deleteAllById(ids);
    }

    @Transactional
    public void deleteAllContacts() {
        contactsMasterRepo.deleteAll();
    }
}
