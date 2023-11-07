package main.java.view.Manager;

import main.java.com.movie.domain.*;
import main.java.com.movie.service.*;

import java.util.Scanner;
public class ManageStudio {
    Scanner scanner = new Scanner(System.in);
    StudioService studioService = new StudioService();
    public void addStudio(){
        Studio studio = new Studio();
        System.out.println("请输入要增加的放映厅名称（如：A厅/B厅/……）：");
        String name = scanner.next();
        studio.setName(name);
        System.out.println("请输入放映厅排数(7-15)：");
        int row = scanner.nextInt();
        studio.setRowCount(row);
        System.out.println("请输入放映厅列数(12-20)：");
        int col = scanner.nextInt();
        studio.setColCount(col);
        System.out.println("请输入放映厅的介绍：");
        String intro = scanner.next();
        studio.setIntroduction(intro);

        studioService.add(studio);
    }

    public void updateStudio(){//根据放映厅ID修改放映厅信息
        Studio studio = new Studio();
        System.out.println("请输入要修改的放映厅ID：");
        int studio_id = scanner.nextInt();
        studio.setID(studio_id);
        System.out.println("请输入修改后的放映厅名称（如：A厅/B厅/……）：");
        String name = scanner.next();
        studio.setName(name);
        System.out.println("请输入修改后的放映厅排数(7-15)：");
        int row = scanner.nextInt();
        studio.setRowCount(row);
        System.out.println("请输入修改后的放映厅列数(12-20)：");
        int col = scanner.nextInt();
        studio.setColCount(col);
        System.out.println("请输入修改后的放映厅的介绍：");
        String intro = scanner.next();
        studio.setIntroduction(intro);

        studioService.modify(studio);
    }


}
