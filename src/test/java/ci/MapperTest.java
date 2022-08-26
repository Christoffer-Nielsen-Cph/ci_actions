package ci;
import DB.DBconnector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MapperTest {
    
    @BeforeEach
    void setUp() {
        System.out.println("TESTINNNNGGGG");
        Connection con = null;
        try {
            con = DBconnector.connection();
            String createTable = "CREATE TABLE IF NOT EXISTS `startcode_test`.`usertable` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `fname` VARCHAR(45) NULL,\n" +
                    "  `lname` VARCHAR(45) NULL,\n" +
                    "  `pw` VARCHAR(45) NULL,\n" +
                    "  `phone` VARCHAR(45) NULL,\n" +
                    "  `address` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`));";
            con.prepareStatement(createTable).executeUpdate();
            String SQL = "INSERT INTO startcode_test.usertable (fname, lname, pw, phone, address) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "Hans");
            ps.setString(2, "Hansen");
            ps.setString(3, "Hemmelig123");
            ps.setString(4, "40404040");
            ps.setString(5,"Rolighedsvej 3");
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testOne() {
        UserMapper userMapper = new UserMapper();
        User expectedUser = new User("Hans","Hansen");
        User actualUser = userMapper.getUserName();
        assertEquals(expectedUser.toString(),actualUser.toString());
    }

    @Test
    void testTwo() {
        UserMapper userMapper = new UserMapper();
        User expected = new User("Hans","Hansen","Hemmelig123",40404040,"Rolighedsvej 3");
        User actual = userMapper.getDetailsOfSpecificUser(1);
        assertEquals(expected.toString(),actual.toString());
    }

   /* @Test
    void testThree() {
        UserMapper userMapper = new UserMapper();
        User expected = new User("Frank","Hansen","Hemmelig123",40404040,"Rolighedsvej 3");
        userMapper.updateUser(1,"Frank");
        User actual = userMapper.getDetailsOfSpecificUser(1);
        assertEquals(expected,actual);
    } */
}
