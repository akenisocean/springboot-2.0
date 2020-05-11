<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title></title>
  <style type="text/css">
    table {
      width: 100%; 
      border-collapse: collapse; 
      border:1px solid #eee; 
      font-size:14px;
    }
    tr{
      background: #fafafa; 
      width: 100%; 
      color: #333; 
      border-bottom: 1px solid #eee;
    }
    td {
      text-align: center;
      height:28px;
      line-height: 28px;
    }
    strong{
      margin-right: 20px;
    }
    body>div{
      margin: 0 0 20px 0;
    }
    body>p{
      margin:0 0 20px 0;
    }
    body{
      margin:0;
      font-size: 14px;
      font-family: 'Open Sans',Helvetica,Arial,sans-serif;
      padding: 10px 20px;
    }
</style>
</head>
<body>
  <div style="width:100%;height:60px;position: relative;">
    <img height="60" src="" style="display: inline-block;position:absolute;top:0;left:20px">
    <div style="padding:0;display:inline-block;height:60px;line-height: 60px;position:absolute;right:20px;top:0">${emailInhibition.sendTime}</div>
  </div>
  <p>
    <strong>${emailInhibition.title}</strong>
  </p>

  <#list emailInhibition.emailInhibitionParamList as eInhibition>
  <div>
    ${eInhibition.tagName}
    <table border="1">
      <thead>
      <tr>
        <#list eInhibition.tagTitles as tagTitle>
          <td>${tagTitle}</td>
        </#list>
      </tr>
      </thead>
      <tbody>
      <#if eInhibition.tagParams?exists>
        <#list eInhibition.tagParams?keys as mKey>
          <#assign item = eInhibition.tagParams[mKey]>
          <tr>
            <#list item as itemValue>
              <td>${itemValue}</td>
            </#list>
          </tr>
        </#list>
      </#if>
      </tbody>
    </table>
  </div>
  </#list>



</body>
</html>