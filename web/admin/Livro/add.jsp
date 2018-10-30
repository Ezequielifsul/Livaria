<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecalho.jsp" %>
<div class="card">
    <div class="card-header">
        <h5 class="title">Adiciona Livro</h5>
    </div>
    <div class="card-body">
        <!--MODIFICAR PARA ADD-->
        <form action="LivroWS" method="POST">
            <div class="row">
                <div class="col-md-5 pr-md-1">
                    <div class="form-group">
                        <label>Titulo</label>
                        <input type="text" name="txtTitulo" required class="form-control" placeholder="Titulo" >
                    </div>
                </div>
                <div class="col-md-5 pr-md-1">
                    <div class="form-group">
                        <label>Genero</label>
                        <select name="txtGenero">
                             <c:forEach var= "objG" items= "${listaG}">
                            <option value="${objG.id}">${obj.genero}</option>
                            </c:forEach>
                        </select>                   
                    </div>
                </div>
                <div class="col-md-5 pr-md-1">
                    <div class="form-group">
                        <label>Autor</label>
                        <select name="txtAutor">
                             <c:forEach var= "objA" items= "${listaA}">
                            <option value="${objA.id}">${objA.nomeA}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-5 pr-md-1">
                    <div class="form-group">
                        <label>Editora</label>
                        <select name="txtEditora">
                             <c:forEach var= "objE" items= "${listaE}">
                            <option value="${objE.id}">${objE.nomeE}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-5 pr-md-1">
                    <div class="form-group">
                        <label>Numero de Paginas</label>
                        <input type="number" name="txtNumPag" required class="form-control" placeholder="Numero de paginas" >
                    </div>
                </div>
                <div class="col-md-5 pr-md-1">
                    <div class="form-group">
                        <label>Classificação</label>
                        <select name="txtGenero">
                             <c:forEach var= "objC" items= "${listaC}">
                            <option value="${objC.id}">${objC.clas}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-7">
                    <div class="form-group-file">
                        <label for="file">Foto</label>
                        <input type="file" name="txtFoto" required class="form-control form-control-file">
                    </div>
                </div>
            </div>

            <button class="btn btn-primary btn-round text-center" type="submit">
                <i class="tim-icons icon-cloud-upload-94"></i> Salvar
            </button>
            <a class="btn btn-primary btn-round text-center" href="LivroWS?acao=list">
                <i class="tim-icons icon-bullet-list-67"></i> Listar
            </a>
        </form>
    </div>

    <div class="card-footer">
        <c:if test = "${not empty msg}">
            <div class="alert alert-primary alert-dismissible fade show" role="alert">
                ${msg}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <i class="tim-icons icon-simple-remove"></i>
                </button>
            </div>
        </c:if>
    </div>
</div>
</div>
<%@include file="../rodape.jsp" %>