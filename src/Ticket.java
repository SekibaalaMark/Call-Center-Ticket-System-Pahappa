import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Ticket {
    private String username;
    private String contactInformation;
    private String category;
    private String dateCreated;
    private String description;
    private String comment;
    private String status;
    private String priority;

    Ticket(String username,String contactInformation, String category, String dateCreated,String description,
           String comment, String priority){
        this.username = username.strip().toLowerCase();
        this.contactInformation = contactInformation;
        this.category = category.strip().toLowerCase();
        this.dateCreated = dateCreated;
        this.description = description;
        this.comment = comment;
        this.priority = priority;
        this.status = "pending";
    }

    public String getCategory() {
        return category;
    }

    public String getStatus(){
        return status;
    }

    public void setComment(String comment){
        if(!comment.isBlank()){
            this.comment = comment;
        }else {
            System.out.println("Comment Can't be Blank");
        }
    }

    public void setStatus(String status){
        if(status.strip().equalsIgnoreCase("Pending") || status.strip().equalsIgnoreCase("In Progress")
                || status.strip().equalsIgnoreCase("Resolved")){
            this.status = status;
        }else{
            System.out.println("Status Must be one of: Pending or In Progress or Resolved");
        }
    }

    public void setPriority(String priority ){
        if(priority.strip().equalsIgnoreCase("High") || priority.strip().equalsIgnoreCase("Moderate") ||
                priority.strip().equalsIgnoreCase("Low")){
            this.priority = priority;
        }else {
            System.out.println("Priority must be one of: High , Low, Moderate");
        }
    }

    @Override
    public String toString(){
        return """
                +----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                |%-20s | %-10s | %-20s | %-10s | %-50s | %-20s | %-14s | %-10s                                                                                                                          |
                +----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                """.formatted(username,contactInformation,category,dateCreated,description,comment,status,priority);
    }
}


class TicketManager{
    HashMap<String,Ticket> ticketHashMap = new HashMap<>();
    public void addTicket(String username,Ticket ticket){
        if(!ticketHashMap.containsKey(username)){
            ticketHashMap.put(username.strip().toLowerCase(),ticket);
        }else{
            System.out.println("Username already Exists");
        }
    }

    public void deleteTicket(String username){
        if(ticketHashMap.containsKey(username.strip().toLowerCase())){
            ticketHashMap.remove(username.strip().toLowerCase());
        }else{
            System.out.println("username Unknown");
        }
    }


    public void searchTicketByUsername(String username){
        if (ticketHashMap.containsKey(username.strip().toLowerCase())){
            System.out.println(ticketHashMap.get(username.strip().toLowerCase()).toString());
        }else{
            System.out.println("username unknown");
        }
    }

    public void searchTicketByCategory(String category){
        for(String username : ticketHashMap.keySet()){
            if(ticketHashMap.get(username).getCategory().strip().equalsIgnoreCase(category)){
                System.out.println(ticketHashMap.get(username).toString());
            }
        }
    }



    public void searchTicketStatus(String status){
        for(String username : ticketHashMap.keySet()){
            if(ticketHashMap.get(username).getStatus().strip().equalsIgnoreCase(status)){
                System.out.println(ticketHashMap.get(username).toString());
            }
        }

    }


    public void updateTicketComment(String username, String newComment){
        if(ticketHashMap.containsKey(username)){
            ticketHashMap.get(username).setComment(newComment);
        }else{
            System.out.println("Username Unknown....");
        }
    }

    public void updateTicketStatus(String username , String newStatus){
        if(ticketHashMap.containsKey(username)){
            ticketHashMap.get(username).setStatus(newStatus);
        }else{
            System.out.println("Username Unknown......");
        }
    }


    public void updateTicketPriority(String username, String newPriority){
        if(ticketHashMap.containsKey(username)){
            ticketHashMap.get(username).setPriority(newPriority);
        }else {
            System.out.println("Username Unknow......");
        }
    }


    public void viewTickets(){
        for(String username : ticketHashMap.keySet()){
            System.out.println(ticketHashMap.get(username).toString());
        }
    }
}





