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
        this.username = username;
        this.contactInformation = contactInformation;
        this.category = category;
        this.dateCreated = dateCreated;
        this.description = description;
        this.comment = comment;
        this.priority = priority;
        this.status = "Pending";
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
            ticketHashMap.put(username,ticket);
        }else{
            System.out.println("Username already Exists");
        }
    }



}





