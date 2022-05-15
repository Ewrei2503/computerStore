<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="float-right mb-4"><a href="/supplier/add"> Добавить поставщика</a></div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Название организации</th>
            <th scope="col">Email</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list suppliers as supplier>
            <tr>
                <th scope="row">${supplier?counter}</th>
                <td>${supplier.name}</td>
                <td>${supplier.email}</td>
                <td><a href="/supplier/${supplier.id}">Изменить</a></td>
                <td>
                    <form method="post" action="/supplier/${supplier.id}/delete">
                        <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
                        <button type="submit" class="btn btn-danger">Удалить</button>
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>