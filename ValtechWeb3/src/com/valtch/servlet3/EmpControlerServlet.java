package com.valtch.servlet3;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.valtech.dao.Employee;
import com.valtech.dao.EmployeeDAO;
@WebServlet(urlPatterns= {"/empctrl"})

public class EmpControlerServlet extends HttpServlet {
	
	private EmployeeDAO dao;
	@Override
	public void init() throws ServletException {
		dao=new EmployeeDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String submit=req.getParameter("submit");
		try {
			if("new Employee".equals(submit)) {
				req.getRequestDispatcher("CreateEmp.jsp").forward(req, resp);
				return;
			}
		if("save".equals(submit)) {
			Employee e=new Employee();
			e.setId(dao.getNextValidId());
			e.setName(req.getParameter("name"));
			e.setAge(Integer.parseInt(req.getParameter("age")));
			e.setGender(req.getParameter("gender"));
			e.setSalary(Float.parseFloat(req.getParameter("salary")));
			dao.saveEmployee(e);
			
			
		}
		if("updateEmp".equals(submit)) {
            //dao=new EmployeeDAO();
            Employee e= new Employee();
            int id = Integer.parseInt(req.getParameter("id"));
            e.setId(id);
            e.setName(req.getParameter("name"));
            e.setAge(Integer.parseInt(req.getParameter("age")));
            e.setGender(req.getParameter("gender"));
            e.setSalary(Float.parseFloat(req.getParameter("salary")));
            dao.updateEmployee(e);
            
        }
		List<Employee> emps=dao.getEmployees();
		req.setAttribute("emps", dao.getEmployees());
		req.getRequestDispatcher("emps.jsp").forward(req, resp);
	}catch (Exception ex) {
		throw new RuntimeException(ex);
	}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String empId=req.getParameter(("empId"));
			String submit=req.getParameter("submit");
			
			if(empId==null) {
				List<Employee> emps=dao.getEmployees();
				req.setAttribute("emps", emps);
				req.getRequestDispatcher("emps.jsp").forward(req, resp);
				return;
			
			}
			
			
			int id=Integer.parseInt(req.getParameter("empId"));
			if("update".equals(submit)) {
                Employee e = dao.getEmployee(id);
                req.setAttribute("e", e);
                req.getRequestDispatcher("update.jsp").forward(req,resp);
                return;
            }
		if("delete".equals(submit)) {
			dao.deleteEmployee(id);
			List<Employee> emps=dao.getEmployees();
			req.setAttribute("emps", emps);
			req.getRequestDispatcher("emps.jsp").forward(req, resp);
			return;
			
		}
			Employee e= dao.getEmployee(id);
			req.setAttribute("e", e);
			req.getRequestDispatcher("emp.jsp").forward(req, resp);
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		
		
	}

}
