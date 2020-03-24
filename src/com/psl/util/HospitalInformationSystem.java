
/*
 * Author :Snehal Patil,Nagpur
 * Email  :snehalpatil2011@gmail.com
 * 
 * Disclaimer :The projects questions does not have any resemblance
 *  			with the actual exam.Though they are on the same pattern 
 *  			that I have experienced in practice assignmets.It contains the ".rtf file" 
 *  			which describes the problem statement .
 *  
 *  In case of violation of Any privacy or rights please inform
 *  
 *  
 *                "Practice makes a man perfect.................... and women too"
 */




package com.psl.util;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.psl.bean.Doctor;
import com.psl.bean.Hospital;
import com.psl.bean.Speciality;

public interface HospitalInformationSystem {
	Set<Hospital> readAllHospital(String fileHospital,String fileDoctor);
	Set<Doctor> getListOfDoctors(Set<Hospital> Set);//this will return a list of doctors more than 1000 days of experience without repetition
	List<Doctor> eligibleForAppointment(Set<Hospital> Set,Speciality speciality,int experienceInDays);//create list of doctor according to experience and specialization without experience
	List<Doctor> getListWithinHospital(Set<Hospital> Set,int hospitalId,Speciality speciality,int experience);
	
}
