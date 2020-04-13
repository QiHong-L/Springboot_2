import com.getheart.MySpringBootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Json
 * @date 2020-31-15:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class test {

    @Autowired
    DataSource dataSource;
    @Test
    public void connectionTest() throws SQLException {

        System.out.println(dataSource.getClass());

        Connection con = dataSource.getConnection();
        System.out.println(con);
        con.close();
    }
}
