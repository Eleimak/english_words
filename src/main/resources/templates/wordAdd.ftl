<#import "panel.ftl" as c/>
<@c.page title="Word add">
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Word add</title>
</head>
<body>
<div class="container">
<br>
<h3>Add Word</h3>
<br>
<form name="WordForm" action="" method="POST">
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon1">English:</span>
        </div>
        <@spring.formInput "WordForm.enWord" "class='form-control'" "text"/>
    </div>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon1">Ukrainian:</span>
        </div>
        <@spring.formInput "WordForm.uaWord" "class='form-control'" "text"/>
    </div>
    <a href="/list" Type="Button" class="btn btn-primary">Back</a>
    <input Type="submit" value="     Submit     " class="btn btn-danger"/>
</form>
</div>
</body>
</html>
</@c.page>