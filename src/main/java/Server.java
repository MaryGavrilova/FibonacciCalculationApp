import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int SERVER_PORT = 8888;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

            try (Socket socket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                System.out.println("New connection accepted");
                int number = Integer.parseInt(in.readLine());
                System.out.println("Starting calculating");
                int result = calculateFibonacci(number);
                out.println(result);
                System.out.println("Result sent");
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static int calculateFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        }
    }
}

