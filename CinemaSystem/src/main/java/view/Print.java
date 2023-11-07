package main.java.view;

public class Print {
    public void printUserSelect(){//用户身份选择
        System.out.println("=============用户身份选择==============");
        System.out.println("1.管理员  2.经理  3.前台  4.顾客  5.退出 ");
        System.out.println("====================================");
    }

    public void printLoginMenu() { //打印登录注册菜单
        System.out.println("===============用户登录===============");
        System.out.println("1. 登录      2. 注册      3. 退出      ");
        System.out.println("====================================");
    }

    public void printUserManageByAdmin(){//打印管理员的用户管理菜单
        System.out.println("============管理员用户管理==========");
        System.out.println("1.列出员工信息        2.删除员工信息  ");
        System.out.println("3.查询员工信息        4.增加员工信息  ");
        System.out.println("5.修改员工信息        6.退出        ");
        System.out.println("=================================");
    }

    public void printManagerFunction(){//打印经理功能菜单
        System.out.println("=============经理功能选择==============");
        System.out.println("1.密码管理     2.影片管理     3.放映厅管理");
        System.out.println("4.排片管理     5.消费者管理   6.退出     ");
        System.out.println("=====================================");
    }

    public void printPwdManage(){//打印密码管理菜单
        System.out.println("===============经理密码管理================");
        System.out.println("1.修改自身密码    2.重置消费者的密码    3.退出 ");
        System.out.println("========================================");
    }


    public void printMovieManage(){//打印影片管理菜单
        System.out.println("=============经理影片管理==============");
        System.out.println("1.列出所有影片信息     2.添加影片信息     ");
        System.out.println("3.修改影片信息        4.删除影片信息     ");
        System.out.println("5.查询影片信息        6.退出           ");
        System.out.println("====================================");
    }

    public void printStudioManage(){//打印放映厅管理菜单
        System.out.println("==============放映厅管理=============");
        System.out.println("1.增加放映厅   2.修改放映厅  3.删除放映厅");
        System.out.println("4.列出所有放映厅信息         5.退出    ");
        System.out.println("==================================");
    }

    public void printScheduleManage(){//打印排片管理菜单
        System.out.println("============经理排片管理=============");
        System.out.println("1.增加场次     2.修改场次   3.删除场次 ");
        System.out.println("4.列出所有场次信息          5.退出    ");
        System.out.println("==================================");
    }
    public void printUserManageByManager(){//打印经理的用户管理菜单
        System.out.println("=============经理用户管理==============");
        System.out.println("1.列出所有用户信息       2.查询用户信息   ");
        System.out.println("3.增加用户基本信息  4.删除用户信息  5.退出 ");
        System.out.println("====================================");
    }


    public void printSalemanFunction(){//打印前台功能菜单
        System.out.println("===============前台功能选择================");
        System.out.println("1.列出所有影片信息           2.列出所有场次信息");
        System.out.println("3.列出指定电影和场次的信息   4.售票功能   5.退出");
        System.out.println("=========================================");
    }

    public void printCustomerFunction(){//打印顾客功能菜单
        System.out.println("==================顾客功能选择================");
        System.out.println("1.密码管理   2.查看电影放映信息    3.购票   4.取票");
        System.out.println("5.查看购票历史      6.完善个人详细信息      7.退出");
        System.out.println("============================================");
    }



}
