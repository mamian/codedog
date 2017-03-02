package net.mamian.codedog.enums;

/**
 * 此行代码的类型
 *
 * 先按行解析是哪种类型
 * 再解析行内的内容，是哪种WordType
 *
 * Created by zhaobs on 17/1/3.
 */
public enum LineType implements BaseEnum {

    PACKAGE("package"),

    IMPORT("import"),

    METHOD("method"),

    ZHUSHI("注释"),

    ZHUJIE("注解"),






    ;

    final String msg;

    public String getMsg(){
        return this.msg;
    }

    private LineType(String msg){
        this.msg = msg;
    }
}
