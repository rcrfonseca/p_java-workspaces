package persistencia;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dominio.Veiculo;

public class VeiculoDAO
	{
		private Session session;

		public VeiculoDAO(Session session)
			{
				this.session = session;
			}

		public void incluir(Veiculo Veiculo)
			{
				Transaction transaction = session.beginTransaction();
				transaction.begin();
				session.save(Veiculo);
				transaction.commit();
			}

		public Veiculo obter(String placa)
			{
				Query query = session
						.createQuery("from Veiculo where placa = :placa ");
				query.setParameter("placa", placa);
				return (Veiculo) query.uniqueResult();
			}

		public void alterar(Veiculo Veiculo)
			{
				Transaction transaction = session.beginTransaction();
				transaction.begin();
				session.saveOrUpdate(Veiculo);
				transaction.commit();
			}

		public Veiculo obter(Long id)
			{
				return (Veiculo) session.load(Veiculo.class, id);
			}

		public List<Veiculo> listarTodos()
			{
				return session.createQuery("from Veiculo").list();
			}

		public void remover(Veiculo Veiculo)
			{
				Transaction transaction = session.beginTransaction();
				transaction.begin();
				session.delete(Veiculo);
				transaction.commit();
			}

	}