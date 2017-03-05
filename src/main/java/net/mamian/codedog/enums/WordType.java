package net.mamian.codedog.enums;

/**
 * Created by zhaobs on 17/1/3.
 */
public enum WordType implements BaseEnum {


    MethodName("方法名"),
    ParamName("变量名"),
    ParamValue("变量值"),
    Final("常量"),//数字
    KeyWord("java关键字"),
    CommonStr("字符串"),
    SpecialChar("特殊符号"),


    ;



    final String msg;

    private WordType(String msg){
        this.msg = msg;
    }

    @Override
    public String getMsg() {
        return null;
    }
}
