# SpringBoot高级特性实现策略模式
![SpringBoot实现策略模式说明](https://i.loli.net/2019/12/12/6MEj7koTzUhPWlH.jpg)

## 实现步骤
1. 定义一个公共的策略接口
```java
public interface Strategy {
 
    String getVpcList(String id);
 
}
```

2. 定义多种实现方式
ResourceA实现:
```java
@Component("A")
public class ResourceA implements Strategy {
 
    @Override
    public String getVpcList(String id) {
        System.out.println("A,getVpcList ==========="+id);
        return id;
    }
}
```
ResourceB实现：
```java
@Component("B")
public class ResourceB implements Strategy {
 
    @Override
    public String getVpcList(String id) {
        System.out.println("B strategy"+"====="+id);
        return id;
    }
 
}
```
2. 通过判断指定参数，选择对应的策略
SimpleContext实现：
```java
@Service
public class SimpleContext {
   
// SpringBoot会自动注入改接口对应所有类
    @Autowired
    private final Map<String, Strategy> strategyMap = new ConcurrentHashMap<>();
 
    public SimpleContext(Map<String, Strategy> strategyMap) {
        this.strategyMap.clear();
        strategyMap.forEach((k, v)-> this.strategyMap.put(k, v));
    }
 
    public String getResource(String poolId){
        return strategyMap.get(poolId).getVpcList(poolId);
    }
 
}
```

3.测试
提供测试的controller接口
```java
@RestController
@RequestMapping("/test")
public class TestController {
 
    @Autowired
    private SimpleContext simpleContext;
 
    @GetMapping("/choose")
    public String choose(@RequestParam String poolId){
        return simpleContext.getResource(poolId);
    }
 
}
```
```shell script
curl http://{hostname|ip}:{server.port}/test/choose/?poolId=A

curl http://{hostname|ip}:{server.port}/test/choose/?poolId=B
```
