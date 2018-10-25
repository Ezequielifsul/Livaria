<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecalho.jsp" %>
            <div class="card">
              <div class="card-header">
                <h5 class="title">Editar Livro</h5>
              </div>
              <div class="card-body">
                  <!--MODIFICAR PARA ADD-->
                  <form action="LivroWS" method="POST">
                  <div class="row">
                    <div class="col-md-3 pr-md-1">
                      <div class="form-group">
                        <label>Id</label>
                        <input type="text" class="form-control" name="txtId" placeholder="Id" value="${obj.id}" readonly="true">
                      </div>
                    </div>
                      <div class="col-md-5 pr-md-1">
                    <div class="form-group">
                        <label>Titulo</label>
                        <input type="text" name="txtTitulo" required class="form-control" placeholder="Titulo" value="${obj.titulo}" >
                    </div>
                </div>
                <div class="col-md-5 pr-md-1">
                    <div class="form-group">
                        <label>Genero</label>
                        <input type="text" name="txtgenero" required class="form-control" placeholder="Genero" value="${obj.genero.genero}" >
                    </div>
                </div>
                <div class="col-md-5 pr-md-1">
                    <div class="form-group">
                        <label>Autor</label>
                        <input type="text" name="txtAutor" required class="form-control" placeholder="Autor" value="${obj.autor.nomeA}" >
                    </div>
                </div>
                <div class="col-md-5 pr-md-1">
                    <div class="form-group">
                        <label>Editora</label>
                        <input type="text" name="txtEditora" required class="form-control" placeholder="Editora" value="${obj.editora.nomeE}">
                    </div>
                </div>
                <div class="col-md-5 pr-md-1">
                    <div class="form-group">
                        <label>Numero de Paginas</label>
                        <input type="number" name="txtNumPag" required class="form-control" placeholder="Numero de paginas" value="${obj.numPag}" >
                    </div>
                </div>
                <div class="col-md-5 pr-md-1">
                    <div class="form-group">
                        <label>Classificação</label>
                        <input type="text" name="txtClas" required class="form-control" placeholder="Classificação" value="${obj.classificacao.clas}">
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