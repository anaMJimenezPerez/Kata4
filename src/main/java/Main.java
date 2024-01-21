import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args){
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:people.db")) {
            PersonLoader personLoader = new SqlitePersonLoader(connection);
            List<Person> people = personLoader.loadAll();
            for(Person person: people){
                System.out.println(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}