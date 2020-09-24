import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
    /**
     * This method calculate and returns the result of mathematical expression.
     * @param status
     * @return result.
     */
    public static int calculator(String status){
        //Split the status message
        String str[] = status.split(" ");
        int num1 = Integer.parseInt(str[2]);
        int num2 = Integer.parseInt(str[4]);
        String operator = str[3];
        int result = 0;
        if (operator.equals("+"))
            result = num1 + num2;
        else if (operator.equals("-"))
            result = num1 - num2;
        else if (operator.equals("*"))
            result = num1 * num2;
        else if (operator.equals("/"))
            result = num1 / num2;
        return result;

    }
    public static void main(String[] args) throws IOException {
        //Set the initial port
        int port = 27995;
        boolean sslFlag = false;
        BufferedReader in;
        PrintWriter out;
        Socket sc = null;

        //Validates the args' optional choices
        if (args.length > 2){
            if (args[0].equals("-p")) {
                port = Integer.parseInt(args[1]);
                if (args[2].equals("-s")) {
                    sslFlag = true;
                }
            }else if (args[0].equals("-s")) {
                port = 27996;
                sslFlag = true;
            }
        }
        String server = args[args.length - 2];
        String nuid = args[args.length - 1];

        //Try create Socket
        try{
            if (sslFlag){
                System.setProperty("javax.net.ssl.trustStore", "jssecacerts");
                SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                sc = (SSLSocket) factory.createSocket(server, port);
            }else {
                sc = new Socket(server, port);
            }
            System.out.println("Connected");

        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

        out = new PrintWriter(sc.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
        out.println("cs5700fall2020 HELLO " + nuid + "\n");
        String message = in.readLine();

        while (message.contains("STATUS")){
            int solution = calculator(message);
            out.println("cs5700fall2020 " + solution +"\n");
            message = in.readLine();
        }
        if (message.contains("BYE")){
            System.out.println(message);
            try
            {
                in.close();
                out.close();
                sc.close();
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }



    }
}
