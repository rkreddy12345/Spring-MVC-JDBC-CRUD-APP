package com.cglia.ems.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cglia.ems.dao.EmployeeDAO;
import com.cglia.ems.db.util.DataBaseUtil;
import com.cglia.ems.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Override
	public Integer save(Employee employee) {
	    final String query = "INSERT INTO CG_EMS_EMPLOYEE (NAME, EMAIL, DEPARTMENT, SALARY) values (?,?,?,?)";
	    Integer id=0;
	    try (
	        Connection con = DataBaseUtil.getConnection();
	        PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	    ) {
	        ps.setString(1, employee.getName());
	        ps.setString(2, employee.getEmail());
	        ps.setString(3, employee.getDept());
	        ps.setDouble(4, employee.getSalary());
	        int count = ps.executeUpdate();
	        if (count != 0) {
	            try (ResultSet rs = ps.getGeneratedKeys()) {
	                if (rs.next()) {
	                    id = rs.getInt(1);
	                    System.out.println("Employee saved with id=" + id);
	                }
	            }
	        } else {
	            System.out.println("Employee save failed");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return id;
	}


	public Employee getById(Integer id) {
		final String query="SELECT * FROM CG_EMS_EMPLOYEE WHERE ID = ?";
		Employee emp=null;
		try(Connection con=DataBaseUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query)){
			stmt.setInt(1, id);
			try(ResultSet rs=stmt.executeQuery()){
				if(rs.next()) {
					emp=new Employee();
					emp.setId(rs.getInt("ID"));
					emp.setName(rs.getString("NAME"));
					emp.setEmail(rs.getString("EMAIL"));
					emp.setDept(rs.getString("DEPARTMENT"));
					emp.setSalary(rs.getDouble("SALARY"));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	public int update(Employee employee) {
		final String query="UPDATE CG_EMS_EMPLOYEE SET NAME = ?,  EMAIL = ?, DEPARTMENT = ?, SALARY = ? WHERE ID = ?";
		int count=0;
		try(Connection con=DataBaseUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query)){
			stmt.setString(1, employee.getName());
			stmt.setString(2, employee.getEmail());
			stmt.setString(3, employee.getDept());
			stmt.setDouble(4, employee.getSalary());
			stmt.setInt(5, employee.getId());
			count=stmt.executeUpdate();
			if(count!=0) {
				System.out.println("Employee with ID:"+employee.getId()+" is updated");
			}else {
				System.out.println("update failed.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public int deleteById(Integer id) {
		final String query="DELETE FROM CG_EMS_EMPLOYEE WHERE id=?";
		int count=0;
		try(Connection con=DataBaseUtil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query);	){
			stmt.setInt(1, id);
			count=stmt.executeUpdate();
			
			if(count!=0) {
				System.out.println("Employee with ID:"+id+" is deleted");
			}else {
				System.out.println("Deletion failed.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return count;

	}

	public List<Employee> getAll() {
		final String query="SELECT * FROM CG_EMS_EMPLOYEE";
		List<Employee> empList=new ArrayList<>();
		
		try(Connection con=DataBaseUtil.getConnection();
			Statement stmt=con.createStatement();	){
			boolean areAnyRecords=stmt.execute(query);
			if(areAnyRecords) {
				try(ResultSet rs=stmt.getResultSet()){
					if(rs!=null) {
						while(rs.next()) {
							Employee emp=new Employee();
							emp.setId(rs.getInt("ID"));
							emp.setName(rs.getString(2));
							emp.setEmail(rs.getString(3));
							emp.setDept(rs.getString(4));
							emp.setSalary(rs.getDouble(5));
							empList.add(emp);
						}
					}
				}
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

}
