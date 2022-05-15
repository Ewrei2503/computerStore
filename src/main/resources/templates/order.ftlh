<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="row mb-4">
        <div class="mr-4">
            <form method="post" action="order/toSupplier">
                <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
                <input type="hidden" name="type" value = "true"/>
                <button type="submit" class="btn btn-secondary">Заказ новой продукции</button>
            </form>
        </div>
        <div>
            <form method="post" action="order/create">
                <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
                <input type="hidden" name="type" value = "false"/>
                <button type="submit" class="btn btn-secondary">Добавить заказ</button>
            </form>
        </div>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Исполнитель</th>
            <th scope="col">Тип исполнения</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list orders as order>
            <tr>
                <th scope="row">${order?counter}</th>
                <td><#if order.wait>Ожидание подтверждения исполнителем<#else>В работе</#if></td>
                <td><#if order.type>Приход<#else>Отход</#if></td>
                <td><a href="<#if order.type>/order/${order.id}/toSup<#else>/order/${order.id}</#if>">Детали</a></td>
                <td>
                    <form method="post" action="/order/${order.id}/delete">
                        <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
                        <button type="submit" class="btn btn-danger">Удалить</button>
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>

</@c.page>