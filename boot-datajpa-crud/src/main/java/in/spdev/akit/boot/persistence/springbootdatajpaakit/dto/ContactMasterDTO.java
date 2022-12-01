package in.spdev.akit.boot.persistence.springbootdatajpaakit.dto;

public class ContactMasterDTO {
    private int contactId;
    private String contactName;
    private long contact_number;

    public ContactMasterDTO(int contactId, String contactName, long contact_number) {
        this.contactId = contactId;
        this.contactName = contactName;
        this.contact_number = contact_number;
    }
}
