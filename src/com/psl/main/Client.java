



package com.psl.main;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.psl.bean.Doctor;
import com.psl.bean.Hospital;
import com.psl.bean.Speciality;
import com.psl.util.HospitalInformationSystem;
import com.psl.util.HospitalInformationSystemImpl;


public class Client {

	public static void main(String[] args) {
		HospitalInformationSystemImpl hospInfo = new HospitalInformationSystemImpl();
		Set<Hospital> hospList= hospInfo.readAllHospital("hospital.ser","doctor.ser");
		
		System.out.println(hospList);
		
		Set<Doctor> docList=hospInfo.getListOfDoctors( hospList);
		System.out.println(docList);
		List<Doctor> eligibleDocList=hospInfo.eligibleForAppointment(hospList, Speciality.Pediatric, 1200);
		System.out.println(eligibleDocList);
		
		List<Doctor> finalDocList=hospInfo.getListWithinHospital(hospList, 2013, Speciality.Pediatric, 1200);
		System.out.println(finalDocList);
	}
}





