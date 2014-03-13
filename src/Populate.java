
/**
*
* @author Hui Li
*/

import java.io.*;
import oracle.sql.*;
import oracle.jdbc.*;
import java.sql.*;

public class Populate
{
	/**
     * @param args the command line arguments
     */
    private String host;
    private String port;
    private String dbname;
    private String username;
    private String password;
    private Connection con = null;
    private Statement st = null;
    
    //get the properties from the file
    public void getProperties(String path) 
    {
        try {
            BufferedReader inFile = new BufferedReader(new FileReader(path));
            host = inFile.readLine();
            port = inFile.readLine();
            dbname = inFile.readLine();
            username = inFile.readLine();
            password = inFile.readLine();

        } catch (FileNotFoundException e) {
        	System.out.println("cannot find the property file");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //connect to Oracle database, and delete all the old data from the table
    public void connectDB()
	{
        try 
        {
            String driver = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driver);
            System.out.println("connecting to database");
            String url = "jdbc:oracle:thin:@" + host + ":" + port + ":" + dbname;
            con = DriverManager.getConnection(url, username, password);
            st = con.createStatement();
            System.out.println("connect to database successfully");
            String sql = "DELETE FROM BUILDING";
            st.execute(sql);
            sql = "DELETE FROM PEOPLE";
            st.execute(sql);
            sql = "DELETE FROM AP";
            st.execute(sql);
        } catch (SQLException e) {
        	System.out.println("cannot connect to database");
        	e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
    
    //manipulate the data, populate the data from the file to the database
    public void populateData(String file1, String file2, String file3)
    {
            try 
            {
                String line;
                //each arg corresponding to a column
                String arg1, arg2, arg3, arg4;
                
                //read the building file
                BufferedReader inFile1 = new BufferedReader(new FileReader(file1));                
                while ((line = inFile1.readLine()) != null) 
                {
                	String[] items = line.split(","+" ");
                	arg1 = items[0];
                	arg2 = items[1];
                	arg3 = items[2];
                	Integer pointNumber = Integer.valueOf(items[2]);
                	String startX = items[3];
                	String startY = items[4];
                	String pointPosition = items[3] + "," + items[4] + "," + " ";
                	int count = 1;
                	while (count < pointNumber)
					{
                		/*
						if ()//if the number beyond the boundary
						{
							
						}*/
						pointPosition = pointPosition + items[3+2*count] + "," + items[3+2*count+1] + "," + " ";
						count++;
					}
                	pointPosition = pointPosition + startX + "," + startY;
                    String sql1 = "INSERT INTO BUILDING VALUES ('" + arg1 + "','" + arg2 + "','" + arg3 + "',SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(" + pointPosition + ")))";
                    System.out.println(sql1);
                    st.execute(sql1);
                }
                
                //read the people file
                BufferedReader inFile2 = new BufferedReader(new FileReader(file2));
                while ((line = inFile2.readLine()) != null) 
                {
                	String[] items = line.split(","+" ");
                	arg1 = items[0];
                	arg2 = items[1];
                    arg3 = items[2];
                    String sql2 = "INSERT INTO PEOPLE VALUES ('" + arg1 + "'," + "SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(" + arg2 + "," + arg3 + ",NULL),NULL,NULL))";
                    System.out.println(sql2);
                    st.execute(sql2);
                }

                //read the ap file 
                BufferedReader inFile3 = new BufferedReader(new FileReader(file3));
                while ((line = inFile3.readLine()) != null) 
                {
                	String[] items = line.split(","+" ");
                	arg1 = items[0];
                	arg2 = items[1];
                    arg3 = items[2];
                    arg4 = items[3];
                    String sql3 = "INSERT INTO AP VALUES ('" + arg1 + "'," + "SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE(" + arg2 + "," + arg3 + ",NULL),NULL,NULL)," + arg4 + ")";
                    System.out.println(sql3);
                    st.execute(sql3);
                }
            } catch (FileNotFoundException e) {
            	// TODO Auto-generated catch block
            	System.out.println("cannot find the file");
                e.printStackTrace();
            } catch (IOException e) {
            	// TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
				// TODO Auto-generated catch block
            	System.out.println("cannot insert to database");
				e.printStackTrace();
			} 
            finally 
			{
				try 
	        	{
	        		if (con != null) 
	        		{
	        			con.close();
	        			System.out.println("connection closed");
	        		}
	        	} catch (SQLException e) {
	        		System.out.println("cannot close to database");
	        		e.printStackTrace();
	            }
	        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		if (args.length != 4) 
		{
            System.out.println("argument error");
        } 
		else 
		{
			//String building_file = "./ building.xy";
			String properties_file = args[0];
            String building_file = args[1];
            String people_file = args[2];
            String ap_file = args[3];
            Populate mypopulate = new Populate();
            mypopulate.getProperties(properties_file);
            mypopulate.connectDB();
            mypopulate.populateData(building_file, people_file, ap_file);
        }
	}
}
