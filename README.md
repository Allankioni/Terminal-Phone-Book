# Contact Management Program

This is a simple Java-based contact management application that allows you to manage your contacts and send messages. The program includes functionalities such as adding, deleting, and searching for contacts, as well as sending and displaying messages.

## Getting Started

### Prerequisites

- Download and install [IntelliJ IDEA](https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows) to run the program.

### Running the Program

1. Clone or download the repository containing the project.
2. Open the project in IntelliJ IDEA.
3. Navigate to the `src` folder and locate `Main.java`.
4. Run the program.

### How to Use

When you run the program, it will prompt you to input your name. After that, you will see the main menu with several options:

1. **Manage Contacts**:
   - Show all contacts.
   - Add a new contact.
   - Search for a contact.
   - Delete a contact.
   - Return to the main menu.

2. **Messages**:
   - Show all messages.
   - Send a new message.
   - Quit or go back to the main menu.

3. **Quit**: Exit the program.

### Example Flow

- After launching the program, you might be prompted as follows:
Enter your name, and you'll be greeted with:


- **Manage Contacts**: You can view all your contacts, add new ones, search for existing contacts, or delete them. If you try to send a message without any contacts, the program will guide you to add one first.

- **Messages**: You can view all sent messages or send a new message. When sending a message, you must provide the recipient's name (which should already be in your contact list) and the message content.

## How the Program Works

1. **Input Handling**: The program takes inputs from the user for various tasks like adding contacts, searching, and sending messages. It validates inputs to ensure fields are not left blank.

2. **Managing Contacts**:
 - The program allows adding new contacts with a name, phone number, and email address.
 - It stores contacts in an `ArrayList` and offers options to view, search, and delete contacts.
 - The deletion process includes searching for the contact by name and confirming the deletion if multiple matches are found.

3. **Messaging System**:
 - Messages can be sent to existing contacts. The program checks if the recipient exists before sending.
 - All sent messages are stored and can be reviewed through the "Show all messages" option.

4. **Menu Navigation**:
 - The program uses a series of switch-case statements to navigate through different menu options, allowing users to interact with the application smoothly.

### Note

- When searching for or deleting contacts, the program is case-insensitive and looks for exact matches.
- If you attempt an invalid action or input, the program prompts you to try again or provides the appropriate menu to guide you.

Feel free to explore the program by running it and experimenting with different inputs!
