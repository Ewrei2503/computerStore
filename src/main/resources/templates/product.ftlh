<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="float-right mb-4"><a href="product/createProduct">Добавить товар</a></div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Производитель</th>
            <th scope="col">Модель</th>
            <th scope="col">Тип</th>
            <th scope="col"></th>
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
                <td><a href="/product/${product.id}">Изменить</a></td>
                <td> <a href="/user/${product.id}">Детали</a></td>
                <td><button type="button" method="post"  class="btn btn-danger">Удалить</button></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>