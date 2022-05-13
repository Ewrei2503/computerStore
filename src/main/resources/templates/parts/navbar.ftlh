<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand">Склад</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Главная</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/main">Сообщения</a>
            </li>
            <#if isAdmin>
                <li class="nav-item active">
                    <a class="nav-link" href="/user">Пользователи</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/product">Товар</a>
                </li>
            </#if>

        </ul>

        <#if user??>
            <a class="nav-link mr-3" href="/user/profile">${name}</a>
            <#if name != "">
                <@l.logout/>
            </#if>
        </#if>
    </div>
</nav>