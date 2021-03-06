package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JPAUtil {
  Statement stFirebird, stOracle, stPostgre;
  
  public JPAUtil() throws Exception{
	  Class.forName("org.firebirdsql.jdbc.FBDriver");
	  String urlFirebird = "jdbc:firebirdsql:localhost/3050:D:\\Desenvolvimento\\DataBase\\Firebird\\Bases\\TESTE.GDB";
	  Connection connFirebird = DriverManager.getConnection(urlFirebird, "SYSDBA", "masterkey");
	  stFirebird = connFirebird.createStatement();
	  
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  String urlOracle = "jdbc:oracle:thin:@localhost:1521:XE";
	  Connection connOracle = DriverManager.getConnection(urlOracle, "system", "Daisuki!13");
	  stOracle = connOracle.createStatement();
	  
	  Class.forName("org.postgresql.Driver");
	  String urlPostgre = "jdbc:postgresql://localhost/TesteDB";
	  Connection connPostgre = DriverManager.getConnection(urlPostgre, "postgres", "Daisuki!13");
	  stPostgre = connPostgre.createStatement();
  }
  
  public void executeSQLCommandFirebird(String sql) throws Exception {
	  stFirebird.executeUpdate(sql);
  }
  
  public void executeSQLCommandOracle(String sql) throws Exception {
	  stOracle.executeUpdate(sql);
  }
  public void executeSQLCommandPostgre(String sql) throws Exception {
	  stPostgre.executeUpdate(sql);
  }
}
