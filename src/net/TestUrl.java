package net;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class TestUrl {
    public static void main(String[] args) throws IOException {
        //绝对路径构建
        URL url = new URL("http://www.baidu.com:80/index.html?uname=bjsxt");
        System.out.println("协议:"+url.getProtocol());
        System.out.println("域名:"+url.getHost());
        System.out.println("端口:"+url.getPort());
        System.out.println("资源:"+url.getFile());
        System.out.println("相对路径:"+url.getPath());
        System.out.println("锚点:"+url.getRef()); //锚点
        System.out.println("参数:"+url.getQuery());//?参数 :存在锚点  返回null ,不存在，返回正确

        url = new URL("https://leetcode-cn.com/u/");
        url = new URL(url,"chengzixiang"); //相对路径
        System.out.println(url.toString());

//        url = new URL("https://leetcode-cn.com/u/chengzixiang/");
        BufferedReader bufferedReader =
                new BufferedReader(
                        new InputStreamReader(url.openStream(),"UTF-8"));

        BufferedWriter bufferedWriter =
                new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream("ChengZixiang.html"),"utf-8"
                        ));

        String string = null;
        while ((string = bufferedReader.readLine())!=null){
            bufferedWriter.append(string);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();



    }
}
