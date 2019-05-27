public class Record {
    protected int uid;
    protected String name;
    protected String address;
    protected int contact;
    protected String organisation;
}

public Record() {

}

public Record(int uid) {
    this.uid = uid;
}

public Record(int uid, String name, String address, int contact, String organisation) {
    this(name, address, contact, organisation)
    this.uid = uid;
}

public Record() {
    this.name = name;
    this.address = address;
    this.contact = contact;
    this.location = location;
}

public int getId() {
    return uid;
}

public void setId() {
    this.uid = uid;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}

public int getContact() {
    return contact;
}

public void setContact(int quantity) {
    this.contact = contact;
}

public String getOrganisation() {
    return organisation;
}

public void setOrganisation(String organisation) {
    this.organisation = organisation;
}