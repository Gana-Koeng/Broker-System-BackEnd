package csx.broker.Service;


import csx.broker.Entity.Contacts;
import csx.broker.Repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.lang.constant.Constable;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    private ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

//    public Iterable<Brokers> getAll() {
//        return brokersRepository.findAll();
//    }

//    public List<String> getAllBrokerId() {
//        return brokerRepository.getAllBrokerId();
//    }
    public void save(Contacts contacts){
        contactRepository.save(contacts);
    }

//    public void delete(int OrderNo ){
//        brokersRepository.deleteById(OrderNo);
//    }


    public Iterable<Contacts> getAlldata() {
        return contactRepository.findAll();
    }
}
