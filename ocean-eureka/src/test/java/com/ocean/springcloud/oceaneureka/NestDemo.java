package com.ocean.springcloud.oceaneureka;

import java.util.Scanner;

/**
 * @author jack chao
 * @create 2018-12-04 17:33
 * @desc 利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示，如果离特殊线分数x差5分的用D表示。
 **/
public class NestDemo {

    public static void main(String[] args) {
        System.out.printf("请输入学生的成绩:");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();

        System.out.printf("请输入特殊线分数x：");
        Scanner sd = new Scanner(System.in);
        int x = sd.nextInt();
        grade(score,x);
    }
    private static void grade(int score, int x) {
            String str = ((score >= 90)? "A"
                    :((score >= 60)? "B"
                    :((score-x) != 5)?"C": "D"));
            System.out.printf("该学生得分:%s,对应的等级为：%s" , score ,str);

    }
}
