package com.ToolMethod;

import java.io.File;

public class GetTheTileName {
   public String  GetTheTileName(String fName) {
        File tempFile =new File( fName.trim());
        String fileName = tempFile.getName();
//        System.out.println("你想要的文件名是:" + fileName);
        return fileName;
    }
}
