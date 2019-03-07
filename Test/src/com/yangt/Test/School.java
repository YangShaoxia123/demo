package com.yangt.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import com.yangt.dome.Student;

public class School {
List<Student> list = new ArrayList<>();
	
	public List<Student> seek(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/school?serverTimezone=GMT%2B8";
			Connection conn = DriverManager.getConnection(url, "root", "1997");
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM student");
			
			while(rs.next()){
				Student st = new Student();
				st.setStuid(rs.getInt("stu_no"));
				st.setStuame(rs.getString("stu_name"));
				
				st.setStusex(rs.getString("stu_sex"));
				st.setEmail(rs.getString("stu_email"));
				list.add(st);
			}
			rs.close();
			stmt.close();
			conn.close();
			
			return list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int delete(int stuNo){
		//��ȡ���ݿ�����
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.��ȡ����
			String url = "jdbc:mysql://localhost:3306/school?serverTimezone=GMT%2B8";
			Connection conn = DriverManager.getConnection(url, "root", "1997");
			//3.����һ��statement
			Statement stmt = conn.createStatement();
			
			int i = stmt.executeUpdate("DELETE FROM student WHERE stu_no="+stuNo);
			
			return i;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
