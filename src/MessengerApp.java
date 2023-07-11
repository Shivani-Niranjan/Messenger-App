/*
Create an interface called MessagingService with the following method:
        sendMessage(): This method should be implemented by classes representing different messaging services.

        Create three classes, SMSMessagingService, EmailMessagingService, and WhatsAppMessagingService, which implement the MessagingService interface.
        Implement the sendMessage() method in each class based on the specific messaging service requirements.

        Write a java code to demonstrate the usage of these classes, where you create instances of each messaging service class and
        invoke the sendMessage() method on each instance.
*/

import java.util.Scanner;

interface MessagingService{
    void sendMessage();
}

class SMSMessagingService implements MessagingService{
    public void sendMessage() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Mobile Number  :");
        String mobileNumber = scan.next();
        while (mobileNumber.length() != 10 || mobileNumber.charAt(0) == '0'){
            System.out.println("Invalid Mobile Number " );
            System.out.println("Enter Mobile Number again : ");
            mobileNumber = scan.next();
        }
        System.out.println("Enter Message : ");
        String message = scan.next();
        System.out.println("Message sent to " +mobileNumber);
    }
}

class EmailMessagingService implements MessagingService{
    public void sendMessage(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Email : ");
        String emailTo = scan.next();
        while ( emailTo.matches("^(?![A-Za-z0-9+_.-]+@(.+))$" )) {
            System.out.println("Enter email again : ");
            emailTo = scan.next();
        }
        System.out.println("Enter Message : ");
        String message = scan.next();
        System.out.println("Email sent to " + emailTo);
    }
}

class WhatsAppMessagingService implements MessagingService{
    public void sendMessage(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Mobile Number :");
        String mobileNumber = scan.next();
        while (mobileNumber.length() != 10 || mobileNumber.charAt(0) == '0'){
            System.out.println("Invalid Mobile Number ");
            System.out.println("Enter Mobile Number again : ");
            mobileNumber = scan.next();
        }
        System.out.println("Enter Message : ");
        String message = scan.next();
        System.out.println("Message sent to " + mobileNumber);
    }
}

public class MessengerApp {
    public static void main(String[] args) {
        SMSMessagingService sms_obj = new SMSMessagingService();
        EmailMessagingService email_obj = new EmailMessagingService();
        WhatsAppMessagingService whatsapp_obj = new WhatsAppMessagingService();
        Scanner scan = new Scanner(System.in);
        int input = 0;
        do {
            System.out.println("Enter \n" + "1 for SMS \n" + "2 for Email  \n" + "3 for WhatsApp  \n" + "4 to Exit");
            input = scan.nextInt();
            switch (input){
                case 1 : {
                    sms_obj.sendMessage();
                    break;
                }
                case 2 : {
                    email_obj.sendMessage();
                    break;
                }
                case 3 : {
                    whatsapp_obj.sendMessage();
                    break;
                }
                case 4 : {
                    break;
                }
            }
        }while (input != 4);
    }
}