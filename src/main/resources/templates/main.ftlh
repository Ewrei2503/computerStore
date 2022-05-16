<#import "parts/common.ftlh" as c>
<@c.page>
<div>
    <p>
        <a class="btn btn-primary" data-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls="multiCollapseExample1">Создать сообщение</a>
        <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#multiCollapseExample2" aria-expanded="false" aria-controls="multiCollapseExample2">Работа с данными</button>
    </p>
    <div class="row">
        <div class="col ">
            <div class="collapse <#if message??>show</#if> multi-collapse " id="multiCollapseExample1">
                <div class="card card-body">
                    <form method="post">
                        <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
                        <div class="form-group">
                            <label for="inputTag">Тема сообщения</label>
                            <input type="text" name="tag" class="form-control ${(tagError??)?string('is-invalid','')}"
                                   value="<#if message??>${message.tag}</#if>" id="inputTag"  placeholder="Введите тему сообщения">
                            <#if tagError??>
                                <div class="invalid-feedback">
                                    ${tagError}
                                </div>
                            </#if>
                        </div>
                        <div class="form-group">
                            <label for="inputMail">Сообщение</label>
                            <input type="text" name="text" class="form-control ${(textError??)?string('is-invalid','')}"
                            value="<#if message??>${message.text}</#if>" id="inputMail" aria-describedby="mailHelp" placeholder="Введите сообщение">
                            <#if textError??>
                                <div class="invalid-feedback">
                                    ${textError}
                                </div>
                                <#else> <small id="mailHelp" class="form-text text-muted">Сообщение длинной не более 2048 символов.</small>
                            </#if>
                        </div>
                        <div class="form-group">
                            <label for="inputAddressed">Получатель</label>
                            <input type="text" name="messageFor" class="form-control ${(messageForError??)?string('is-invalid','')}"
                            value="<#if message??>${message.messageFor}</#if>" id="inputAddressed" placeholder="Введите логин получателя">
                            <#if messageForError??>
                                <div class="invalid-feedback">
                                    ${messageForError}
                                </div>
                            </#if>
                        </div>
                        <button type="submit" class="btn btn-primary">Отправить</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="collapse multi-collapse" id="multiCollapseExample2">
                <div class="card card-body">
                    <label for="inputFilter">Фильтр по отправителю</label>
                    <form class = "form-inline" method="get" action="/main">
                        <div class="form-group">
                            <input type="text" name="filter" class="form-control" id="inputFilter" placeholder="Введите фильтр" value="${filter?ifExists}">
                        </div>
                        <button type="submit" class="btn btn-primary ml-3">Отфильтровать</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="accordion mt-3" id="accordionExample">
    <#list messages as message>

    <div class="card" >
        <div class="card-header" id="heading${message.id}">
            <h5 class="mb-0">
                <button class="btn btn-link collapsed <#if message.order??>text-warning</#if>" type="button" data-toggle="collapse" data-target="#collapse${message.id}" aria-expanded="false" aria-controls="collapse${message.id}">
                    <strong>${message.authorName}</strong>
                    <i>${message.tag}</i>
                </button>
            </h5>
        </div>

        <div id="collapse${message.id}" class="collapse" aria-labelledby="heading${message.id}"  data-parent="#accordionExample">
            <div class="card-body">
                    <div>
                        <span>${message.text}</span>
                    </div>
                    <#if message.order??>
                        <div class="mt-4">
                            <form method="post" action="/main/accept/${message.order.id}">
                                <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
                                <input type="hidden" name="msgId" value="${message.id}">
                                <input type="hidden" name="id" value="${message.order.id}">
                                <button class="btn btn-link-primary" type="submit"> Подтвердить</button>
                            </form>
                        </div>
                    </#if>
            </div>
        </div>
    </div>
    <#else> No messages
    </#list>
</div>
</@c.page>