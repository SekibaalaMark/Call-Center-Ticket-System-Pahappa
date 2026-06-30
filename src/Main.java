import java.util.Scanner;
public class Main {

    static void handleAddingTicket(TicketManager ticketManager){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter Contact Information: ");
        String contactInformation = scanner.nextLine();
        System.out.println("Enter Category: ");
        String category = scanner.nextLine();
        System.out.println("Enter Description: ");
        String description = scanner.nextLine();
        System.out.println("Enter Comment: ");
        String comment = scanner.nextLine();
        System.out.println("Enter Priority: ");
        String priority = scanner.nextLine();
        ticketManager.addTicket(username,new Ticket(username,contactInformation,category,description,comment,priority));
    }

    static void handleUpdatingComment(TicketManager ticketManager){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter New Comment: ");
        String newComment = scanner.nextLine();
        ticketManager.updateTicketComment(username,newComment);
    }

    static void handleUpdatingStatus(TicketManager ticketManager){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter New Status: ");
        String newStatus = scanner.nextLine();
        ticketManager.updateTicketStatus(username,newStatus);
    }

    static void handleUpdatingPriority(TicketManager ticketManager){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter New Priority: ");
        String newPriority = scanner.nextLine();
        ticketManager.updateTicketPriority(username,newPriority);
    }

    static void searchTicketByUsername(TicketManager ticketManager){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        ticketManager.searchTicketByUsername(username);
    }

    static void searchTicketByCategory(TicketManager ticketManager){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Category: ");
        String category = scanner.nextLine();
        ticketManager.searchTicketByCategory(category);
    }

    static void searchTicketByStatus(TicketManager ticketManager){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Status: ");
        String status = scanner.nextLine();
        ticketManager.searchTicketStatus(status);
    }

    static void handleTicketDeletion(TicketManager ticketManager){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        ticketManager.deleteTicket(username);
    }

    static void viewAllTickets(TicketManager ticketManager){
        ticketManager.viewTickets();
    }

    static void screen(){
        System.out.println("1. To Add a Ticket");
        System.out.println("2. To Update a Comment");
        System.out.println("3. To Update Status");
        System.out.println("4. To Update Priority");
        System.out.println("5. To Search Ticket by username");
        System.out.println("6. To Search Ticket by category");
        System.out.println("7. To Search Ticket by Status");
        System.out.println("8. To Delete Ticket");
        System.out.println("9. To View all Tickets");
        System.out.println("0. To Exit");
    }

    static void options( TicketManager ticketManager){
        Scanner scanner = new Scanner(System.in);
        menuLoop:
        while(true){
            screen();
            try{
                int option = scanner.nextInt();
                scanner.nextLine();
                switch (option){
                    case 1 : handleAddingTicket(ticketManager);break;
                    case 2: handleUpdatingComment(ticketManager);break;
                    case 3: handleUpdatingStatus(ticketManager);break;
                    case 4: handleUpdatingPriority(ticketManager);break;
                    case 5: searchTicketByUsername(ticketManager);break;
                    case 6: searchTicketByCategory(ticketManager);break;
                    case 7: searchTicketByStatus(ticketManager);break;
                    case 8: handleTicketDeletion(ticketManager);break;
                    case 9: viewAllTickets(ticketManager);break;
                    case 0: break menuLoop;
                    default:System.out.println("Invalid Option!!!");
                }
            }catch(Exception InputMismatchException){
                System.out.println("Only Numerical Options are Supported Please!!!!");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketManager ticketManager = new TicketManager();
        options(ticketManager);
        scanner.close();
    }
}