package com.valtech.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class EmployeeDAOTest {

	@Test
	public void test() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		Connection conn =dao.getConnection();
		conn.close();}
		
//@Test
//	public void testcount() throws Exception{
//		EmployeeDAO dao = new EmployeeDAO();
//		assertEquals(5, dao.count());
//		
//	
//	}
//	
//	@Test
//	public void testsave() throws Exception{
//		EmployeeDAO dao = new EmployeeDAO();
//		int count=dao.count();
//		dao.saveEmployee(new Employee(15,"Three",27,"F",1000));
//	assertEquals(count+1, dao.count());
//		
//	}
	
	@Test
	public void testGetEmployee() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		Employee e=dao.getEmployee(12);
		assertEquals(12, e.getId());
		assertEquals(22, e.getAge());
	}
	
	@Test
	public void testGetEmployees() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
	
		assertEquals(dao.count(),dao.getEmployees().size());
		
	}
	@Test
	public void testdelete() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		int count=dao.count();
		dao.saveEmployee(new Employee(16,"Three",27,"F",1000));
	    assertEquals(count+1, dao.count());
	    dao.deleteEmployee(16);
	    assertEquals(count, dao.count());
	    
		
		
	}
	@Test
	public void testupdate() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		dao.updateEmployee(new Employee(11,"New Three",25,"M",1230));
		Employee e = dao.getEmployee(11);
	    assertEquals(e.getId(),11);
	    assertEquals(e.getName(), "New Three");
	    assertEquals(25, e.getAge());
	    assertEquals("M", e.getGender());
	    assertEquals(1230, e.getSalary(),0.00001);
	    
	    
	
	
	}
	
	@Test
    public void testGetEmployeesByAge()throws Exception {
        EmployeeDAO dao=new EmployeeDAO();
        assertEquals(1, dao.getEmployeesByAge(22).size());
    }
	
	@Test
    public void testGetEmployeesBtwAge()throws Exception {
        EmployeeDAO dao=new EmployeeDAO();
        assertEquals(1, dao.getEmployeesBtwAge(21,23).size());
    }
	@Test
	public void testSalaryGreaterthan()throws Exception {
		EmployeeDAO dao=new EmployeeDAO();
		assertEquals(2, dao.getSalarygreaterthan(3000).size());
	}
	
	@Test
	public void testSalaryLessthan()throws Exception {
		EmployeeDAO dao=new EmployeeDAO();
		assertEquals(2, dao.getSalarylessthan(3000).size());
	}
	
	@Test
	public void testmalecount()throws Exception {
		EmployeeDAO dao=new EmployeeDAO();
		assertEquals(3, dao.getMale().size());
	}
	@Test
	public void testfemalecount()throws Exception {
		EmployeeDAO dao=new EmployeeDAO();
		assertEquals(2, dao.getFeMale().size());
	}
	@Test
	public void testOtherscount()throws Exception {
		EmployeeDAO dao=new EmployeeDAO();
		assertEquals(0, dao.getOthers().size());
	}
	
	
	
	
	
	
	
}
