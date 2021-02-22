package com.example;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.*;

@WebService
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public interface EmployeeService {

    @WebMethod
    Employee getEmployee(@WebParam(name = "id") int id);

    @WebMethod
    Employee updateEmployee(@WebParam(name = "id") int id, @WebParam(name = "first_name") String name);

    @WebMethod
    boolean deleteEmployee(@WebParam(name = "id") int id);

    @WebMethod
    Employee addEmployee(@WebParam(name = "id") int id, @WebParam(name = "first_name") String name);

}
