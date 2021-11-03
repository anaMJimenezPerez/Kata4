package kata4.model;

public class Mail {
    private String cadena;
    public Mail(String email){
        cadena=email;
    }
    
    public String getDomain(){
        String[] domain = cadena.split("@");
        return domain[1];
    }
}
