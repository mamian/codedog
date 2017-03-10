package net.mamian.codedog.enums;

/**
 * Java关键字(50个，不含null)
 *
 * Created by zhaobs on 17/1/3.
 */
public enum JavaWord implements BaseEnum {


    /**
     * 一种访问控制方式：私用模式
     * */
    PRIVATE("private", "访问控制", "私有的"),

    /**
     * 一种访问控制方式：保护模式
     * */
    PROTECTED("protected", "访问控制", "受保护的"),

    /**
     * 一种访问控制方式：共用模式
     * */
    PUBLIC("public", "访问控制", "公共的"),






    /**
     * 枚举
     * */
    ENUM("enum","类、方法和变量修饰符","枚举"),

    /**
     * 表明类或者成员方法具有抽象属性
     * */
    ABSTRACT("abstract", "类、方法和变量修饰符", "声明抽象"),

    /**
     * 类
     * */
    CLASS("class", "类、方法和变量修饰符", "类"),

    /**
     * 表明一个类型是另一个类型的子类型，这里常见的类型有类和接口
     * */
    EXTENDS("extends", "类、方法和变量修饰符", "扩允,继承"),

    /**
     * 用来说明最终属性，表明一个类不能派生出子类，或者成员方法不能被覆盖，或者成员域的值不能被改变
     * */
    FINAL("final", "类、方法和变量修饰符", "最终值,不可改变的"),

    /**
     * 表明一个类实现了给定的接口
     * */
    IMPLEMENTS("implements", "类、方法和变量修饰符", "实现（接口）"),

    /**
     * 接口
     * */
    INTERFACE("interface", "类、方法和变量修饰符", "接口"),

    /**
     * 用来声明一个方法是由与计算机相关的语言（如C/C++/FORTRAN语言）实现的
     * */
    NATIVE("native", "类、方法和变量修饰符", "本地，原生方法（非Java实现）"),

    /**
     * 用来创建新实例对象
     * */
    NEW("new", "类、方法和变量修饰符", "新,创建"),

    /**
     * 表明具有静态属性
     * */
    STATIC("static", "类、方法和变量修饰符", "静态"),

    /**
     * 用来声明FP_strict（单精度或双精度浮点数）表达式遵循IEEE 754算术规范
     * */
    STRICTFP("strictfp", "类、方法和变量修饰符", "严格,精准"),

    /**
     * 表明一段代码需要同步执行
     * */
    SYNCHRONIZED("synchronized", "类、方法和变量修饰符", "线程,同步"),

    /**
     * 声明不用序列化的成员域
     * */
    TRANSIENT("transient", "类、方法和变量修饰符", "短暂"),

    /**
     * 表明两个或者多个变量必须同步地发生变化
     * */
    VOLATILE("volatile", "类、方法和变量修饰符", "易失"),






    /**
     * 提前跳出一个块
     * */
    BREAK("break", "程序控制语句", "跳出循环"),

    /**
     * 用在switch语句之中，表示其中的一个分支
     * */
    CASE("case", "程序控制语句", "定义一个值以供switch选择"),

    /**
     * 回到一个块的开始处
     * */
    CONTINUE("continue", "程序控制语句", "继续"),

    /**
     * 默认，例如，用在switch语句中，表明一个默认的分支
     * */
    DEFAULT("default", "程序控制语句", "默认"),

    /**
     * 用在do-while循环结构中
     * */
    DO("do", "程序控制语句", "运行"),

    /**
     * 用在条件语句中，表明当条件不成立时的分支
     * */
    ELSE("else", "程序控制语句", "否则"),

    /**
     * 一种循环结构的引导词
     * */
    FOR("for", "程序控制语句", "循环"),

    /**
     * 条件语句的引导词
     * */
    IF("if", "程序控制语句", "如果"),

    /**
     * 用来测试一个对象是否是指定类型的实例对象
     * */
    INSTANCEOF("instanceof", "程序控制语句", "实例"),

    /**
     * 从成员方法中返回数据
     * */
    RETURN("return", "程序控制语句", "返回"),

    /**
     * 分支语句结构的引导词
     * */
    SWITCH("switch", "程序控制语句", "根据值选择执行"),

    /**
     * 用在循环结构中
     * */
    WHILE("while", "程序控制语句", "循环"),






    /**
     * 用来进行程序调试
     * */
    ASSERT("assert", "错误处理", "断言表达式是否为真"),

    /**
     * 用在异常处理中，用来捕捉异常
     * */
    CATCH("catch", "错误处理", "捕捉异常"),

    /**
     * 用于处理异常情况，用来声明一个基本肯定会被执行到的语句块
     * */
    FINALLY("finally", "错误处理", "有没有异常都执行"),

    /**
     * 抛出一个异常
     * */
    THROW("throw", "错误处理", "抛出一个异常对象"),

    /**
     * 声明在当前定义的成员方法中所有需要抛出的异常
     * */
    THROWS("throws", "错误处理", "声明一个异常可能被抛出"),

    /**
     * 尝试一个可能抛出异常的程序块
     * */
    TRY("try", "错误处理", "捕获异常"),






    /**
     * 表明要访问指定的类或包
     * */
    IMPORT("import", "包相关", "引入"),

    /**
     * 包
     * */
    PACKAGE("package", "包相关", "包"),






    /**
     * 基本数据类型之一，布尔类型
     * */
    BOOLEAN("boolean", "基本类型", "布尔型"),

    /**
     * 基本数据类型之一，字节类型
     * */
    BYTE("byte", "基本类型", "字节型"),

    /**
     * 基本数据类型之一，字符类型
     * */
    CHAR("char", "基本类型", "字符型"),

    /**
     * 基本数据类型之一，双精度浮点数类型
     * */
    DOUBLE("double", "基本类型", "双精度浮点"),

    /**
     * 基本数据类型之一，单精度浮点数类型
     * */
    FLOAT("float", "基本类型", "单精度浮点"),

    /**
     * 基本数据类型之一，整数类型
     * */
    INT("int", "基本类型", "整型"),

    /**
     * 基本数据类型之一，长整数类型
     * */
    LONG("long", "基本类型", "长整型"),

    /**
     * 基本数据类型之一,短整数类型
     * */
    SHORT("short", "基本类型", "短整型"),

    /**
     * 用来标识一个不确定的对象
     * */
    NULL("null", "基本类型", "空"),






    /**
     * 表明当前对象的父类型的引用或者父类型的构造方法
     * */
    SUPER("super", "变量引用", "父类,超类"),

    /**
     * 指向当前实例对象的引用
     * */
    THIS("this", "变量引用", "本类"),

    /**
     * 声明当前成员方法没有返回值
     * */
    VOID("void", "变量引用", "无返回值"),






    /**
     * 保留关键字，没有具体含义
     * */
    GOTO("goto", "保留关键字", "是关键字，但不能使用"),

    /**
     * 保留关键字，没有具体含义
     * */
    CONST("const", "保留关键字", "是关键字，但不能使用");





    private JavaWord(String java, String type, String msg) {
        this.msg = msg;
    }

    final String msg;

    @Override
    public String getMsg() {
        return null;
    }

}