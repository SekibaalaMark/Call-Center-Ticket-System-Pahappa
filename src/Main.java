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
        while(true){
            screen();
            try{
                int option = scanner.nextInt();
                scanner.nextLine();
                if(option==1){
                    handleAddingTicket(ticketManager);
                } else if (option==2) {
                    handleUpdatingComment(ticketManager);
                } else if (option==3) {
                    handleUpdatingStatus(ticketManager);
                } else if (option==4) {
                    handleUpdatingPriority(ticketManager);
                } else if (option==5) {
                    searchTicketByUsername(ticketManager);
                } else if (option==6) {

                } else if (option==7) {
                    System.out.println("Enter Status: ");
                    String status = scanner.nextLine();
                    ticketManager.searchTicketStatus(status);
                } else if (option==8) {
                    System.out.println("Enter username: ");
                    String username = scanner.nextLine();
                    ticketManager.deleteTicket(username);
                } else if (option==9) {
                    ticketManager.viewTickets();
                } else if (option==0) {
                    break;
                }else {
                    System.out.println("Invalid Option!!!");
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