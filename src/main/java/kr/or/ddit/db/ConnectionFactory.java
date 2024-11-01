package kr.or.ddit.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Factory Object Pattern
 *  : 특정 객체의 생성을 전담하는 객체를 별도로 운영하는 설계 방식.
 */
public class ConnectionFactory {

    private static ResourceBundle dbInfo;

    static {
        String baseName = "kr.or.ddit.db.DBInfo";
        dbInfo = ResourceBundle.getBundle(baseName);

        try {
            Class.forName(dbInfo.getString("driverClassName"));
        } catch (ClassNotFoundException var2) {
            ClassNotFoundException e = var2;
            throw new RuntimeException(e);
        }
    }

    public ConnectionFactory() {
    }

    public static Connection getConnection() throws SQLException {
        String url = dbInfo.getString("url");
        String user = dbInfo.getString("user");
        String password = dbInfo.getString("password");
        return DriverManager.getConnection(url, user, password);
    }

}
