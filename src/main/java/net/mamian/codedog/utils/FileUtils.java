package net.mamian.codedog.utils;

import net.mamian.codedog.enums.FileType;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2017-01-13 11:31
 * @copyright ©2017 马面 All Rights Reserved
 */
public class FileUtils {

    public static FileType getType(String path){
        int startIndex = path.lastIndexOf(".");
        switch (path.substring(startIndex)){
            case ".java":
                return FileType.JAVA;
            default:
                return FileType.UNKNOWN;
        }
    }

    /**
     * 按行读取文件
     * */
    public static List<String> readLine(File file){
        try {
            return org.apache.commons.io.FileUtils.readLines(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 读取文件
     * */
    public static String readFileToString(File file){
        try {
            return org.apache.commons.io.FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
