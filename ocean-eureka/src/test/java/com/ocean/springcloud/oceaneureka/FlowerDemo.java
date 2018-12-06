package com.ocean.springcloud.oceaneureka;

/**
 * @author jack chao
 * @create 2018-12-04 19:31
 * @desc 打印出能被3整除的所有"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方
 **/
public class FlowerDemo {

    public static void main(String[] args) {
        int num = 100;
        int g,s,b;
        for(num= 100;num<1000;num++){
            g = num / 1 % 10;
            s = num / 10 % 10;
            b = num / 100 % 10;

            if(num == g*g*g+s*s*s+b*b*b ){
                System.out.println(num);
            }
        }

    }
}
