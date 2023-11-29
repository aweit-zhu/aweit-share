package com.example.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
 * 
 *  context.xml (確定 Tomcat 路徑，Eclipse開發者，請點選 Servers 專案下的 Apache Tomcat 的路徑位置)
 *  
 <Context>

    <!-- maxTotal: Maximum number of database connections in pool. Make sure you
         configure your mysqld max_connections large enough to handle
         all of your db connections. Set to -1 for no limit.
         -->

    <!-- maxIdle: Maximum number of idle database connections to retain in pool.
         Set to -1 for no limit.  See also the DBCP documentation on this
         and the minEvictableIdleTimeMillis configuration parameter.
         -->

    <!-- maxWaitMillis: Maximum time to wait for a database connection to become available
         in ms, in this example 10 seconds. An Exception is thrown if
         this timeout is exceeded.  Set to -1 to wait indefinitely.
         -->

    <!-- username and password: MySQL username and password for database connections  -->

    <!-- driverClassName: Class name for the old mm.mysql JDBC driver is
         org.gjt.mm.mysql.Driver - we recommend using Connector/J though.
         Class name for the official MySQL Connector/J driver is com.mysql.jdbc.Driver.
         -->

    <!-- url: The JDBC connection url for connecting to your MySQL database.
         -->

    <Resource name="jdbc/EmployeeDB" 
	          auth="Container" 
			  type="javax.sql.DataSource"
			  driverClassName="com.mysql.jdbc.Driver"
              maxTotal="100" 
			  maxIdle="30" 
			  maxWaitMillis="10000"
              username="root" 
              password="root" 
              url="jdbc:mysql://localhost:6033/EmployeeDB"/>
  </Context>
  
    1. jdbc/EmployeeDB 為自己取的。通常用 jdbc 開頭。
    2. username、password、url 請輸入正確的資訊。
 * */
public class EmployeeDBDataSource {

	private static DataSource ds;

	public static DataSource getDataSource() throws NamingException{
		if(ds == null) {
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/EmployeeDB");
			} catch (NamingException e) {
				throw e;
			}
		}
		return ds;
	}
}
