<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>消息通知</title>
</head>

<style type="text/css">
    table {
        font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
        width: 100%;
        border-collapse: collapse;
    }

    td, th {
        font-size: 1em;
        border: 1px solid #5B4A42;
        padding: 3px 7px 2px 7px;
    }

    th {
        font-size: 1.1em;
        text-align: center;
        padding-top: 5px;
        padding-bottom: 4px;
        background-color: #24A9E1;
        color: #ffffff;
    }
</style>
<body>

<div class="info-top" style="padding: 15px 25px;
                                 border-top-left-radius: 10px;
                                 border-top-right-radius: 10px;
                                 background: #55f3c6;
                                 color: #fff;
                                 overflow: hidden;
                                 line-height: 32px;">
    <img src="https://img01.sogoucdn.com/app/a/100520146/efd8e5d282ff193dc69cba66870d84f9" style="float: left; margin: 0 120px 0 0; width: 180px;" /><div style="color:#010e07;text-align: right;">发送时间:{1}</div>
</div>
<div>
    <h2>策略名称:${emailInhibition.strategyName}</h2>
    <h2>发送时间:${emailInhibition.sendTime}</h2>
    <h3>${emailInhibition.title}</h3>

    <#list emailInhibitionList as emailInhibition>
        ${emailInhibition.tagName}
        <table>
            <tr>
                <#list emailInhibition.tagTitles as tagTitle>
                    <th> ${tagTitle} </th>
                </#list>
            </tr>
            <#if emailInhibition.tagParams?exists>
                <#list emailInhibition.tagParams?keys as mKey>
                    <#assign item = emailInhibition.tagParams[mKey]>
                    <tr>
                        <#list item as itemValue>
                            <td>${itemValue}</td>
                        </#list>
                    </tr>
                </#list>
            </#if>
        </table>
    </#list>
</div>
</body>
</html>