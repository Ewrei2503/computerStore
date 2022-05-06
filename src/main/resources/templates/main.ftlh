<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
<div>
    <@l.logout />
</div>
    <a href="/user"> User List</a>
<div>
    <form method="post">
        <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
        <input type="text" name="text" placeholder="Введите сообщение">
        <input type="text" name="tag" placeholder="Тэг">
        <button type="submit">Добавить</button>
    </form>
    <form method="get" action="/main">
        <input type="text" name="filter" placeholder="Введите фильтр" value="${filter?ifExists}">
        <button type="submit">Отфильтровать</button>
    </form>
    <a href="/registration"> Add new user</a>

</div>
<#list messages as message>
    <div>
        <b>${message.id}</b>
        <span>${message.text}</span>
        <i>${message.tag}</i>
        <strong>${message.authorName}</strong>
    </div>
<#else> No messages
</#list>
</@c.page>