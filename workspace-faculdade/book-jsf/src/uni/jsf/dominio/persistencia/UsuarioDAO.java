package uni.jsf.dominio.persistencia;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import uni.jsf.dominio.Usuario;

public class UsuarioDAO
{
	private Session	session;


	public UsuarioDAO(Session session)
	{
		this.session = session;
	}


	public void incluir(Usuario usuario)
	{
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		session.save(usuario);
		transaction.commit();
	}


	public Usuario obter(String login)
	{
		Query query = session.createQuery("from Usuario where login = :login ");
		query.setParameter("login", login);
		return (Usuario) query.uniqueResult();
	}


	public void alterar(Usuario user)
	{
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		session.saveOrUpdate(user);
		transaction.commit();
	}


	public Usuario obter(Long id)
	{
		return (Usuario) session.load(Usuario.class, id);
	}


	public List<Usuario> listarTodos()
	{
		return session.createQuery("from Usuario").list();
	}


	public void remover(Usuario user)
	{
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		session.delete(user);
		transaction.commit();
	}

}
