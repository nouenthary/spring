package com.spring.springbootdemo.model;

import java.util.Date;

public class Department {

    private Long id;
    private String department_name;
    private Date created_date;
    private String status;

    public Department(Long id, String department_name, Date created_date, String status) {
        this.id = id;
        this.department_name = department_name;
        this.created_date = created_date;
        this.status = status;
    }

    public Department() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", department_name='" + department_name + '\'' +
                ", created_date=" + created_date +
                ", status='" + status + '\'' +
                '}';
    }
}
