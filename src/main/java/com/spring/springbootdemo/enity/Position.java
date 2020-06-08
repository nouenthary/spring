package com.spring.springbootdemo.enity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String position;
    @Column
    private String note;
    @ColumnDefault("1")
    private int status;
    @Column
    private Date created_date;

    public Position() {

    }

    public Position(Long id, String position, String note, int status, Date created_date) {
        this.id = id;
        this.position = position;
        this.note = note;
        this.status = status;
        this.created_date = created_date;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", note='" + note + '\'' +
                ", status=" + status +
                ", created_date=" + created_date +
                '}';
    }
}
