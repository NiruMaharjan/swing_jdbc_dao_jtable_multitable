/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.em;

import com.leapfrog.em.dao.CourseDAO;
import com.leapfrog.em.dao.EnquiryDAO;
import com.leapfrog.em.daoimpl.CourseDAOImpl;
import com.leapfrog.em.daoimpl.EnquiryDAOImpl;
import com.leapfrog.em.enitity.Courses;
import com.leapfrog.em.enitity.Enquiries;
import com.leapfrog.em.ui.EnquiryUI;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class Program {
    public static void main(String[] args) {
       /// CourseDAO courseDAO=new CourseDAOImpl();
        EnquiryDAO enquiryDAO=new EnquiryDAOImpl();
        //insert
       /* try{
        courseDAO.insert(new Courses(0,"Python and Django","Python and Django",20000,true));
        }
        catch(ClassNotFoundException |SQLException ex){
            System.out.println(ex.getMessage());
        }*/
        
        //update
       /* try{
        courseDAO.update(new Courses(10,"node js","node js",20000,true));
        }
        catch(ClassNotFoundException|SQLException ex){
            System.out.println(ex.getMessage());
        }*/
        //delete
       /* try{
            courseDAO.delete(5);
        }
        catch(ClassNotFoundException|SQLException ex){
            System.out.println(ex.getMessage());
        }*/
        
        //get by id
        /*try{
        Courses c=courseDAO.getById(10);
            System.out.println(c.getName());
        }
        catch(ClassNotFoundException |SQLException ex){
            System.out.println(ex.getMessage());
        }*/
        //get all
       /* try{
        for(Courses c:courseDAO.getAll()){
            System.out.println(c.getName());
            System.out.println(c.getId());
        }
        }
        catch(ClassNotFoundException|SQLException ex){
            System.out.println(ex.getMessage());
        }*/
        //enquiries insert
        /*try{
        Enquiries enquiry=new Enquiries();
        enquiry.setFirstName("Niru");
        enquiry.setLastName("Maharjan");
        enquiry.setEmail("nmaharjan417@gmail.com");
        enquiry.setContact("9849274555");
        enquiry.setCourse(new Courses(2,"","",0,true));
        enquiry.setMessage("i am very interested in java");
        enquiry.setType("W");
        enquiry.setStatus("Pe");
        enquiryDAO.insert(enquiry);
        
        }
        catch(ClassNotFoundException|SQLException ex){
            System.out.println(ex.getMessage());
        }*/
       /* try{
       for(Enquiries e:enquiryDAO.getByCourseId(2)){
           System.out.println(e.getFirstName());
           System.out.println(e.getLastName());
           System.out.println(e.getCourse().getName());
        }
        }
        catch(ClassNotFoundException|SQLException ex){
            System.out.println(ex.getMessage());
    }*/
        EnquiryUI enquiryUI=new EnquiryUI();
        enquiryUI.setVisible(true);
    
}
}