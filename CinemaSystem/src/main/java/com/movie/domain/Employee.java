package main.java.com.movie.domain;


public class Employee {
    /*==============================================================
	create table employee(
	   user_id int NOT NULL AUTO_INCREMENT,
	   emp_type varchar(20),
	   user_name varchar(20),
	   user_password varchar(20) default '123456',
	   emp_telNum varchar(20),
       address varchar(50),
	   status int,
       bankcarid varchar(20),
       paypwd varchar(20),
	   PRIMARY KEY (`user_id`)
	);

     insert into employee(user_id,emp_type,user_name,user_password,address,status) values('1111','管理员','admin','ynuinfo#777','yunnanuniversity','1');
     insert into employee(user_id,emp_type,user_name,user_password,address,status) values('2001','经理','managerLi','ynu2001','ynu2001@cinema','1');
     insert into employee(user_id,emp_type,user_name,user_password,address,status) values('3001','前台','salemanWang','ynu3001','ynu3001@cinema','1');
	*/
    private int user_id;
    private String emp_type;
    private String emp_name;
    private String emp_telNum;
    private String address;
    private String bankcarid;
    private String paypwd;
    private int status;
    private String user_pwd;

    public Employee() {

    }




    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUser_pwd() {
        return user_pwd;
    }
    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getEmp_type() {
        return emp_type;
    }
    public void setEmp_type(String emp_type) {
        this.emp_type = emp_type;
    }

    public String getEmp_name() {
        return emp_name;
    }
    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_telNum() {
        return emp_telNum;
    }
    public void setEmp_telNum(String emp_telNum) {
        this.emp_telNum = emp_telNum;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankcarid() {
        return bankcarid;
    }
    public void setBankcarid(String bankcarid) {
        this.bankcarid = bankcarid;
    }

    public String getPaypwd() {
        return paypwd;
    }
    public void setPaypwd(String paypwd) {
        this.paypwd = paypwd;
    }

    public void showValue() {
        System.out.println("编号：" + user_id + "\t姓名：" + emp_name);
    }
}
