package com.ylzt.geekbang.lesson01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: CustomClassLoader
 * @Description: 自定义类加载器
 * @Author: liwenlong
 * @Date: 2020/10/17 12:04 上午
 **/
public class CustomClassLoader extends ClassLoader {

    public static void main(String[] args) throws Exception {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        Class cls = customClassLoader.findClass("Hello");
        cls.getDeclaredMethod("hello").invoke(cls.newInstance());
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String filePath = "Hello.xlass";
        int byteData = -1;
        byte[] bytes = null;
        try {
            try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
                 ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
            ) {
                while ((byteData = inputStream.read())!= -1) {
                    outputStream.write(255-byteData);
                }
                bytes = outputStream.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, bytes, 0, bytes.length);
    }
}
