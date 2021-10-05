package com.example.folhadepagamento.model;

import android.widget.EditText;
import android.widget.TextView;

public class Employee {
    private String EmployeeName;
    private double HoursWorked;
    private double HourValue;
    private double GrossSalary;
    private double IR;
    private double INSS;
    private double FGTS;
    private double NetSalary;

    public Employee(String employeeName, double hoursWorked, double hourValue) {
        EmployeeName = employeeName;
        HoursWorked = hoursWorked;
        HourValue = hourValue;


        GrossSalary = hourValue*hoursWorked;
        IR = CalcularIR(GrossSalary);
        INSS = CalcularINSS(GrossSalary);
        FGTS = GrossSalary*0.08;
        NetSalary = GrossSalary - IR - INSS;
    }
    public double CalcularIR(double GrossSalary){
        if(GrossSalary <= 1372.81){
            IR = 0;
        }
        if(GrossSalary <= 2743.25 ){
            IR = 0.15* GrossSalary;
        }
        else{
            IR = 0.275* GrossSalary;
        }
        return IR;
    }
    public double CalcularINSS(double GrossSalary){
        if(GrossSalary <= 868.29){
            INSS = 0.08* GrossSalary;
        }
        if(GrossSalary <= 1447.14 && GrossSalary >= 868.30){
            INSS = 0.09* GrossSalary;
        }
        if(GrossSalary <= 2894.28 && GrossSalary >= 1447.15){
            INSS = 0.11* GrossSalary;
        }
        else{
            INSS = 318.37;
        }
        return INSS;
    }


    public Employee() {
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public double getHoursWorked() {
        return HoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        HoursWorked = hoursWorked;
    }

    public double getHourValue() {
        return HourValue;
    }

    public void setHourValue(double hourValue) {
        HourValue = hourValue;
    }

    public double getGrossSalary() {
        return GrossSalary;
    }

    public void setGrossSalary(double GrossSalary) {
        this.GrossSalary = GrossSalary;
    }

    public double getIR() {
        return IR;
    }

    public void setIR(double IR) {
        this.IR = IR;
    }

    public double getINSS() {
        return INSS;
    }

    public void setINSS(double INSS) {
        this.INSS = INSS;
    }

    public double getFGTS() {
        return FGTS;
    }

    public void setFGTS(double FGTS) {
        this.FGTS = FGTS;
    }

    public double getNetSalary() {
        return NetSalary;
    }

    public void setNetSalary(double NetSalary) {
        this.NetSalary = NetSalary;
    }

    @Override
    public String toString() {
        return this.EmployeeName;
    }
}
