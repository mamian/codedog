package net.mamian.codedog.enums;

/**
 * 
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2017-01-13 11:45
 * @copyright ©2017 马面 All Rights Reserved
 */
public enum FileType implements BaseEnum {

    JAVA("java代码"),
    UNKNOWN("未知类型"),
    ;

    final String msg;

    @Override
    public String getMsg(){
        return this.msg;
    }

    private FileType(String msg){
        this.msg = msg;
    }
}
