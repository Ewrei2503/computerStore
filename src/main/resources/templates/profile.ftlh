<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <h5>${username}</h5>
    <form method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Пароль:</label>
            <div class="col-sm-8">
                <input class="form-control" type="password" name="password" placeholder="Пароль"/>
            </div>
            <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
            <button type="submit" class="btn btn-primary">Сохранить</button>
        </div>
    </form>
</@c.page>