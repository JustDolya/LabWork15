import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Pattern p = Pattern.compile("((25[0-5]|2[0-4]\\d|1?\\d?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1?\\d?\\d)");

        System.out.print("Введите строку: ");
        String ip = input.nextLine();

        Matcher m = p.matcher(ip);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("note.txt"))) {
            if (m.find()) {
                bw.write("Your IPv4 is " + m.group());
            }else{
                bw.write("Can't find your IP address, please try again");
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}