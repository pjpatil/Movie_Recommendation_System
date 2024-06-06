package mrs.predict.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.CallableStatement;


public class DBHelper {
	protected DBConfig db =DBConfig.getDBInstance();
	protected Connection conn=DBConfig.getConnection();
	protected PreparedStatement stmt=DBConfig.getStatement();
	protected ResultSet rs=	DBConfig.getResultSet();
	protected CallableStatement clst=(CallableStatement) DBConfig.getClst();
	

}
