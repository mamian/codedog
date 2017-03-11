package net.mamian.codedog.scan;

import net.mamian.codedog.analyse.Analyzer;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文件扫描器
 * TODO：增加文件深度判断
 *
 * Created by zhaobs on 17/1/3.
 */
public class Scanner {

    private static final String rootPath = "/Users/zhaobs/Desktop/codedog";

    public static void main(String[] args){
        long start = new Date().getTime();

        List<File> result = scan();
        long end = new Date().getTime();
        int i=1;
        for(File file : result){
            System.out.println(i+"======="+file.getAbsolutePath());
            ++i;
        }
        Analyzer analyzer = new Analyzer();
        analyzer.analyse();
        System.out.println("消耗时间：start="+start+"   end="+end+"   "+(end-start));
    }

    /**
     * 1秒大约扫描30万文件
     *
     * @param suffix 哪种后缀的文件
     * @return
     * */
    public static List<File> scan(String suffix){
        List<File> result = new ArrayList<>();
        File rootFile = new File(rootPath);
        fileList(rootFile, result, suffix);
        return result;
    }

    private static List<File> scan(){
        return scan(null);
    }

    /**
     * 查找
     * */
    private static void fileList(File file, List<File> result, String suffix){
        if(file.isFile()){
            if(StringUtils.isBlank(suffix) || file.getPath().endsWith(suffix)){
                if(!file.getName().startsWith("."))
                result.add(file);
            }
        }else if(file.isDirectory()){
            for(File fileItem : file.listFiles()){
                fileList(fileItem, result, suffix);
            }
        }else{//既不是文件，也不是目录

        }
    }

}
