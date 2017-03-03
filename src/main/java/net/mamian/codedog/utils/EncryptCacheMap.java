package net.mamian.codedog.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 加密缓存
 *
 * Created by zhaobs on 17/1/22.
 */
public class EncryptCacheMap {

    private static final Map<String, String>  encryptMap = new ConcurrentHashMap<>();

    /**
     * 从缓存中获取加密结果
     *
     * @param origin 待加密的字符串
     * @return 加密后的字符串
     * */
    public static final String get(String origin){
        return encryptMap.get(origin);
    }

    /**
     * 将字符串加密结果缓存到map中
     *
     * @param origin 待加密的字符串
     * @param encrypted 加密后的内容
     * @return
     * */
    public static final String set(String origin, String encrypted){
        return encryptMap.put(origin, encrypted);
    }

}
