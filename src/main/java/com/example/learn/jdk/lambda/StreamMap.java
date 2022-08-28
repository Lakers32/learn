package com.example.learn.jdk.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java8 FlatMap的使用
 * 给定单词列表[“Hello”,“World”]，你想要返回列表[“H”,“e”,“l”, “o”,“W”,“r”,“d”]
 * <p>
 * https://blog.csdn.net/Xumuyang_/article/details/120951979
 */
public class StreamMap {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");

        List<String[]> mapList = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("mapList = " + mapList);

        List<Stream<String>> streamList = words.stream()
                .map(word -> word.split("")) //将每个单词转换为由其字母构成的数组
                .map(Arrays::stream)//让每个数组变成一个单独的流
                .distinct()
                .collect(Collectors.toList());
        System.out.println("streamList = " + streamList);


        List<String> flatMapList = words.stream()
                .map(w -> w.split("")) //将每个单词转换为由其字母构成的数组
                .flatMap(Arrays::stream) //将各个生成流扁平化为单个流
                .distinct()
                .collect(Collectors.toList());
        System.out.println("flatMapList = " + flatMapList);
    }
}
