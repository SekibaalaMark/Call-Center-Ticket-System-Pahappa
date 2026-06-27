
class Ticket {
    private String username;
    private String contactInformation;
    private String category;
    private String dateCreated;
    private String description;
    private String comment;
    private String status;
    private int priority;

    Ticket(String username,String contactInformation, String category, String dateCreated,String description,
           String comment, int priority){
        this.username = username;
        this.contactInformation = contactInformation;
        this.category = category;
        this.dateCreated = dateCreated;
        this.description = description;
        this.comment = comment;
        this.priority = priority;
        this.status = "Pending";
    }



}
