<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        isAdmin = user.isAdmin()
    >
    <#else>
    <#assign
        name = ""
        isAdmin = false
    >
</#if>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    isZavsklad = user.isZavsklad()
    >
<#else>
    <#assign
    name = ""
    isZavsklad = false
    >
</#if>
