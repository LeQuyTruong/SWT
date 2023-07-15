/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author asus
 */
public class Notification {
    // createdBy
    // Title
    // Status
    // Message
    // Time
    
    private int createdBy;
    private String title;
    private String status;
    private  String message;
    private String time;
    private String icon;

    public Notification(int createdBy, String title, String status, String message, String time, String icon) {
        this.createdBy = createdBy;
        this.title = title;
        this.status = status;
        this.message = message;
        this.time = time;
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

   

    
    public int getCreatedBy() {
        return createdBy;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Notification{" + "createdBy=" + createdBy + ", title=" + title + ", status=" + status + ", message=" + message + ", time=" + time + ", icon=" + icon + '}';
    }

   

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
}
