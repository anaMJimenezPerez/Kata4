package kata4.main;

import java.io.IOException;
import java.util.List;
import kata4.model.*;
import kata4.view.*;

public class Kata4 {
    private static String fileName = new String("C:\\Users\\anam0\\Desktop\\Universidad\\curso 2021-2022\\IS2\\email.txt");
    private static List<Mail> mailList;
    private static Histogram histogram;
    private static HistogramDisplay histoDisplay;
    
    public static void main(String[] args) throws IOException{
        execute();
    }
    
    public static void execute() throws IOException{
        input();
        process();
        output();
    }
    public static void input() throws IOException{
        mailList = MailListReader.read(fileName);
    }
    
    public static void process(){
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    public static void output(){
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}
