package com.spring.springbootdemo.model;

import java.util.Date;

public class Role {

    private Long id;
    private String role_name;
    private Date start_date;
    private String status;
    private Long user_id;

    public Role() {
    }

    public Role(Long id, String role_name, Date start_date, String status, Long user_id) {
        this.id = id;
        this.role_name = role_name;
        this.start_date = start_date;
        this.status = status;
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                ", start_date=" + start_date +
                ", status='" + status + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
