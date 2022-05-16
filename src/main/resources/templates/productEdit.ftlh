<#import "parts/common.ftlh" as c>

<@c.page>
    <form action="/product/${product.id}/edit" method="post">
        <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
        <input type="hidden" name="type" value = "videocard"/>
        <div class="form-group">
            <label for="exampleFormControlSelect1">Производитель</label>
            <select name="company" class="form-control" id="exampleFormControlSelect1">
                <#if product.isVideocard()>
                    <option>Nvidia</option>
                    <option>AMD</option>
                </#if>
                <#if product.isMotherboard()>
                    <option>Asus</option>
                    <option>MSI</option>
                    <option>GIGABYTE</option>
                    <option>ASRock</option>
                    <option>Tyan</option>
                    <option>Biostar</option>
                </#if>
                <#if product.isProcessor()>
                    <option>Intel</option>
                    <option>AMD</option>
                </#if>
                <#if product.isRam()>
                    <option>Patriot</option>
                    <option>Silicon Power</option>
                    <option>Crucial</option>
                    <option>Transcend</option>
                    <option>Kingston</option>
                    <option>CORSAIR</option>
                    <option>HyperX</option>
                    <option>Samsung</option>
                    <option>Gigabyte</option>
                    <option>G.SKILL</option>
                </#if>
                <#if product.isDrive()>
                    <option>Western Digital</option>
                    <option>Adata</option>
                    <option>Toshiba</option>
                    <option>Transcend</option>
                    <option>Kingston</option>
                    <option>Silicon Power</option>
                    <option>Intel</option>
                    <option>Samsung</option>
                    <option>AMD</option>
                    <option>Sandisk</option>
                </#if>
            </select>
        </div>
        <div class="form-group">
            <label for="exampleFormControlInput1">Модель</label>
            <input type="text" name="model" class="form-control" id="exampleFormControlInput1" placeholder="Введите модель">
        </div>
        <#if !product.isMotherboard() && !product.isProcessor()>
            <div class="form-group">
                <label for="exampleFormControlInput1">Память</label>
                <input type="text" name="memory" class="form-control" id="exampleFormControlInput1" placeholder="Введите количество видеопамяти">
            </div>
        </#if>
        <#if !product.isDrive() && !product.isMotherboard()>
            <div class="form-group">
                <label for="exampleFormControlInput1">Частота</label>
                <input type="text" name="clock" class="form-control" id="exampleFormControlInput1" placeholder="Введите частоту">
            </div>
        </#if>
        <#if product.isProcessor()>
            <div class="form-group">
                <label for="exampleFormControlSelect2">Количество ядер</label>
                <select multiple class="form-control" name="cores" id="exampleFormControlSelect2">
                    <option>1</option>
                    <option>2</option>
                    <option>4</option>
                    <option>6</option>
                    <option>8</option>
                    <option>12</option>
                    <option>16</option>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect3">Количество потоков</label>
                <select multiple class="form-control" name ="thread" id="exampleFormControlSelect3">
                    <option>1</option>
                    <option>2</option>
                    <option>4</option>
                    <option>6</option>
                    <option>12</option>
                    <option>16</option>
                    <option>24</option>
                    <option>32</option>
                </select>
            </div>
        </#if>
        <#if product.isMotherboard()>
            <div class="form-group">
                <label for="exampleFormControlInput1">Сокет</label>
                <input type="text" name="socket" class="form-control" id="exampleFormControlInput1" placeholder="Введите сокет">
            </div>
        </#if>
        <#if product.isDrive()>
            <div class="row ml-5">
                <div class="form-check col">

                    <input class="form-check-input" type="radio" name="typeDrive" id="exampleRadios1" value="0" checked>
                    <label class="form-check-label" for="exampleRadios1">
                        HDD
                    </label>
                </div>
                <div class="form-check col">
                    <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="1">
                    <label class="form-check-label" for="exampleRadios2">
                        SSD
                    </label>
                </div>
            </div>
        </#if>
        <button class="btn btn-primary <#if product.isDrive()>mt-3</#if>" type="submit">Добавить <#if product.isMotherboard()>материнскую плату<#elseif product.isDrive()>диск<#elseif product.isProcessor()>процессор<#elseif product.isRam()>оперативную память<#else>видеокарту</#if></button>
    </form>
</@c.page>