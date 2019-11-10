<#import "panel.ftl" as c/>
<@c.page title="Words list">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Words list</title>
    <link rel="stylesheet" href="/css/Search.css" type="text/css">
</head>
<body>
<div class="container">
    <br>
    <br>
            <input type="text" id="myInput" onkeyup="myFunction(0)" placeholder="Search word...">
    <br>
    <br>
    <table class="table table-sm table-striped table-bordered table-dark" id="myTable">
                <tr class="bg-success">
                    <th>English</th>
                    <th>Ukrainian</th>
                </tr>
                <#list Words as word>
                    <#assign uaWord = "">
                    <#assign int = 0>
                    <#list word.uaWord as UaWord>
                        <#if int == 0>
                            <#assign int = 1>
                            <#assign uaWord += UaWord + " ">
                            <#else>
                            <#assign uaWord +=", " + UaWord>
                        </#if>
                    </#list>
                    <tr>
                        <td>${word.enWord}</td>
                        <td>${uaWord}</td>
                    </tr>

                </#list>
            </table>
</div>

<script src="/js/Search.js" type="text/javascript"></script>
</body>
</html>
</@c.page>