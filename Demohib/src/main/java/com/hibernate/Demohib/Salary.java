package com.hibernate.Demohib;

import jakarta.persistence.*;

@Entity
@Table(name = "salary")
public class Salary {
    @Id
    private int empId;
    private double amount;

    // Getters and setters
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
