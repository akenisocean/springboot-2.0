<#-- 定义要显示的列数 columnCount -->
<#assign columnCount = 2>

<#-- 计算显示当前记录集需要的表格行数 rowCount -->
<#if photoList.size() % columnCount == 0>
    <#assign rowCount = ( photoList.size() / columnCount) - 1 >
<#else>
    <#assign rowCount = ( photoList.size() / columnCount) >
</#if>

<#-- 输出表格 -->
<table border='1' cellSpacing="1" align="center">

    <#-- 外层循环输出表格的 tr -->
    <#list 0..rowCount as row >
        <tr>
            <#-- 内层循环输出表格的 td -->
            <#list 0..columnCount - 1 as cell >
                <td align="center" width='${100 / columnCount}%'>
                    <#-- 判断是否存在当前对象：存在就输出；不存在就输出空格 -->
                    <#if photoList[row * columnCount + cell]?? >
                        <#assign photo = photoList[row * columnCount + cell]>
                        ${photo.title!?html} <br />
                        ${photo.commentCount} 条评论 <br />
                        ${photo.viewCount} 次浏览<br />
                    <#else>
                        &nbsp;
                    </#if>
                </td>
            </#list>
        </tr>
    </#list>
</table>