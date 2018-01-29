import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String [] args) {
        int port = 110;
        Socket socket = new Socket();
        SocketAddress address = new InetSocketAddress(port);
        Scanner scanner = new Scanner(System.in);
        String line;
        try {
            socket.connect(address);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(streamReader);
            String command, input;
            while ((line = in.readLine()) != null) {
                if(line.contains("eom")) {
                    command = scanner.nextLine();
                    out.println(command);
                }
                else{
                    System.out.println(line);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }
}
