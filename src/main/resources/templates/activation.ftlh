<#import "parts/common.ftlh" as c>

<@c.page>
    <h4>Здравствуйте!</h4>
    <div>Вашей компании от лица нашего склада идет прошение о формировании следующей поставки товара</div>

    <div class="row my-4">
        <form method="post" action="/order/activation/${order.id}">
            <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
            <input type="hidden" name="answer" value = "true"/>
            <button type="submit" class="btn btn-secondary">Подтвердить</button>
        </form>
        <div class="ml-4">
            <form method="post" action="/order/activation/${order.id}">
                <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
                <input type="hidden" name="answer" value = "false"/>
                <button type="submit" class="btn btn-secondary">Отклонить</button>
            </form>
        </div>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Номер позиции</th>
            <th scope="col">Производитель</th>
            <th scope="col">Тип</th>
        </tr>
        </thead>
        <tbody>
        <#list positions as position>
            <tr>
                <th scope="row">${position?counter}</th>
                <td>${position.getId()}</td>
                <td>
                    <#list products as product>
                        <#if product == position.product>
                            ${product.company}
                        </#if>
                    </#list>
                </td>
                <td><#list products as product>
                        <#if product == position.product>
                            ${product.model}
                        </#if>
                    </#list>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>