/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.em.daoimpl;

import com.leapfrog.em.constant.SQLConstant;
import com.leapfrog.em.dao.EnquiryDAO;
import com.leapfrog.em.db.util.DbConnection;
import com.leapfrog.em.enitity.Courses;
import com.leapfrog.em.enitity.Enquiries;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class EnquiryDAOImpl implements EnquiryDAO {
    DbConnection db=new DbConnection();

    @Override
    public List<Enquiries> getAll() throws SQLException, ClassNotFoundException {
        List<Enquiries> enquiryList=new ArrayList<>();
        db.open();
         db.initStatement(SQLConstant.Enquiry_GETALL);
        ResultSet rs=db.executeQuery();
        while(rs.next()){
            Enquiries enquiry=new Enquiries();
            enquiry.setId(rs.getInt("enquiry_id"));
            enquiry.setFirstName(rs.getString("first_name"));
            enquiry.setLastName(rs.getString("last_name"));
            enquiry.setEmail(rs.getString("email"));
            enquiry.setContact(rs.getString("contact_no"));
            enquiry.setType(rs.getString("enquiry_type"));
            enquiry.setStatus(rs.getString("enquiry_status"));
            enquiryList.add(enquiry);
                
            
        }
        return enquiryList;
        
    }

    @Override
    public Enquiries getById(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Enquiries t) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(Enquiries e) throws SQLException, ClassNotFoundException {
        db.open();
        PreparedStatement stmt=db.initStatement(SQLConstant.Enquiry_INSERT);
        stmt.setString(1, e.getFirstName());
        stmt.setString(2, e.getLastName());
        stmt.setString(3,e.getEmail());
        stmt.setString(4, e.getContact());
         stmt.setInt(5, e.getCourse().getId());
        stmt.setString(6, e.getMessage());
       
        stmt.setString(7,e.getType());
        stmt.setString(8, e.getStatus());
        int result=stmt.executeUpdate();
        db.close();
        return result;
        
    }

    @Override
    public List<Enquiries> getByCourseId(int courseId) throws SQLException, ClassNotFoundException {
        List<Enquiries> enquiryList=new ArrayList<>();
        db.open();
        PreparedStatement stmt=db.initStatement(SQLConstant.Enquiry_GETBYCOURSEID);
        stmt.setInt(1, courseId);
        ResultSet rs=db.executeQuery();
        while(rs.next()){
            Enquiries enquiry=new Enquiries();
            enquiry.setId(rs.getInt("enquiry_id"));
            enquiry.setFirstName(rs.getString("first_name"));
            enquiry.setLastName(rs.getString("last_name"));
            enquiry.setEmail(rs.getString("email"));
            enquiry.setContact(rs.getString("contact_no"));
            enquiry.setType(rs.getString("enquiry_type"));
            enquiry.setStatus(rs.getString("enquiry_status"));
            Courses course=new Courses();
            course.setId(rs.getInt("course_id"));
            course.setName(rs.getString("course_name"));
            enquiry.setCourse(course);
            
            enquiryList.add(enquiry);
                
            
        }
        return enquiryList;
        
    }
    
}
