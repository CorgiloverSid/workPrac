package org.example;


import javax.annotation.processing.SupportedSourceVersion;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Admin {

    private String role;
    private int adminId;
    public Admin(String role, int adminId) {
        this.role = role;
        this.adminId = adminId;
    }

    public Admin() {

    }

    @Override
    public String toString() {
        return "Admin{" +
                "role='" + role + '\'' +
                ", adminId=" + adminId +
                '}';
    }
}
