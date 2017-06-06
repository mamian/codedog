package net.mamian.codedog.encrypt.strategy;

import net.mamian.codedog.constants.JavaWordConstant;
import net.mamian.codedog.utils.EncryptCacheMap;
import net.mamian.codedog.utils.FileUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 简单加密策略
 *
 * Created by zhaobs on 17/1/22.
 */
public class SimpleStrategy implements IStrategy {

    /**
     * 加密后的新文件
     *
     * @param file 待加密的文件
     * */
    public static File encrypt(File file){
        if(!file.exists() || !file.isFile()){//文件不存在或不是文件类型
            return null;
        }

        //待加密的文件，按行解析
        List<String> lineList = FileUtils.readLine(file);
        if(CollectionUtils.isEmpty(lineList)){//文件内容为空
            return file;
        }

        //import进的类、自定义类、同目录下不用导入的自定义类
        Set<String> importClassSet = new HashSet<>();
        for(File brotherFile : file.getParentFile().listFiles()){//此文件的同目录下的其他文件
            String brotherClassName = brotherFile.getName().replace(".java","");
            importClassSet.add(brotherClassName);
        }


        if(CollectionUtils.isNotEmpty(lineList)){
            StringBuilder result = new StringBuilder();
            String todo;//待加密的字符串

            boolean multiZhushi = false;//是否还处在多行注释的作用范围内
            boolean yinhao = false;//是否还处在引号的作用范围内
            for(String line : lineList){
                result.append("\n");

                String newLine = "";//此行加密后的内容

                if(StringUtils.isBlank(line.trim())){//空行
                    result.append(line);
                    continue;
                }

                //注释解析-start------------------
                if(line.trim().startsWith("//")){//单行注释直接跳过
                    continue;
                }

                if(line.trim().startsWith("/*")){//多行注释开始
                    multiZhushi = true;
                    continue;
                }

                if(line.trim().endsWith("*/")){//多行注释结束
                    multiZhushi = false;
                    continue;
                }

                if(multiZhushi){//多行注释直接跳过
                    continue;
                }
                //注释解析-end------------------


                //package解析-start------------------
                if(line.trim().startsWith("package")){
                    result.append(line);
                    continue;
                }
                //package解析-end------------------



                //import解析-start------------------
                if(line.trim().startsWith("import ")){//识别导入的类
                    line = line.replace(";","");
                    int classNameIndex = line.lastIndexOf(".");
                    importClassSet.add(line.substring(classNameIndex+1));
                    result.append(line);
                    continue;
                }
                //import解析-end------------------


                //public解析-start------------------
                if(line.trim().startsWith("public ")){//
                    result.append(line);
                    continue;
                }
                //public解析-end------------------




                for(String item : line.split(" ")){//不能用空格作区分，需按字符逐字符解析才行，因为方法中的括号等按空格区分不出来
                    processItem(item,importClassSet,result);
                }
            }


            try {
                org.apache.commons.io.FileUtils.writeStringToFile(new File(file.getAbsolutePath()+"_bak"),result.toString(),"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return file;
    }

    /**
     * 处理被空格分隔的词
     *
     * @param item 待处理的词
     * @param importClassSet 导入的类名称
     * @param result 存储分析结果
     * */
    private static void processItem(String item, Set<String> importClassSet, StringBuilder result){


    }

}
