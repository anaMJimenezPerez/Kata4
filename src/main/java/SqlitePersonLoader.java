import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SqlitePersonLoader implements PersonLoader{

    private final Connection connection;
    private final static String SQL = "SELECT * from people";

    public SqlitePersonLoader(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Person> loadAll() {
        try{
            return load(query());
        } catch (SQLException e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private ResultSet query() throws SQLException{
        return connection.createStatement().executeQuery(SQL);
    }

    private List<Person> load(ResultSet resultSet) throws SQLException{
        List<Person> result = new ArrayList<>();
        while (resultSet.next()){
            result.add(personFrom(resultSet));
        }
        return result;
    }

    private static Person personFrom(ResultSet resultSet) throws SQLException{
        return new Person(
                resultSet.getString("Index"),
                resultSet.getDouble("Height"),
                resultSet.getDouble("Weight")
        );
    }
}
