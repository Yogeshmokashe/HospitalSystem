

package com.psl.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.psl.bean.Doctor;
import com.psl.bean.Hospital;
import com.psl.bean.Speciality;

public class HospitalInformationSystemImpl implements HospitalInformationSystem {

	@Override
	public Set<Hospital> readAllHospital(String fileHospital, String fileDoctor) {
		
		Set<Hospital> hospitalList=new HashSet<Hospital>();
		try  
		{  
		//the file to be opened for reading
		boolean cont=true;
		
		FileInputStream fis = new FileInputStream(fileHospital);       
		ObjectInputStream ois = new ObjectInputStream(fis);
		Hospital hosp=null;
		while(cont)
		{
			
			if(fis.available()!=0)
			{
				hosp = (Hospital)ois.readObject();
				hospitalList.add(hosp);
			}
			else
			{
				cont=false;
			}
		}
		ois.close();
		fis.close();	
		}
		catch(IOException e)  
		{  
		e.printStackTrace();  
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Set<Doctor> docList =new HashSet<Doctor>();
		try  
		{  
		//the file to be opened for reading
		boolean cont=true;
		
		FileInputStream fis = new FileInputStream(fileDoctor);       
		ObjectInputStream ois = new ObjectInputStream(fis);
		Doctor doc=null;
		while(cont)
		{
			
			if(fis.available()!=0)
			{
				doc = (Doctor)ois.readObject();
				doc.setExperience((int)(Math.random()*2000));
				docList.add(doc);
						}
			else
			{
				cont=false;
			}
		}
			ois.close();
			fis.close();
		}
		catch(IOException e)  
		{  
		e.printStackTrace();  
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		for(Hospital h: hospitalList)
		{
			Set<Doctor> tempDoc =new HashSet<Doctor>();
			for(Doctor doc: docList) {
				if(h.getHospitalId()==doc.getHospitalId())
				{
					tempDoc.add(doc);
				}
			}
			h.setSet(tempDoc);
		}
		return hospitalList;
	}

	@Override
	public Set<Doctor> getListOfDoctors(Set<Hospital> hospList) {
		Set<Doctor> docList= new HashSet<Doctor>();
		for(Hospital hosp: hospList)
		{
			for(Doctor doc: hosp.getSet())
			{
				if(doc.getExperience()>=1000)
				{
					docList.add(doc);
				}
			}
		}
		return docList;
	}

	@Override
	public List<Doctor> eligibleForAppointment(Set<Hospital> hospital, Speciality speciality,
			int experienceInDays) {
		List<Doctor> docList =new ArrayList<Doctor>();
		for(Hospital hosp:hospital)
		{
			for(Doctor doc: hosp.getSet())
			{
				if(doc.getExperience()>=1000&&doc.getSpeciality()==speciality&&doc.getExperience()>experienceInDays)
				{
					docList.add(doc);
				}
			}
		}
		
		return docList;
	}

	@Override
	public List<Doctor> getListWithinHospital(Set<Hospital> hospital, int hospitalId, Speciality speciality,
			int experience) {
		Set<Doctor> docList =new HashSet<Doctor>();
		for(Hospital hosp:hospital)
		{
			for(Doctor doc: hosp.getSet())
			{
				if(doc.getHospitalId()==hospitalId&&doc.getExperience()>=1000&&doc.getSpeciality()==speciality&&doc.getExperience()>experience)
				{
					docList.add(doc);
				}
			}
		}
		List<Doctor> finalDocList = new ArrayList<Doctor>();
		for(Doctor doc: docList)
		{
			finalDocList.add(doc);
		}
		

		return finalDocList;
	}

	
}
