<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="mt-4">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Исполнитель</th>
                <th scope="col">Номер заказа</th>
                <th scope="col">Статус</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <#list orders as order>
                <tr>
                    <th scope="row">${order?counter}</th>
                    <td><#if order.executor??>${order.executor.username}<#else>Не назначен</#if></td>
                    <td>${order.id}</td>
                    <td><#if order.executor??>В работе<#else>Ожидание подтверждения исполнителем</#if></td>
                    <td><a href="/quest/add/${order.id}" class="btn btn-primary active" role="button" aria-pressed="true">Назначить пользователя</a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>