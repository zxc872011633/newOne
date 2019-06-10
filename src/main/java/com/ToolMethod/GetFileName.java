package com.ToolMethod;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class GetFileName {
    // 传递参数 一个路径,一个集合(用于储存所有文件名)
    public static void getAllFileName(String path, ArrayList<String> fileName) {
        File file = new File(path);
        File[] files = file.listFiles(); //将文件夹的对象转化为list数组
        String[] names = file.list(); //定义一个names集合储存文件夹下的名字
        if (names != null)			//当文件名不为空的时候执行
            fileName.addAll(Arrays.asList(names));
        for (File a : files) {
            if (a.isDirectory()) { //如果存在文件夹 递归
                getAllFileName(a.getAbsolutePath(), fileName);
            }
        }
    }
}
