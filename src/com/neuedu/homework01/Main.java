package com.neuedu.homework01;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	private Company company;
	
	Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
        
		Main main = new Main();
		main.company = main.loadCompany1();
		main.loadCompany2();
		main.run();

	}
	
	//员工打卡系统的运行方法
	public void run() {
		this.printDakaSys();
		System.out.println("请输入你的选择：");
		int choice = Integer.parseInt(in.nextLine());
		while(choice!=0) {
			if(choice==1) {
				this.signIn();
			}else if(choice==2) {
				this.signOff();
			}else if(choice==3) {
				this.inOffInfo();
			}else {
				System.out.println("输入的数字有误");
			}
			this.printDakaSys();
			System.out.println("请输入你的选择：");
			choice = Integer.parseInt(in.nextLine());
		}
		System.out.println("退出");
	}

	//打印员工打卡系统的菜单
	public void printDakaSys() {
		System.out.println("----员工打卡系统----\n"
				            +"输入0--------退出\n"
				            +"输入1--------签到\n"
				            +"输入2--------签退\n"
				            +"输入3--------查看签到信息\n");
	}
	
	//打印员工信息系统的菜单
	public void printCompanySys() {
		System.out.println("----员工信息系统----\n"
				            +"输入0--------退出添加员工系统，进入员工打卡系统\n"
				            +"输入1--------继续添加员工\n"
				            +"输入2--------删除某员工\n"
				            +"输入3--------修改某员工信息\n"
				            +"-------------------");
	}
	
	//员工信息系统的运行方法，由操作者初始化
	public void loadCompany2() {
		this.printCompanySys();
		System.out.println("请输入你的选择：");
		int choice = Integer.parseInt(in.nextLine());
		while(choice!=0) {
			if(choice==1) {
				this.addEmployee();
			}else if(choice==2) {
				this.deleteEmployee();
			}else if(choice==3) {
				this.modifyEmpInfo();
			}else {
				System.out.println("输入数字有误，请重新输入");
			}
			this.printCompanySys();
			System.out.println("请输入你的选择：");
		    choice = Integer.parseInt(in.nextLine());
		}
		System.out.println("初始化结束，所有人员添加信息成功");
	}
	
	//添加员工
	public void addEmployee() {
		System.out.println("请按“ID(int) name(String)”的格式，输入员工的数据"
				              + "（指导书里写的ID是int类型，所以不能以0开头）");
		try {
			String str = in.nextLine();
			StringTokenizer t=new StringTokenizer(str ," ");
			company.addEmployee(Integer.parseInt(t.nextToken()), t.nextToken());
		}catch(NoSuchElementException e) {
			System.out.println("输入格式错误,添加失败");
		}
	}
	
	//删除员工
	public void deleteEmployee() {
		System.out.println("请输入你想删除的员工的ID：");
		int iD = Integer.parseInt(in.nextLine());
		company.removeEmployee(iD);
	}
	
	//修改员工信息
	public void modifyEmpInfo() {
		System.out.println("请输入你想修改的员工的ID：");
		int iD = Integer.parseInt(in.nextLine());
		Employee e = company.searchE(iD);
		if(e==null) {
			System.out.println("无此ID员工");
			return;
		}
		System.out.println("请按“ID(int) name(String)”的格式，输入修改后员工的信息"
				              + "（指导书里写的ID是int类型，所以不能以0开头）");
		try {
			String str = in.nextLine();
			StringTokenizer t=new StringTokenizer(str ," ");
			int id=Integer.parseInt(t.nextToken());
			String name=t.nextToken();
			e.setID(id);
			e.setName(name);
			System.out.println("ID："+id+" name："+name+" 员工信息修改成功");
		}catch(NoSuchElementException a) {
			System.out.println("输入格式错误，修改失败");
		}
	}
	
	//程序先初始化几个员工
	public Company loadCompany1() {
		Company com = new Company();
		com.addEmployee(111, "张智慧");
		com.addEmployee(222, "李美丽");
		com.addEmployee(333, "王漂亮");
		com.addEmployee(444, "赵帅气");
		System.out.println("已经先初始化好4位员工,现在先进入员工信息系统");
		return com;
	}
	
	//签到
	public void signIn() {
		System.out.println("请输入签到员工ID：");
		int iD = Integer.parseInt(in.nextLine());
		if(company.searchE(iD)!=null) {
			System.out.println("打卡时间为："+company.signIn(iD));
			System.out.println("卡号："+iD+" 打卡成功");
		}else {
			System.out.println("无此ID员工");
		}
	}
	
	//签退
	public void signOff() {
		System.out.println("请输入签退员工ID：");
		int iD = Integer.parseInt(in.nextLine());
		if(company.searchE(iD)!=null) {
			String s = company.signOff(iD);
			if(s!=null) {
				System.out.println("签退时间为："+s);
				System.out.println("卡号："+iD+" 签退成功");
			}
		}else {
			System.out.println("无此ID员工");
		}
	}
	
	//显示签到和签退的信息
	public void inOffInfo() {
		Iterator<Employee> it = company.getList().iterator();
		while(it.hasNext()) {
			Employee e = (Employee)it.next();
			System.out.println("---------------------");
			System.out.println("员工："+e.getName()+" ID："+e.getID());
			System.out.print("签到：");
			if(company.getMap().get(e).getInDate()!=null) {
				System.out.println("今天已签到，签到时间为  "
			                       +company.getMap().get(e).getInDateFormat());
			}else {
				System.out.println("今天未签到");
			}
			System.out.print("签退：");
			if(company.getMap().get(e).getOffDate()!=null) {
				System.out.println("今天已签退，签到时间为  "
			                       +company.getMap().get(e).getOffDateFormat());
			}else {
				System.out.println("今天未签退");
			}
		}
		System.out.println("所有人员的签到与签退信息输出完毕。");
	}
	
}
