/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readwritemsdoc.read.write.msdoc;

import java.io.Serializable;

public class EmployeeDetails implements Serializable {

private static final long serialVersionUID = -943913338383549645L;
private String employeeId;
private String employeeName;
private String qualification;
private String employeeJoiningDate;
private String evaluationPeriod;
private String currentJobTitle;
private String department;
private String supervisor;
private String evaluationDate;


public final String getEmployeeId() {
return employeeId;
}


public final void setEmployeeId(String employeeId) {
this.employeeId = employeeId;
}


public final String getEmployeeName() {
return employeeName;
}

public final void setEmployeeName(String employeeName) {
this.employeeName = employeeName;
}

public final String getQualification() {
return qualification;
}

public final void setQualification(String qualification) {
this.qualification = qualification;
}

public final String getEmployeeJoiningDate() {
return employeeJoiningDate;
}

public final void setEmployeeJoiningDate(String employeeJoiningDate) {
this.employeeJoiningDate= employeeJoiningDate;
}

public final String getEvaluationPeriod() {
return evaluationPeriod;
}


public final void setEvaluationPeriod(String evaluationPeriod) {
this.evaluationPeriod = evaluationPeriod;
}


public final String getCurrentJobTitle() {
return currentJobTitle;
}

public final void setCurrentJobTitle(String currentJobTitle) {
this.currentJobTitle = currentJobTitle;
}

public final String getDepartment() {
return department;
}


public final void setDepartment(String department) {
this.department = department;
}

public final String getSupervisor() {
return supervisor;
}


public final void setSupervisor(String supervisor) {
this.supervisor = supervisor;
}


public final String getEvaluationDate() {
return evaluationDate;
}


public final void setEvaluationDate(String evaluationDate) {
this.evaluationDate= evaluationDate;
}


}
