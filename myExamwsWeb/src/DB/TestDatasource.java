package DB;

import java.sql.*;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TestDatasource {


	protected static void usingDataSource() {
    	try{

    		InitialContext cxt = new InitialContext();
    		System.out.print(cxt);
    		if (cxt != null){
    			DataSource ds = (DataSource)cxt.lookup("java:/PostgresXADS");
    			if(ds == null) { 
    				System.out.print("\n Error while obtaining the dataSource");
    			}else{
    				Connection connection = ds.getConnection();
    				Statement stm = connection.createStatement();
    				connection.close();
    				stm.close();
    			}
    		}
        }catch (Exception e) {
            System.out.print( "\n"+e.toString());
            System.exit(0);
    }
}
}
    	
    	
    


