/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.em.dao;

import com.leapfrog.em.enitity.Enquiries;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface EnquiryDAO extends GenericDAO<Enquiries>{
    List<Enquiries> getByCourseId(int courseId) throws SQLException,ClassNotFoundException;
}
