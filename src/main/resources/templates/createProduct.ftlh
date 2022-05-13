<#import "parts/common.ftlh" as c>

<@c.page>

    <div class="accordion" id="accordionExample">
        <#-- Видеокарта -->
        <div class="card">
            <div class="card-header" id="headingOne">
                <h5 class="mb-0">
                    <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        Видеокарта
                    </button>
                </h5>
            </div>

            <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                <div class="card-body">
                    <form method="post">
                        <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
                        <input type="hidden" name="type" value = "videocard"/>
                        <div class="form-group">
                            <label for="exampleFormControlSelect1">Производитель</label>
                            <select name="company" class="form-control" id="exampleFormControlSelect1">
                                <option>Nvidia</option>
                                <option>AMD</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Модель</label>
                            <input type="text" name="model" class="form-control" id="exampleFormControlInput1" placeholder="Введите модель">
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Видеопамять</label>
                            <input type="text" name="memory" class="form-control" id="exampleFormControlInput1" placeholder="Введите количество видеопамяти">
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Частота</label>
                            <input type="text" name="clock" class="form-control" id="exampleFormControlInput1" placeholder="Введите частоту">
                        </div>
                        <button class="btn btn-primary" type="submit">Добавить видеокарту</button>
                    </form>
                </div>
            </div>
        </div>
        <#-- Проц -->
        <div class="card">
            <div class="card-header" id="headingTwo">
                <h5 class="mb-0">
                    <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                       Процессор
                    </button>
                </h5>
            </div>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                <div class="card-body">
                    <form method="post">
                        <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
                        <input type="hidden" name="type" value = "processor"/>
                        <div class="form-group">
                            <label for="exampleFormControlSelect1">Производитель</label>
                            <select name="company" type="text" class="form-control" id="exampleFormControlSelect1">
                                <option>Intel</option>
                                <option>AMD</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Модель</label>
                            <input type="text" name="model" class="form-control" id="exampleFormControlInput1" placeholder="Введите модель">
                        </div>
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
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Частота</label>
                            <input type="text" name="clock" class="form-control" id="exampleFormControlInput1" placeholder="Введите частоту">
                        </div>
                        <button class="btn btn-primary" type="submit">Добавить процессор</button>
                    </form>
                </div>
            </div>
        </div>
        <#--  Мать -->
        <div class="card">
            <div class="card-header" id="headingThree">
                <h5 class="mb-0">
                    <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                        Материнская плата
                    </button>
                </h5>
            </div>
            <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                <div class="card-body">
                    <form method="post">
                        <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
                        <input type="hidden" name="type" value = "motherboard"/>
                        <div class="form-group">
                            <label for="exampleFormControlSelect1">Производитель</label>
                            <select name="company" type="text" class="form-control" id="exampleFormControlSelect1">
                                <option>Asus</option>
                                <option>MSI</option>
                                <option>GIGABYTE</option>
                                <option>ASRock</option>
                                <option>Tyan</option>
                                <option>Biostar</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Модель</label>
                            <input type="text" name="model" class="form-control" id="exampleFormControlInput1" placeholder="Введите модель">
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Сокет</label>
                            <input type="text" name="socket" class="form-control" id="exampleFormControlInput1" placeholder="Введите сокет">
                        </div>
                        <button class="btn btn-primary" type="submit">Добавить материнскую плату</button>
                    </form>
                </div>
            </div>
        </div>
        <#-- Оперативка -->
        <div class="card">
            <div class="card-header" id="headingFour">
                <h5 class="mb-0">
                    <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                        Оперативная память
                    </button>
                </h5>
            </div>
            <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordionExample">
                <div class="card-body">
                    <form method="post">
                        <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
                        <input type="hidden" name="type" value = "ram"/>
                        <div class="form-group">
                            <label for="exampleFormControlSelect1">Производитель</label>
                            <select name="company" class="form-control" id="exampleFormControlSelect1">
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
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Модель</label>
                            <input type="text" name="model" class="form-control" id="exampleFormControlInput1" placeholder="Введите модель">
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Объем памяти</label>
                            <input type="text" name="memory" class="form-control" id="exampleFormControlInput1" placeholder="Введите количество памяти">
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Частота</label>
                            <input type="text" name="clock" class="form-control" id="exampleFormControlInput1" placeholder="Введите частоту">
                        </div>
                        <button class="btn btn-primary" type="submit">Добавить оперативную плату</button>
                    </form>
                </div>
            </div>
        </div>
        <#-- Диск-->
        <div class="card">
            <div class="card-header" id="headingFive">
                <h5 class="mb-0">
                    <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                        Диск
                    </button>
                </h5>
            </div>
            <div id="collapseFive" class="collapse" aria-labelledby="headingFive" data-parent="#accordionExample">
                <div class="card-body">
                    <form method="post">
                        <input type="hidden" name="_csrf" value = "${_csrf.token}"/>
                        <input type="hidden" name="type" value = "drive"/>
                        <div class="form-group">
                            <label for="exampleFormControlSelect1">Производитель</label>
                            <select name="company" class="form-control" id="exampleFormControlSelect1">
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
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Модель</label>
                            <input type="text" name="model" class="form-control" id="exampleFormControlInput1" placeholder="Введите модель">
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Объем памяти</label>
                            <input type="text" name="memory" class="form-control" id="exampleFormControlInput1" placeholder="Введите количество памяти">
                        </div>
                        <label class="form-check-label mb-3" for="exampleRadios1">
                            Тип диска
                        </label>
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
                        <button class="btn btn-primary mt-3" type="submit">Добавить диск</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</@c.page>