/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.AutorDAO;
import dao.ClasDAO;
import dao.EditoraDAO;
import dao.GeneroDAO;
import dao.LivroDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Autor;
import modelo.Classificacao;
import modelo.Editora;
import modelo.Genero;
import modelo.Livro;

/**
 *
 * @author dappo
 */
@WebServlet(name = "LivroWS", urlPatterns = {"/admin/genero/LivroWS"})
public class LivroWS extends HttpServlet {

    private LivroDAO dao;
    private Livro obj;
    private String pagina;
    private String acao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        acao = request.getParameter("acao");
        List<Livro> lista = null;
        String id;
        switch (String.valueOf(acao)) {
            case "add":
                request.setAttribute("listaA",this.listarA());
                request.setAttribute("listaG",this.listarG());
                request.setAttribute("listaE",this.listarE());
                request.setAttribute("listaC",this.listarE());
                pagina = "add.jsp";
                break;
            case "list":
                dao = new LivroDAO();
                if (request.getParameter("filtro") != null) {
                    try {
                        lista = dao.listar(request.getParameter("filtro"));
                    } catch (Exception ex) {
                        Logger.getLogger(LivroWS.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    lista = dao.listar();
                }
                //pra onde deve ser redirecionada a página
                pagina = "index.jsp";
                //passar a listagem para a página
                request.setAttribute("lista", lista);
                break;
            case "del":
                id = request.getParameter("id");
                dao = new LivroDAO();
                pagina = "index.jsp";
                obj = dao.buscarPorChavePrimaria(Long.parseLong(id));
                Boolean deucerto = dao.excluir(obj);
                if (deucerto) {
                    lista = dao.listar();
                    request.setAttribute("lista", lista);
                    request.setAttribute("msg", "Excluído com sucesso");
                } else {
                    request.setAttribute("msg", "Erro ao excluir");
                }
                break;
            case "edit":
                id = request.getParameter("id");
                dao = new LivroDAO();
                Livro obj = dao.buscarPorChavePrimaria(Long.parseLong(id));
                request.setAttribute("obj", obj);
                pagina = "edita.jsp";
                break;
            default:
                dao = new LivroDAO();
                if (request.getParameter("filtro") != null) {
                    try {
                        lista = dao.listar(request.getParameter("filtro"));
                    } catch (Exception ex) {
                        Logger.getLogger(LivroWS.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    lista = dao.listar();
                }
                //pra onde deve ser redirecionada a página
                pagina = "index.jsp";
                //passar a listagem para a página
                request.setAttribute("lista", lista);
                break;

        }
        RequestDispatcher destino = request.getRequestDispatcher(pagina);
        destino.forward(request, response);

    }

    public List<Genero> listarG() {
        GeneroDAO dao = new GeneroDAO();
        List<Genero> listaG = dao.listar();
        dao.fecharConexao();
        return listaG;
    }
    public List<Autor> listarA() {
        AutorDAO dao = new AutorDAO();
        List<Autor> listaA = dao.listar();
        dao.fecharConexao();
        return listaA;
    }
    public List<Editora> listarE() {
        EditoraDAO dao = new EditoraDAO();
        List<Editora> listaE = dao.listar();
        dao.fecharConexao();
        return listaE;
    }
    public List<Classificacao> listarC() {
        ClasDAO dao = new ClasDAO();
        List<Classificacao> listaC = dao.listar();
        dao.fecharConexao();
        return listaC;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg;
        //verificar campos obrigatórios
        if (request.getParameter("txtTitulo") == null) {
            msg = "Campos obrigatórios não informados";
        } else {
            dao = new LivroDAO();
            obj = new Livro();
            GeneroDAO daoG = new GeneroDAO();
            AutorDAO daoA = new AutorDAO();
            EditoraDAO daoE = new EditoraDAO();
            ClasDAO daoC = new ClasDAO();
            //preencho o objeto com o que vem do post

            Boolean deucerto;

            //se veio com a chave primaria então tem q alterar
            if (request.getParameter("txtId") != null) {
                obj = dao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("txtId")));
                obj.setTitulo(request.getParameter("txtTitulo"));
                Long idgenero = Long.parseLong(request.getParameter("txtGenero"));
                Genero g = daoG.buscarPorChavePrimaria(idgenero);
                obj.setGenero(g);
                Long idautor = Long.parseLong(request.getParameter("txtAutor"));
                Autor a = daoA.buscarPorChavePrimaria(idautor);
                obj.setAutor(a);
                Long ideditora = Long.parseLong(request.getParameter("txtEditora"));
                Editora e = daoE.buscarPorChavePrimaria(ideditora);
                obj.setEditora(e);
                Long idclas = Long.parseLong(request.getParameter("txtClas"));
                Classificacao c = daoC.buscarPorChavePrimaria(idclas);
                obj.setClassificacao(c);
                obj.setNumPag(Integer.parseInt(request.getParameter("txtNumPag")));
                
                deucerto = dao.alterar(obj);
                pagina = "edita.jsp";
            } else {
                obj.setTitulo(request.getParameter("txtTitulo"));
                deucerto = dao.incluir(obj);
                pagina = "add.jsp";
            }
            if (deucerto) {
                msg = "Operação realizada com sucesso";
            } else {
                msg = "Erro ao realizar a operação";
            }
        }
        dao.fecharConexao();
        request.setAttribute("msg", msg);
        RequestDispatcher destino = request.getRequestDispatcher(pagina);
        destino.forward(request, response);
    }

}
