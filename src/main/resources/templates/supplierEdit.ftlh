<#import "parts/common.ftlh" as c>

<@c.page>
    <div>
        <form method="post">
            <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
            <div class="form-group">
                <label for="exampleFormControlInput1">Название организации</label>
                <input type="name" name="name" class="form-control" id="exampleFormControlInput1" value="${supplier.name}"  placeholder="Введите название организации">
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput1">Email</label>
                <input type="email" name="email" class="form-control" id="exampleFormControlInput1" value="${supplier.email}" placeholder="Введите почту">
            </div>
            <button class="btn btn-primary" type="submit">Изменить</button>
        </form>
    </div>
</@c.page>