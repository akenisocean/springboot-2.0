# Stream流中的Collector集合使用说明

1）、 Collector接口中的方法说明
```java
public interface Collector<T, A, R> {
    // supplier参数用于生成结果容器，容器类型为A
    Supplier<A> supplier();
    // accumulator用于消费元素，也就是归纳元素，这里的T就是元素，它会将流中的元素一个一个与结果容器A发生操作
    BiConsumer<A, T> accumulator();
    // combiner用于两个两个合并并行执行的线程的执行结果，将其合并为一个最终结果A
    BinaryOperator<A> combiner();
    // finisher用于将之前整合完的结果R转换成为A
    Function<A, R> finisher();
    // characteristics表示当前Collector的特征值，这是个不可变Set
    Set<Characteristics> characteristics();
}
```
Collector拥有两个of方法用于生成Collector实例，其中一个拥有上面所有五个参数，另一个四个参数，不包括finisher。
```java
public interface Collector<T, A, R> {
    // 四参方法，用于生成一个Collector，T代表流中的一个一个元素，R代表最终的结果
    public static<T, R> Collector<T, R, R> of(Supplier<R> supplier,
                                              BiConsumer<R, T> accumulator,
                                              BinaryOperator<R> combiner,
                                              Characteristics... characteristics) {/*...*/}
    // 五参方法，用于生成一个Collector，T代表流中的一个一个元素，A代表中间结果，R代表最终结果，finisher用于将A转换为R                                          
    public static<T, A, R> Collector<T, A, R> of(Supplier<A> supplier,
                                                 BiConsumer<A, T> accumulator,
                                                 BinaryOperator<A> combiner,
                                                 Function<A, R> finisher,
                                                 Characteristics... characteristics) {/*...*/}                                              
}

//Characteristics：这个特征值是一个枚举，拥有三个值：CONCURRENT（多线程并行），
// UNORDERED（无序），IDENTITY_FINISH（无需转换结果）。其中四参of方法中没有finisher参数，
// 所以必有IDENTITY_FINISH特征值。x
```

## java8为方便开发，提供了Collector的工具类，Collectors使用

1、Collectors mapping(Function mapper, Collector downstream): mapping类型转换并形成新的集合

2、Collectors joining(): 集合连接

3、Collectors.collectingAndThen(): 先执行了一个归纳操作，然后再对归纳的结果进行 Function 函数处理输出一个新的结果。

4、Collectors.groupingBy()和groupingByConcurrent(): 分组。

5、Collectors.partitioningBy():看作 groupingBy 的一个特例，基于断言（Predicate）策略分组。

6、Collectors.maxBy()和minBy(): 获取最大值或最小值。

7、Collectors.toMap(): map集合。


参考文档： http://www.java2s.com/Tutorials/Java/java.util.stream/Collectors/index.htm


