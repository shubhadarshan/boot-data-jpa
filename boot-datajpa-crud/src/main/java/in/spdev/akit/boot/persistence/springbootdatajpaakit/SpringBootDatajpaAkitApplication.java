package in.spdev.akit.boot.persistence.springbootdatajpaakit;

import in.spdev.akit.boot.persistence.springbootdatajpaakit.entities.ContactsMasterEntity;
import in.spdev.akit.boot.persistence.springbootdatajpaakit.repositories.ContactsMasterRepo;
import in.spdev.akit.boot.persistence.springbootdatajpaakit.service.ContactsMasterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootDatajpaAkitApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootDatajpaAkitApplication.class, args);

        ContactsMasterRepo contactsMasterRepo = applicationContext.getBean(ContactsMasterRepo.class);
        ContactsMasterService contactsMasterService = applicationContext.getBean(ContactsMasterService.class);
        System.out.println(contactsMasterRepo.getClass());

        ContactsMasterEntity contactsMasterEntity = new ContactsMasterEntity();
        contactsMasterEntity.setContactId(1);
        contactsMasterEntity.setContact_number(4545453);
        contactsMasterEntity.setContactName("bhubaneswar");
        int contactSavedId = contactsMasterService.saveAContact(contactsMasterEntity);
        System.out.println("1st contact saved " + contactSavedId);

        ContactsMasterEntity contactsMasterEntity2 = new ContactsMasterEntity();
        contactsMasterEntity2.setContactId(2);
        contactsMasterEntity2.setContact_number(3345453);
        contactsMasterEntity2.setContactName("cuttack");
        int contactSavedId2 = contactsMasterService.saveAContact(contactsMasterEntity2);
        System.out.println("2nd contact saved " + contactSavedId2);

        //find a record

        /*Optional<ContactsMasterEntity> aRecord = contactsMasterService.findARecord(4);
        if (aRecord.isPresent()) {
            System.out.println(aRecord.get());
        } else {
            System.out.println("No round found");
        }*/

        /*
         * working with repository directly
         * */
        System.out.println("FINDING CONTACTS");
        ContactsMasterRepo repo = applicationContext.getBean(ContactsMasterRepo.class);
        //find all by ID
        Iterable<ContactsMasterEntity> allById = repo.findAllById(Arrays.asList(1,2));
        allById.forEach(System.out::println);

    }

}
