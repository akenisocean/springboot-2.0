package com.ocean.springcloud.oceaneureka;

/**
 * @author jack chao
 * @create 2018-12-04 19:25
 * @desc 输入一行字符，分别统计出其英文字母、空格、数字和其他字符出现的次数。
 **/
public class CountDemo {

    public static void main(String[] args) {
       int num = 0,chara = 0,black = 0,other = 0;
       String result = "sdadsadasdnak c  n xc ajs da dq e31 23 cz;lc,.'.']asx";
        //Sztring转换成char数组
        char[] chars = result.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 通过char的包装类来判断是否是数字
            if (Character.isDigit(chars[i])){
                num++;
            }else if (Character.isLetter(chars[i])){
                chara++;

            }else if (Character.isSpaceChar(chars[i])){
                black++;
            }else {
                other++;
            }

        }
        System.out.println("输入的个数为："+chars.length);
        System.out.println("数字的个数是"+num);
        System.out.println("字符的个数是"+chara);
        System.out.println("空值的个数是"+black);
        System.out.println("其他的个数是"+other);
    }
}
