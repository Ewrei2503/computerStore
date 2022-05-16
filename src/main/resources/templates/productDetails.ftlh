<#import "parts/common.ftlh" as c>

<@c.page>
        <div>
            <label for="exampleFormControlInput1">Производитель</label>
            <input class="form-control" type="text" placeholder="${product.company}" readonly>
        </div>
        <div>
            <label for="exampleFormControlInput1">Модель</label>
            <input class="form-control" type="text" placeholder="${product.model}" readonly>
        </div>
        <div>
            <label for="exampleFormControlInput1">Тип</label>
            <input class="form-control" type="text" placeholder="${product.type}" readonly>
        </div>
    <#if !product.isDrive() && !product.isMotherboard()>
        <div>
            <label for="exampleFormControlInput1">Частота</label>
            <input class="form-control" type="text" placeholder="${product.clock}" readonly>
        </div>
    </#if>
    <#if product.isMotherboard()>
        <div>
            <label for="exampleFormControlInput1">Сокет</label>
            <input class="form-control" type="text" placeholder="${product.socket}" readonly>
        </div>
    </#if>
    <#if product.isProcessor()>
        <div>
            <label for="exampleFormControlInput1">Ядра</label>
            <input class="form-control" type="text" placeholder="${product.cores}" readonly>
        </div>
        <div>
            <label for="exampleFormControlInput1">Потоки</label>
            <input class="form-control" type="text" placeholder="${product.thread}" readonly>
        </div>
    </#if>
    <#if !product.isMotherboard() && !product.isProcessor()>
        <div>
            <label for="exampleFormControlInput1">Память</label>
            <input class="form-control" type="text" placeholder="${product.memory}" readonly>
        </div>
    </#if>
    <#if product.isDrive()>
        <div>
            <label for="exampleFormControlInput1">Тип диска</label>
            <input class="form-control" type="text" placeholder="<#if product.typeDrive>SSD<#else> HDD</#if>" readonly>
        </div>
    </#if>
</@c.page>

