/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.em.constant;

/**
 *
 * @author Lenovo
 */
public class SQLConstant {
    public final static String COURSE_INSERT="INSERT INTO" + TableConstant.COURSE_TABLE+"(course_name,course_description,fees,status)VALUES(?,?,?,?)";
    public final static String COURSE_UPDATE="UPDATE " +TableConstant.COURSE_TABLE + " SET course_name=?,course_description=?,fees=?,status=? where course_id=?";
    public final static String COURSE_DELETE="DELETE FROM "+TableConstant.COURSE_TABLE+" WHERE course_id=?";
    public final static String COURSE_SELECT="SELECT *FROM "+TableConstant.COURSE_TABLE;
    public final static String COURSE_SELECTBYID="SELECT *FROM "+TableConstant.COURSE_TABLE+" WHERE course_id=?";
    
    public final static String Enquiry_INSERT="INSERT INTO " + TableConstant.ENQUIRY_TABLE+"(first_name,last_name,email,contact_no,course_id,message,enquiry_type,enquiry_status)VALUES(?,?,?,?,?,?,?,?)";
       public final static String Enquiry_GETALL="SELECT *FROM "+TableConstant.ENQUIRY_TABLE;
    public final static String Enquiry_GETBYCOURSEID="SELECT *FROM "+TableConstant.ENQUIRY_TABLE + " enquiries JOIN "+TableConstant.COURSE_TABLE+ " courses ON enquiries.course_id=courses.course_id WHERE enquiries.course_id=?";
 
}
