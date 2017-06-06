package net.mamian.codedog.encrypt;

/**
 * 加密接口
 *
 * Created by zhaobs on 17/1/13.
 */
public interface IEncrypt {

    /**
     * @param method 加密算法
     * @param content 加密内容
     * @param contentType 加密内容的类型
     * */
    public String encrypt(String method, String content, String contentType);

}
