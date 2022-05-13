<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Имя пользователя: </label>
            <div class="col-sm-8"/>
                <input class="form-control ${(usernameError??)?string('is-invalid','')}"
                       value="<#if user??>${user.username}</#if>"type="text" name="username" placeholder="Имя пользователя"/>
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Пароль:</label>
            <div class="col-sm-8">
                <input class="form-control ${(passwordError??)?string('is-invalid','')}" type="password" name="password" placeholder="Пароль"/>
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>
        <#if isRegisterForm>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label"> Подтверждение пароля:</label>
                <div class="col-sm-8">
                    <input class="form-control ${(password2Error??)?string('is-invalid','')}" type="password" name="password2" placeholder="Повторите ввод пароля"/>
                    <#if password2Error??>
                        <div class="invalid-feedback">
                            ${password2Error}
                        </div>
                    </#if>
                </div>
            </div>
        </#if>
        <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
        <button type="submit" class="btn btn-primary"><#if isRegisterForm>Создать<#else>Войти</#if></button>
    </form>
</#macro>
<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Выйти</button>
    </form>
</#macro>