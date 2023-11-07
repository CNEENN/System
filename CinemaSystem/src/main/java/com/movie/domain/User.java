package main.java.com.movie.domain;

public class User {
    /*==============================================================
	create table user(
	   user_id int not null auto_increment,
	   user_name varchar(30) not null,
	   user_password varchar(20) not null,
	   user_status varchar(10) DEFAULT '铜牌用户',
	   primary key (user_id)
	)ENGINE=INNODB DEFAULT CHARSET=utf8;
	*/

    /*==============================================================
	create table userdetail(
	   `user_id` int NOT NULL,
        `user_telNum` varchar(20) DEFAULT NULL,
        `user_address` varchar(50) DEFAULT NULL,
        `user_bankcarid` varchar(20) DEFAULT NULL,
        `user_paypwd` varchar(20) DEFAULT NULL,
        `user_sex` varchar(2) DEFAULT NULL,
        `user_age` int DEFAULT '0',
        PRIMARY KEY (`user_id`)
	)ENGINE=INNODB DEFAULT CHARSET=utf8;*/

    private int id = -1;//用户ID
    private String name = null;//用户名
    private String password = null;//密码
    private String status = null;//用户类型?

    private String user_telNum = null;//用户手机号
    private String user_address = null;//用户邮箱
    private String user_bankcarid = null;
    private String user_paypwd = null;
    private String user_sex = null;
    private int user_age = -1;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }




    public String getUser_telNum() {
        return user_telNum;
    }
    public void setUser_telNum(String user_telNum) {
        this.user_telNum = user_telNum;
    }
    public String getUser_address() {
        return user_address;
    }
    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }
    public String getUser_bankcarid() {
        return user_bankcarid;
    }
    public void setUser_bankcarid(String user_bankcarid) {
        this.user_bankcarid = user_bankcarid;
    }
    public String getUser_paypwd() {
        return user_paypwd;
    }
    public void setUser_paypwd(String user_paypwd) {
        this.user_paypwd = user_paypwd;
    }
    public String getUser_sex() {
        return user_sex;
    }
    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }
    public int getUser_age() {
        return user_age;
    }
    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }


    public User() {
        // TODO Auto-generated constructor stub
    }

}
