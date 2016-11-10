/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.em.daoimpl;

import com.leapfrog.em.constant.SQLConstant;
import com.leapfrog.em.dao.CourseDAO;
import com.leapfrog.em.db.util.DbConnection;
import com.leapfrog.em.enitity.Courses;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class CourseDAOImpl implements CourseDAO {
    DbConnection db=new DbConnection();
    private Courses course=null;

    @Override
    public List<Courses> getAll() throws SQLException, ClassNotFoundException {
        List<Courses> courseList=new ArrayList<>();
        db.open();
        PreparedStatement stmt=db.initStatement(SQLConstant.COURSE_SELECT);
        ResultSet rs=stmt.executeQuery();
        while(rs.next()){
            course=new Courses();
            course.setId(rs.getInt("course_id"));
            course.setName(rs.getString("course_name"));
            course.setDescription(rs.getString("course_description"));
            course.setFees(rs.getInt("fees"));
            course.setStatus(rs.getBoolean("status"));
            courseList.add(course);
        }
        return courseList;
        
    }

    @Override
    public Courses getById(int id) throws SQLException, ClassNotFoundException {
        db.open();
        PreparedStatement stmt=db.initStatement(SQLConstant.COURSE_SELECTBYID);
        stmt.setInt(1, id);
        ResultSet rs=stmt.executeQuery();
        while(rs.next()){
            course=new Courses();
            course.setId(rs.getInt("course_id"));
            course.setName(rs.getString("course_name"));
            course.setDescription(rs.getString("course_description"));
            course.setFees(rs.getInt("fees"));
            course.setStatus(rs.getBoolean("status"));  
            
        }
        return course;
        
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        db.open();
        PreparedStatement stmt=db.initStatement(SQLConstant.COURSE_DELETE);
        stmt.setInt(1, id);
        int result=stmt.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public int update(Courses c) throws SQLException, ClassNotFoundException {
        db.open();
        PreparedStatement stmt=db.initStatement(SQLConstant.COURSE_UPDATE);
        stmt.setString(1,c.getName());
        stmt.setString(2, c.getDescription());
        stmt.setInt(3,c.getFees());
        stmt.setBoolean(4,c.isStatus());
        stmt.setInt(5, c.getId());
        int result=stmt.executeUpdate();
        db.close();
        return result;
        
    }

    @Override
    public int insert(Courses c) throws SQLException, ClassNotFoundException {
        db.open();
        
        PreparedStatement stmt=db.initStatement(SQLConstant.COURSE_INSERT);
        stmt.setString(1, c.getName());
        stmt.setString(2, c.getDescription());
        stmt.setInt(3, c.getFees());
        stmt.setBoolean(4, c.isStatus());
        int result=stmt.executeUpdate();
        db.close();
        return result;
    
    }
   
    
}
