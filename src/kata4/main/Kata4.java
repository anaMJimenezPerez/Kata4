package kata4.main;

import java.io.IOException;
import java.util.List;
import kata4.model.*;
import kata4.view.*;

public class Kata4 {
    public static void main(String[] args) throws IOException {
        String fileName = new String("C:\\Users\\anam0\\Desktop\\Universidad\\curso 2021-2022\\IS2\\email.txt");
        List<Mail> mailList = MailListReader.read(fileName);
        Histogram histogram = MailHistogramBuilder.build(mailList);
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}
