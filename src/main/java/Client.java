import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static final String IP_ADDRESS = "127.0.0.1";

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(IP_ADDRESS, Server.SERVER_PORT);

            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                 Scanner scanner = new Scanner(System.in)) {

                System.out.println("Для вычисления N-го члена ряда Фибоначчи введите целое число:");
                String input = scanner.nextLine();
                out.println(input);
                System.out.println("CLIENT: отправил запрос на сервер");
                System.out.println("SERVER: результат вычислений N-го члена ряда Фибоначчи: " + in.readLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
}