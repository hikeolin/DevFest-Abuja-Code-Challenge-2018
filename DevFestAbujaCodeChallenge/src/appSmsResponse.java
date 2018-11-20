

/* import SDK classes */

import com.africastalking.Callback;
import com.africastalking.SmsService;
import com.africastalking.sms.Message;
import com.africastalking.sms.Recipient;
import com.africastalking.AfricasTalking;

/* import other useful packages */
import  java.util.List;


public class appSmsResponse {

    public static void main(String[] args)
    {
        /* Set your app credentials */
        String USERNAME = "sandbox";
        String API_KEY = "2dac6c9b338e9f9c5616ae6285e1d7b105a929995ce4999c39fb6221357f9d89";

        /* Initialize SDK */
        AfricasTalking.initialize(USERNAME, API_KEY);

        /* Get the SMS service */
        SmsService sms = AfricasTalking.getService(AfricasTalking.SERVICE_SMS);

        /* Set the numbers you want to send to in international format */
        String[] recipients = new String[] {
                "+2349076122030"
        };

        /* Set your message */
        String message = "We are lumberjacks. We sleep all day and code all night";


        /* Set your shortCode or senderId */
        String from = "30036"; //

        /* That’s it, hit send and we’ll take care of the rest */
        try {
            List<Recipient> response = sms.send(message, recipients, true);
            for (Recipient recipient : response) {
                System.out.print(recipient.number);
                System.out.print(" : ");
                System.out.println(recipient.status);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}
