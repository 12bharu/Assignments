package com.valtech.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {
	
	static{
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static final String TABLE_NAME="valtechemp";
	public int getNextValidId()throws Exception {
		Connection con=getConnection();
		PreparedStatement ps =con.prepareStatement("select max(id) from "+TABLE_NAME);
		ResultSet rs =ps.executeQuery();
		int id=-1;
		if(rs.next()) {
			id=rs.getInt(1);
			
		}con.close();
		 return id+1;
	}
	
	public int getNextId(int currId) throws Exception {
		int id=-1;
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select id from "+TABLE_NAME+" where id > ? fetch next 1 row only");
		ps.setInt(1, currId);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) id =rs.getInt(1);
		con.close();
		return id;
	}
	
	public int getPreviousId(int currId) throws Exception {
		int id=-1;
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select max(id) from "+TABLE_NAME+" where id < ? fetch next 1 row only");
		ps.setInt(1, currId);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) id =rs.getInt(1);
		con.close();
		return id;
	}
	public int getFirstId(int currId) throws Exception{
        int id=-1;
        Connection con=getConnection();
        PreparedStatement ps = con.prepareStatement("select min(id) from "+TABLE_NAME);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) id = rs.getInt(1);
        con.close();
        return id;
            
        }
    public int getLastId(int currId) throws Exception{
        int id=-1;
        Connection con=getConnection();
        PreparedStatement ps = con.prepareStatement("select max(id) from "+TABLE_NAME);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) id = rs.getInt(1);
        con.close();
        return id;
            
        }
		
	
	
//	public void updateEmployee(Employee e) throws Exception{
//		Connection con=getConnection();
//		PreparedStatement ps=con.prepareStatement("Update "+ TABLE_NAME+ " Set age=?, Where id = ?");
//		//ps.setInt(1, id);
//		ps.executeUpdate();
//		con.close();
//		
//		
//	}
	public List<Employee> getEmployeesByAge(int age)throws Exception{
        Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("Select id,name,age,gender,sal from "+TABLE_NAME+" where age = "+age);
        ResultSet rs=ps.executeQuery();
        List<Employee> employees=new ArrayList<>();
        while(rs.next()) {
            employees.add(employeeFromResultSet(rs));
            
        }
        con.close();
        return employees;
    }
	
	  public List<Employee> getEmployeesBtwAge(int minage,int maxage)throws Exception{
	        Connection con=getConnection();
	        PreparedStatement ps=con.prepareStatement("Select max(id),name,age,gender,sal from "+TABLE_NAME+" where age between "+minage+" and "+maxage);
	        ResultSet rs=ps.executeQuery();
	        List<Employee> employees=new ArrayList<>();
	        while(rs.next()) {
	            employees.add(employeeFromResultSet(rs));
	            
	        }
	        con.close();
	        return employees;
	    }
	  
	  public List<Employee> getSalarygreaterthan(float sal)throws Exception{
	        Connection con=getConnection();
	        PreparedStatement ps=con.prepareStatement("Select id,name,age,gender,age from "+TABLE_NAME+" where sal>"+sal);
	        ResultSet rs=ps.executeQuery();
	        List<Employee> employees=new ArrayList<>();
	        while(rs.next()) {
	            employees.add(employeeFromResultSet(rs));
	            
	        }
	        con.close();
	        return employees;
	    }
	
	  public List<Employee> getSalarylessthan(float sal)throws Exception{
		  Connection con=getConnection();
		  PreparedStatement ps=con.prepareStatement("Select id,name,age,gender,age from "+TABLE_NAME+" where sal<"+sal);
		  ResultSet rs=ps.executeQuery();
		  List<Employee> employees=new ArrayList<>();
		  while(rs.next()) {
			  employees.add(employeeFromResultSet(rs));
			  
		  }
		  con.close();
		  return employees;
	  }
	  
	  public List<Employee> getMale()throws Exception{
		  Connection con=getConnection();
		  PreparedStatement ps=con.prepareStatement("Select id,name,age,sal,age from "+TABLE_NAME+" where gender= 'M'");
		  ResultSet rs=ps.executeQuery();
		  List<Employee> employees=new ArrayList<>();
		  while(rs.next()) {
			  employees.add(employeeFromResultSet(rs));
			  
		  }
		  con.close();
		  return employees;
	  }
	  public List<Employee> getFeMale()throws Exception{
		  Connection con=getConnection();
		  PreparedStatement ps=con.prepareStatement("Select id,name,age,sal,age from "+TABLE_NAME+" where gender= 'F'");
		  ResultSet rs=ps.executeQuery();
		  List<Employee> employees=new ArrayList<>();
		  while(rs.next()) {
			  employees.add(employeeFromResultSet(rs));
			  
		  }
		  con.close();
		  return employees;
	  }
	  public List<Employee> getOthers()throws Exception{
		  Connection con=getConnection();
		  PreparedStatement ps=con.prepareStatement("Select id,name,age,sal,age from "+TABLE_NAME+" where gender= 'O'");
		  ResultSet rs=ps.executeQuery();
		  List<Employee> employees=new ArrayList<>();
		  while(rs.next()) {
			  employees.add(employeeFromResultSet(rs));
			  
		  }
		  con.close();
		  return employees;
	  }
	  
	public void updateEmployee(Employee emp)throws Exception{
        Connection con=getConnection();
     PreparedStatement ps=con.prepareStatement("Update "+ TABLE_NAME+ " Set name = ? ,age = ? ,gender = ? ,sal = ?  Where id = ? ");
        // PreparedStatement ps=con.prepareStatement("Update "+ TABLE_NAME+ " age = ?  Where id = ?");
           ps.setInt(5, emp.getId());
           ps.setString(1, emp.getName());
           ps.setInt(2, emp.getAge());
           ps.setString(3, emp.getGender());
           ps.setFloat(4, emp.getSalary());
         //  ps.setObject(3, emp);
        
//        
//         PreparedStatement ps=con.prepareStatement("Update "+ TABLE_NAME+ " Set age = ?  Where id = ?");
//         ps.setInt(1, emp.getId());
//           ps.setInt(3, emp.getAge());
        
            int affected=ps.executeUpdate();
            con.close();
    }
	
	public void deleteEmployee(int id) throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("delete from "+TABLE_NAME+" where id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		con.close();
		
	}
	
	public List<Employee> getEmployees()throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select id,name,age,gender,sal from "+TABLE_NAME);
		ResultSet rs =ps.executeQuery();
		List<Employee> employees =new ArrayList<>();
		while (rs.next()) {
			employees.add(employeeFromResultSet(rs));
		}
		con.close();
		return employees;
		
		
		
		
	}
	
	public Employee getEmployee(int id)throws Exception{
		Connection conn=getConnection();
		PreparedStatement ps = conn.prepareStatement("select id,name,age,gender,sal from "+TABLE_NAME+" where id =?");
		ps.setInt(1, id);
		ResultSet rs =ps.executeQuery();
		if (rs.next()) {
			
		
		Employee e = employeeFromResultSet( rs);
		conn.close();
		return e;
		}else {
			return null;
		}
		
		
		}

	private Employee employeeFromResultSet( ResultSet rs) throws SQLException {
		Employee e=new Employee();
		//e.setId(id);
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setAge(rs.getInt(3));
		e.setGender(rs.getString(4));
		e.setSalary(rs.getFloat(5));
		return e;
	}
	
	public void saveEmployee(Employee e) throws Exception {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into "+TABLE_NAME+" (id,name,age,gender,sal) values (?,?,?,?,?)");
	ps.setInt(1, e.getId());
	ps.setString(2, e.getName());
	ps.setInt(3, e.getAge());
	ps.setString(4, e.getGender());
	ps.setDouble(5, e.getSalary());
	
	int rowsAffected=ps.executeUpdate();
	con.close();
	
		
	}
	
	public int count()  throws Exception {
		Connection con = getConnection();
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("select count(id) from "+TABLE_NAME);
		if(rs.next()) {
			int count=rs.getInt(1);
			con.close();
			return count;
		}else
			con.close();
			return -1;
	}
	
	public Connection getConnection() throws Exception {
		return DriverManager.getConnection("jdbc:oracle:thin:@192.168.102.35:1521/xe","valtrg14", "valtrg14");  // oracle data base
//	    return DriverManager.getConnection("jdbc:mysql:@localhost:3306/xe","username","password");
	}

}
