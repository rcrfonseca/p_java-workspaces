package uni.jsf.controle;

import uni.jsf.dominio.Usuario;

public class SessaoMB
{
	private Usuario usuario = new Usuario();

	public Usuario getUsuario()
	{
		return usuario;
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}

}