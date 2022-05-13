<#import "parts/common.ftlh" as c>

<@c.page>

    <div class="float-right mb-4"><a href="/registration"> Add new user</a></div>
    <table class="table table-striped">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Role</th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
            <#list users as user>
            <tr>
                <th scope="row">${user?counter}</th>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.id}">Изменить</a></td>
            </tr>
            </#list>
        </tbody>
    </table>
</@c.page>