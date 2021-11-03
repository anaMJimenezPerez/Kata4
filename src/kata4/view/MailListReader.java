package kata4.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata4.model.Mail;

public class MailListReader {
    public static List<Mail> read(String fileName) throws FileNotFoundException, IOException{
        List<Mail> listaEmail = new ArrayList<Mail>();
        File archivo = new File (fileName);
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        Mail email;
        while((linea=br.readLine()) != null){
            if(linea.contains("@")){
                email = new Mail(linea);
                listaEmail.add(email);
            }
        }
        return listaEmail;
    }
}
