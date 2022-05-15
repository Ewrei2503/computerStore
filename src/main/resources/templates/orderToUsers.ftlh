<#import "parts/common.ftlh" as c>

<@c.page>
    <p>
        <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
            Корзина
        </button>
    </p>
    <div class="collapse mb-4" id="collapseExample">
        <div class="card card-body">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Номер позиции</th>
                    <th scope="col">Производитель</th>
                    <th scope="col">Тип</th>
                    <th scope="col"></th>
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
                        <td>
                            <form method="post" action="/order/{order}/${position}/delete">
                                <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
                                <button type="submit" class="btn btn-danger">Удалить</button>
                            </form>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
    <div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Производитель</th>
            <th scope="col">Модель</th>
            <th scope="col">Тип продукта</th>
            <th scope="col">Количество</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list products as product>
            <tr>
                <th scope="row">${product?counter}</th>
                <td>${product.company}</td>
                <td>${product.model}</td>
                <td>${product.type}</td>
                <td>${product.num}</td>
                <td><a href="/product/${product.id}">Детали</a></td>
                <td>
                    <form method="post" action="/order/${order.id}/add">
                        <div class="row" >
                            <div class="form-group">
                                <input type="text" name="num" class="form-control" id="exampleFormControlInput1" placeholder="Введите количество">
                            </div>
                            <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
                            <input type="hidden" name="id" value = "${product.id}"/>
                            <button type="submit" class="btn btn-primary ml-4">Добавить</button>
                        </div>
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
    </div>
</@c.page>