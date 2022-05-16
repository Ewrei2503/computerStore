<#import "parts/common.ftlh" as c>

<@c.page>
    <div>
        <form method="post" action="/quest/add/${order.id}">
            <input type="hidden" name="id" value="${order.id}"/>
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
                <label for="exampleFormControlSelect1">Исполнитель</label>
                <select name="messageFor" class="form-control" id="exampleFormControlSelect1">
                    <#list users as user>
                        <option>${user.username}</option>
                    </#list>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Отправить</button>
        </form>
    </div>
</@c.page>