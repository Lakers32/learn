package com.example.learn.jdk.transform;

/**
 * @description: 转义
 * @author: 程凯
 * @create: 2022-09-29 17:52
 **/
public class Transform {

    public static void main(String[] args) {


        String webContent = " {\"msgtype\" : \"text\",\n" +
                " \"text\" :{\n" +
                "     \"content\":\"日志平台告警详情： 告警名称 ${name},告警标题 ${title},告警详情 ${details}\"\n" +
                " }}";

        webContent = webContent.replaceAll("\\$\\{" + "name" + "}", "33");

        System.out.println(webContent);

        String Str = new String("www.google.com");
        System.out.print("匹配成功返回值 :" );
        System.out.println(Str.replaceAll("(.*)google(.*)", "runoob" ));
        System.out.print("匹配失败返回值 :" );
        System.out.println(Str.replaceAll("(.*)taobao(.*)", "runoob" ));
    }
}
