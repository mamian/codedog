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
            


            try {
                org.apache.commons.io.FileUtils.writeStringToFile(new File(file.getAbsolutePath()+"_bak"),result.toString(),"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return file;
    }

}
