import java.sql.*;
import java.util.Properties;

public class DBManager {
    private static Connection conn;
    private static int muh;
    private static Properties config = new Properties();
    private static ResultSet rs;
    static {
//        try {
//            DriverManager.registerDriver(new org.sqlite.JDBC()); //--
//            config.setProperty("open_mode", "1");  //1 == readonly
//            //Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ATN_70\\IdeaProjects\\JAVA1\\src\\sample.db", config);
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:chinook.db ", config); //relativer Pfad JAVA1 ordner (projektordner)
//           //conn.close();
//            System.out.println(conn.isClosed());
//            System.out.println(conn.getCatalog());
//            System.out.println(conn.getClientInfo());
//            System.out.println(conn+"YES I YES CONNECTED");
//            muh=23;
//            String catalogName = conn.getCatalog();
//            System.out.println("Current catalog name is: "+catalogName);
//            //conn = DriverManager.getConnection(connectionString, properties);
//            //conn.setReadOnly(true);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("UUU");
//            System.exit(1);
//        }

        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:chinook.db";
            conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
                System.out.println("Catalogs: " + dm.getCatalogTerm());
                System.out.println("Catalogs: " + dm.getSchemas());
                //conn.close();
                // rs=conn.getMetaData().getTables(null, null, null, null);


            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {

                if (conn != null) {
                    try {
                        System.out.println("Closing database");
                       // conn.close();
                        conn.getCatalog();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.out.println("CLOSED Fom Finally Static Initializer");
                    System.out.println(muh);
                }
        }



    }
    DBManager (){}
    public static void printCatalog () {
        try {
            rs=conn.getMetaData().getTables(null, null, null, null);
            while (rs.next()) {
                System.out.println(rs.getString("TABLE_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void openConnection () {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:chinook.db";
            conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
                System.out.println("Catalogs: " + dm.getCatalogTerm());
                System.out.println("Catalogs: " + dm.getSchemas());
                //conn.close();

            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace(); }

    }
       public static void closeConnection () {
           // System.out.println(conn+"Called from main public static");
            try {
                if (DBManager.conn != null) {
                    DBManager. conn.close();
                    System.out.println("YES I YES ! CONNECTION CLOSED From CloseConnection");
                    System.out.println(muh);
                }
             //   System.out.println(conn.isClosed());
               // System.out.println(muh);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                System.out.println("NO NO NOT CLOSED");
            }
        }


}