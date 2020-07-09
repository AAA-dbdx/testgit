package com.neuedu.homework01;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Company implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Employee> list;
	private Map<Employee,DakaInfo> map;
	
	public Company() {
		this.list = new ArrayList<>();
		this.map = new HashMap<>();
	}
	
	//新增人员，到list和map中
	public void addEmployee(int iD,String name) {
		if(this.searchE(iD)==null) { 
			list.add(new Employee(iD,name));
			map.put(this.searchE(iD), new DakaInfo(iD));
			System.out.println("ID："+iD+" name："+name+"  的人员添加成功");
		}else {
			System.out.println("该成员已被添加（或ID已被使用）");
		}
	}
	
	//删除人员，只要删除list中的员工，便可删除map中的员工
	public void removeEmployee(int iD) {
		if(this.searchE(iD)!=null) {           
			list.remove(this.searchE(iD));
			System.out.println("该人员删除成功");
		}else {
			System.out.println("无此ID员工");
		}
		
    }
	
	//显示人员信息
	public void employeeInfo(int iD) {
		if(this.searchE(iD)!=null) {             
			System.out.println("该人员的信息为：");
			System.out.println(this.searchE(iD).toString());
		}else {
			System.out.println("无此ID员工");
		}
	}
	
	//查找人员
		public Employee searchE(int iD) {
			Iterator<Employee> it = list.iterator();
			while(it.hasNext()) {
				Employee e = (Employee)it.next();
				if(iD==e.getID()) {
					return e;
				}
			}
			return null;
		}
	
	public String signIn(int iD) {
		DakaInfo d = map.get(this.searchE(iD));
		if(d.getInDate()!=null) {
			System.out.println("今天已经打过卡了，此操作将会导致时间的覆盖");
			d.setInDate();
		}else {
			d.setInDate();
		}
		return d.getInDateFormat();
	}
	
	public String signOff(int iD) {
		DakaInfo d = map.get(this.searchE(iD));
		Date s1 = d.getInDate();
		if(s1!=null) {
			if(d.getOffDate()!=null) {
				System.out.println("今天已经签退了，此操作将会导致时间的覆盖");
				d.setOffDate();
			}else {
				d.setOffDate();
			}
		}else {
			System.out.println("卡号："+iD+"  今天还没有签到，无法签退");
			return null;
		}
		return d.getOffDateFormat();
	}
	
	public List<Employee> getList() {
		return this.list;
	}
	
	public Map<Employee,DakaInfo> getMap() {
		return this.map;
	}
		
}
