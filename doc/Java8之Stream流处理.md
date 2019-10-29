# 简介： Java8新特性处理数据集合流Stream

## stream       Optional   Supplier

Java8引进了函数式编程，方便用户更好的阅读代码以及瀑布流式开发，方便用户对集合中的数据等进行操作，大大简化和方便了
用户的开发，废话不多说，直接进入主题。

```java
public class StreamData{
    private static List<PersonModel> list = null;
    static {
        PersonModel wu = new PersonModel("wu qi",18,"男");
        PersonModel zhang = new PersonModel("zhang san",19,"男");
        PersonModel li = new PersonModel("li si",20,"女");
        PersonModel zhao = new PersonModel("zhao wu",21,"男");
        PersonModel chen = new PersonModel("chen liu",22,"男");
        list  = Arrays.asList(wu,zhang,li,zhao,chen);
    }
}
```

# Steam流之Filter

过滤其中不需要的数据

```

/**
* 取出所有的用户名字
*/
list.steam().filter(person -> "男".equals(person.getSex()))
        .collect(toList<>);
```

# Stream流之map


# Stream流之flatMap



参考链接： https://mp.weixin.qq.com/s/YCr-jengNpygPLy-aixfYw



