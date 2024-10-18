import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static ArrayList<Contacts> contacts;
    private static Scanner sc ;
    private static ArrayList<Message> messages;
    private static int id = 0;

    public static void main(String[] args) {
        messages = new ArrayList<>();
        contacts = new ArrayList<>();
        System.out.println("Please input your name: ");
        sc = new Scanner(System.in);
        String UserName = sc.nextLine();
        System.out.println("Welcome " + UserName);
        MainMenu();


    }

    private static void MainMenu() {
        sc = new Scanner(System.in);
        System.out.println("Choose an option: " +
                "\n\t1. Manage Contacts" +
                "\n\t2. Messages" +
                "\n\t3. Quit");

        int option = sc.nextInt();
        switch (option) {
            case 1:
                manageContacts();
                break;
            case 2:
                messages();
                break;
            default:
                break;

        }
    }

    private static void messages() {
        sc = new Scanner(System.in);
        System.out.println("\t1: Show all messages.\n\t" +
                "2: Send new message: " +
                "\n\t3: Quit");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                showAllMessages();
                break;
            case 2:
                sendMessage();
                break;
            case 3:
                MainMenu();
                break;
            default:
                System.out.println("Invalid option! Try again.");
                messages();
                break;
        }
    }

    private static void sendMessage() {
        if (contacts.isEmpty()) {
            System.out.println("It seems you have no contacts!\nFirst add the contact to send Messages.....\nRedirecting you to add new contact\n" +
                    "*****************************");
            addContact();
        }else{
            sc = new Scanner(System.in);
            System.out.println("Recipient's name: ");
            String name = sc.nextLine();
            System.out.println("Type the Message: ");
            String message = sc.nextLine();
            if (name.isBlank()||message.isBlank()) {
                System.out.println("Please fill in all the fields!!!");
                sendMessage();
            }else {
                id ++;
                Message newMessage = new Message(message, name, id);
                for (Contacts c : contacts) {
                    if(c.getName().equals(name)) {
                        messages.add(newMessage);
                        c.setMessages(messages);
                        System.out.println("Message sent!\n" +
                                "*****************************");
                        messages();
                        Contacts currentContact = c;
                        currentContact.setMessages(messages);
                        contacts.remove(c);
                        contacts.add(currentContact);

                    } else if (!c.getName().equals(name)) {
                        System.out.println("There is no contact with the name: '" + name+"' ");
                        System.out.println("Please add the contact to send Messages.....\nRedirecting you to add new contact....\n" +
                                "*******************************************");
                        addContact();
                    }
                }
            }
            messages();
        }
    }

    private static void showAllMessages() {
        ArrayList <Message> allMessages = new ArrayList<>();
        for (Contacts c : contacts) {
            allMessages.addAll(c.getMessages());
        }

        if (allMessages.size() > 0) {
            for (Message m : allMessages) {
                m.getDetails();
                System.out.println("*************************");
            }
            System.out.println("0. Quit");
            int option = sc.nextInt();
            switch (option) {
                case 0:
                    messages();
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
                    showAllMessages();
                    break;
            }
        }else {
            System.out.println("No sent messages found!!\nWould you like to send a new message?\n\t1:Send Message.\n\t2:Manage messages.");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Sending a new message\n" +
                            "*************************");
                    sendMessage();
                    break;
                case 2:
                    messages();
                    break;
                default:
                    System.out.println("Invalid option Please try again");
                    showAllMessages();
                    break;
            }
        }
    }

    private static void manageContacts() {
        sc= new Scanner(System.in);
        System.out.println("\t1.Show all contacts." +
                "\n\t2.Add a new contact." +
                "\n\t3.Search for a contact." +
                "\n\t4.Delete a contact." +
                "\n\t5.Go back to main menu.");
        sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1:
                showContacts();
                break;
            case 2:
                addContact();
                break;
            case 3:
                searchContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                MainMenu();

                break;

            }


        }

    public static void deleteContact() {
        sc= new Scanner(System.in);
        System.out.println("Please enter contact name you wish to delete:");
        String name = sc.nextLine();
        if (name.isBlank()){
            deleteContact();
        }else deleting(name);


    }

    private static void deleting(String name) {
        sc= new Scanner(System.in);
        List<Contacts> matchingContacts = new ArrayList<>();
        for (Contacts c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                matchingContacts.add(c);
                /**
                 * Remember to edit for C*/

            }
        }
        if (matchingContacts.isEmpty()) {
            System.out.println("Contact not found with name: " + name);
            manageContacts();
            return;
        } else if (matchingContacts.size() == 1) {
            confirmAndDelete(matchingContacts.get(0));
        }else {
            System.out.println("Found "+matchingContacts.size()+" contacts with the name '"+name+"'");
            for (int i = 0; i < matchingContacts.size(); i++) {
                System.out.println("\t"+(i+1)+": ");
                matchingContacts.get(i).getDetails();
            }
            System.out.println("Please enter the number of the contact you wish to delete:");
            int option = sc.nextInt();
            if (option > 0 && option <= matchingContacts.size()) {
                Contacts contactToDelete = matchingContacts.get(option - 1);
                confirmAndDelete(contactToDelete);
            }else{
                System.out.println("invalid option! Returning to manage contacts.");
                manageContacts();
            }
        }

    }

    private static void confirmAndDelete(Contacts contact) {
        sc= new Scanner(System.in);
        System.out.println("Are you sure you wish to delete the contact? Y/N");
        String answer = sc.nextLine();
        switch (answer.toUpperCase()) {
            case "Y":
                contacts.remove(contact);
                System.out.println("Contact deleted.");
                break;
            case "N":
                manageContacts();
                break;
            default:
                System.out.println("Invalid input! Try again.");
                confirmAndDelete(contact);
                break;
        }
    }

    private static void searchContact() {
        sc= new Scanner(System.in);
        System.out.println("Please enter a contact name: ");
        String name = sc.nextLine();
        if (name.isBlank()){
            searchContact();
        }else {
            boolean Exists = false;
            for (Contacts c : contacts) {
                if (c.getName().equals(name)) {
                    Exists = true;
                    c.getDetails();
                }
            }
            if (!Exists) {
                System.out.println("Contact does not exist.");
                nonExistent();
            }
        }
        manageContacts();
    }

    private static void nonExistent() {
        sc = new Scanner(System.in);
        System.out.println("Would you like to add the new contact? (Y/N)");

        String option = sc.nextLine();
        switch (option) {
            case "Y":
                addContact();
                break;
            case "N":
                searchContact();
                break;
            default:
                System.out.println("Invalid option. Try again.");
                nonExistent();
                break;

        }
    }

    private static void addContact() {
        sc= new Scanner(System.in);
        String Name;
        String phoneNumber;
        String Email;
        System.out.println("Adding a new contact.\nPlease enter contact's name: ");
        Name = sc.nextLine();
        System.out.println("Please enter contact's number:");
        phoneNumber = sc.nextLine();
        System.out.println("Please enter contact's email:");
        Email = sc.nextLine();

        if (Name.isEmpty() || phoneNumber.isBlank() || Email.isBlank()) {
            System.out.println("Please enter all of the information!.");
            addContact();
        }else {
            Contacts newContact = new Contacts(Name, phoneNumber, Email);
            contacts.add(newContact);
        }
        manageContacts();
    }

    private static void showContacts() {
        sc= new Scanner(System.in);
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            addContact();
        }else {
            for (Contacts c : contacts) {
                c.getDetails();
                System.out.println("***************************");
            }
//            System.out.println(contacts.size());
            System.out.println("\n1: Return to manage contacts\n" +
                    "2: Return to main menu");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    manageContacts();
                    break;
                case 2:
                    MainMenu();
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    showContacts();
                    break;
            }
        }
    }
}


