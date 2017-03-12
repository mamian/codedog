package net.mamian.codedog.analyse;

import net.mamian.codedog.utils.FileUtils;

import java.io.File;

/**
 * 行过滤器
 *
 * @author zhaobs
 * @mail zhaobeishu@meituan.com
 * @date 2017-02-07 15:49
 * @copyright ©2017 All Rights Reserved
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
@Deprecated
public class LineFilter {

    /**
     *
     * */
    public static final StringBuilder filter(File file){
        StringBuilder builder = new StringBuilder();
        for(String line : FileUtils.readLine(file)){
            builder.append("\n");
            if(line.startsWith("package ") || line.startsWith("import ") || line.startsWith("public class ")
                    || line.startsWith("/**") || line.startsWith(" *") || line.startsWith(" */")){
                builder.append(line);
            }else{
                builder.append(CharFilter.filter(line));
            }
        }
        return builder;
    }

}
