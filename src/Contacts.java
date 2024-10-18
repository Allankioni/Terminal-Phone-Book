import java.util.ArrayList;

public class Contacts {
    private String Name;
    private String PhoneNumber;
    private String Email;
    private ArrayList<Message> messages;

    public Contacts(String name, String phoneNumber, String email, ArrayList<Message> messages) {
        Name = name;
        PhoneNumber = phoneNumber;
        Email = email;
        this.messages = messages;
    }

    public Contacts(String name, String phoneNumber, String email) {
        Name = name;
        PhoneNumber = phoneNumber;
        Email = email;
        this.messages = new ArrayList<Message>();

    }
    public void getDetails(){
        System.out.println("Name: " + this.Name+"\nPhone Number: "+ this.PhoneNumber+
                "\nEmail: "+ this.Email);

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
}
