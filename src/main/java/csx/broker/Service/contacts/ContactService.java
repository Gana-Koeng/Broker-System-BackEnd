package csx.broker.Service.contacts;


import csx.broker.Entity.contacts.Contacts;
import csx.broker.Repository.contacts.ContactRepository;
import org.springframework.stereotype.Service;

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
