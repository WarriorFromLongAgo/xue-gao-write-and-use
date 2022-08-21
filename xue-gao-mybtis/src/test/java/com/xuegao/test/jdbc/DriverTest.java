package com.xuegao.test.jdbc;

import com.xuegao.mybatis.io.Resources;

import java.sql.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class DriverTest {
    private static Map<String, Driver> REGISTERED_DRIVER_MAP = new ConcurrentHashMap<>();
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    private static ClassLoader driverClassLoader;
    public static Properties driverProperties;

    private static Boolean autoCommit;
    private static Integer defaultTransactionIsolationLevel;
    private static Integer defaultNetworkTimeout;

    static {
        // driver = "com.mysql.jdbc.Driver";
        driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://127.0.0.1:3306/minimybatis";
        username = "65126";
        password = "123456";
        driverProperties = new Properties();
        driverProperties.setProperty("driver", driver);
        driverProperties.setProperty("url", url);
        driverProperties.setProperty("username", username);
        driverProperties.setProperty("password", password);
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = doGetConnection(driverProperties);
        PreparedStatement ps1 = connection.prepareStatement("select * from users where uid in (?,?)");
        ps1.setInt(1, 1);
        ps1.setInt(2, 2);
        ResultSet resultSet = ps1.executeQuery();
        System.out.println(resultSet);

        List<Map<String, Object>> rowList = new ArrayList<>(100);
        ResultSetMetaData md = resultSet.getMetaData();
        int columnCount = md.getColumnCount();
        while (resultSet.next()) {
            Map<String, Object> rowData = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(md.getColumnName(i), resultSet.getObject(i));
            }
            rowList.add(rowData);
        }
        // int uid = resultSet.getInt("uid");
        // String name = resultSet.getString("name");
        System.out.println(rowList);
    }

    public static Connection doGetConnection(Properties properties) throws SQLException {
        initializeDriver();
        Connection connection = DriverManager.getConnection(url, properties);
        configureConnection(connection);
        return connection;
    }

    private static synchronized void initializeDriver() throws SQLException {
        if (!REGISTERED_DRIVER_MAP.containsKey(driver)) {
            Class<?> driverType;
            try {
                if (driverClassLoader != null) {
                    driverType = Class.forName(driver, true, driverClassLoader);
                } else {
                    driverType = Resources.classForName(driver);
                }
                // DriverManager requires the driver to be loaded via the system ClassLoader.
                // http://www.kfu.com/~nsayer/Java/dyn-jdbc.html
                Driver driverInstance = (Driver) driverType.getDeclaredConstructor().newInstance();
                DriverManager.registerDriver(new DriverProxy(driverInstance));
                REGISTERED_DRIVER_MAP.put(driver, driverInstance);
            } catch (Exception e) {
                throw new SQLException("Error setting driver on UnpooledDataSource. Cause: " + e);
            }
        }
    }

    private static void configureConnection(Connection conn) throws SQLException {
        if (defaultNetworkTimeout != null) {
            // conn.setNetworkTimeout(Executors.newSingleThreadExecutor(), defaultNetworkTimeout);
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1,
                    0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(), r -> {
                Thread thread = new Thread(r);
                thread.setName("configureConnection ");
                return thread;
            });
            conn.setNetworkTimeout(threadPoolExecutor, defaultNetworkTimeout);
        }
        if (autoCommit != null && autoCommit != conn.getAutoCommit()) {
            conn.setAutoCommit(autoCommit);
        }
        if (defaultTransactionIsolationLevel != null) {
            conn.setTransactionIsolation(defaultTransactionIsolationLevel);
        }
    }

    private static class DriverProxy implements Driver {
        private final Driver driver;

        DriverProxy(Driver d) {
            this.driver = d;
        }

        @Override
        public boolean acceptsURL(String u) throws SQLException {
            return this.driver.acceptsURL(u);
        }

        @Override
        public Connection connect(String u, Properties p) throws SQLException {
            return this.driver.connect(u, p);
        }

        @Override
        public int getMajorVersion() {
            return this.driver.getMajorVersion();
        }

        @Override
        public int getMinorVersion() {
            return this.driver.getMinorVersion();
        }

        @Override
        public DriverPropertyInfo[] getPropertyInfo(String u, Properties p) throws SQLException {
            return this.driver.getPropertyInfo(u, p);
        }

        @Override
        public boolean jdbcCompliant() {
            return this.driver.jdbcCompliant();
        }

        @Override
        public Logger getParentLogger() {
            return Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        }
    }
}
