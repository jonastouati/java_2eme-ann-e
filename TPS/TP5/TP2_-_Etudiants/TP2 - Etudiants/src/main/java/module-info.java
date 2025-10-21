open module sio.tp2 {
//    requires javafx.controls;
//    requires javafx.fxml;
//    requires jakarta.persistence;
//    requires org.hibernate.orm.core;
//
//    opens sio.tp1.entities;
//    opens sio.tp1 to javafx.fxml;
//    exports sio.tp1;
//    opens sio.tp1.dto;

    requires javafx.controls;
    requires javafx.fxml;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.beans;
    requires spring.data.jpa;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires spring.data.commons;
//    requires jakarta.transaction;
//    requires spring.tx;
}