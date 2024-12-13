package App.Infrastructure;
import App.Domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserRepository extends BaseRepository<User>{

    public UserRepository(JdbcTemplate databaseConnection) {
        super(databaseConnection);
    }

    @Override
    public User get(String id) throws Exception {
        return null;
    }

    @Override
    public List<User> get() {
        String SQL = "SELECT User_ID AS userID, First_Name AS firstName, Last_Name AS lastName, Username AS username, Password AS password FROM [User];";
        return this.getDatabaseConnection().query(SQL, BeanPropertyRowMapper.newInstance(User.class));
    }

    @Override
    public void create(User user) {
        String SQL = "INSERT INTO [USER] (First_Name, Last_Name, Username, Password) " +
                "VALUES (?, ?, ?, ?);";
        this.getDatabaseConnection().update(SQL,
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getPassword()
        );
    }

    @Override
    public void delete(String id) {
        String SQL = "DELETE FROM [User] WHERE User_ID = ?;";
        this.getDatabaseConnection().update(SQL, id);
    }

    @Override
    public void update(String id, User user) {
        String SQL = "UPDATE [User] SET First_Name = ?, Last_Name = ?, Username = ?, Password = ? " +
                "WHERE User_ID = ?;";

        this.getDatabaseConnection().update(SQL, user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(), id);
    }
}
