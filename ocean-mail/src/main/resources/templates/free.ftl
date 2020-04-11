<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Freemarker</title>
</head>
<body>
<ul>
    <li>SpringMVC默认值free：${free}
    <li>不存在的值/变量：${haha!"该值不存在"}
    <li>为null的值：${nullValue!"该值为null"}
</ul>
<div>
    遍历User中基本类型：
    <ul>
        <li>User.id:${user.id}
        <li>User.name:${user.name}
        <li>User.price:${user.price}
        <li>User.boy:<#if user.boy == true>男<#elseif user.boy == false>女<#else>未知</#if>
        <li>数值判断大小判断：<#if user.price lt 666666> 小于666666<#elseif user.price gt 777777>大于77777 <#else>666666~777777</#if>
    </ul>
</div>
<div>
    switch使用：
    <#switch user.name>
    <#case "haha">
    haha
    <#break>
    <#case "wsz">
    wsz wsz
    <#break>
    <#default>
    default默认
</#switch>
</div>
<div>
    遍历User.list(大小：${user.list?size})：sep添加隔离符号
    <ul>
        <#list user.list as str>
        <li>${str}   下标为(0开始)：${str?index}  下标为(1开始)：${str?counter}  存在后续：${str?has_next?c} 最后项：${str?is_last?c}<#sep>,
        </#list>
    </ul>
</div>
<div>
    遍历User.set(与list相似：大小为${user.set?size}):
    <ul>
        <#list user.set as i>
        <li>${i}  下标为：${i?index}
        </#list>
    </ul>
</div>
<div>
    遍历User.map(大小为:${user.map?size})：
    <ul>
        <#list user.map?keys as key>
        <li>key:${key} value:${user.map["${key}"]}
        </#list>
    </ul>
</div>
</body>
</html>