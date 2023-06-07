package Model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Usuario extends Pessoa{
    
    private int id;
    private String login;
    private String email;
    private String senha;

    public static int getUltimoId() {
        return ultimoId;
    }

    public static void setUltimoId(int UltimoId) {
        ultimoId = UltimoId;
    }
    
    private static ArrayList<Usuario> listaUsuarios = new ArrayList();
    private static int ultimoId = 0;
    
    public Usuario(){
        
    }
    
//    public Usuario(String _login, String _email, String _senha)
//    {
//        Usuario usuario = new Usuario();
//        
//        usuario.setId(ultimoId);
//        usuario.setEmail(_email);
//        usuario.setLogin(_login);
//        usuario.setSenha(_senha);
//        
//        ultimoId += 1;
//        
//        listaUsuarios.add(usuario);
//    }
    
   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if(this.validaNomeLogin(login))
        {
            if(login.length() >= 4)
            {
                this.login = login;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "O login deve ter no mínimo 4 caracteres.");
                throw new RuntimeException("O login deve ter no mínimo 4 caracteres.");
            }
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(this.validaNomeLogin(login))
        {
            if(email.length() > 10)
            {
                if(email.indexOf("@") > 0)
                {
                    this.email = email;   
                }
                else
                {
                    throw new RuntimeException("O email fora do padrão.");
                }
            }
            else
            {
                throw new RuntimeException("O email deve ter no mínimo 10 caracteres.");
            }
        }
        
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if(senha.length() >= 4)
        {
            this.senha = senha;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "O senha deve ter no mínimo 4 caracteres.");
            throw new RuntimeException("O senha deve ter no mínimo 4 caracteres.");
        }
    }

    public static ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    
    public String login(String login, String senha)
    {
        
        try
        {
            if(login != null && senha != null){
                
                for(Usuario item : listaUsuarios){
                    
                    if(item.getLogin().equals(login) && item.getSenha().equals(senha))
                    {
                        return "OK";
                    }
                }
                
                return "Erro";
            }
            else
            {
                throw new IllegalArgumentException("O Login/senha vazio.");
            }   
        }
        catch(RuntimeException error){
            return error.getMessage();
        }
    }
    
    public String inserir(String nome, String sobrenome, int idade, String rg, String cpf, String agencia, String conta, 
            String banco, String telefone, String login, String email, String senha)
    {
        try
        {
            if(super.validaCpf(cpf) && super.validaRg(rg) && super.validaTelefone(telefone) && validaEmail(email) 
                    && validaNomeLogin(login))
            {
                String retorno = super.inserir(nome, sobrenome, idade, cpf, rg, agencia, conta, banco, telefone);
                
                if(retorno == "OK")
                {
                    Usuario usuario = new Usuario();

                    usuario.setId(ultimoId);
                    usuario.setEmail(email);
                    usuario.setLogin(login);
                    usuario.setSenha(senha);

                    ultimoId += 1;

                    listaUsuarios.add(usuario);

                    return "OK";
                }
            
                return "Erro";
            }
            
            return "Erro";
        }
        catch(RuntimeException error)
        {
            return "Erro: " + error.getMessage();
        }
    }
    
    public String[] getUsuarioByLogin(String login, String senha){
        try
        {
            if(login != null && senha != null){
                
                String[] usuarioLogado = new String[10];
                
                for(Usuario itemUsuario : listaUsuarios)
                {
                    if(itemUsuario.getLogin().equals(login) && itemUsuario.getSenha().equals(senha))
                    {
                        ArrayList<Pessoa> listaPessoa = super.getPessoaById(itemUsuario.getId());
                        if(listaPessoa.size() > 0)
                        {
                            for(Pessoa itemPessoa : listaPessoa)
                            {
                                usuarioLogado[0] = Integer.toString(itemPessoa.getId());
                                usuarioLogado[1] = itemPessoa.getNome();
                                usuarioLogado[2] = itemPessoa.getSobrenome();
                                usuarioLogado[3] = Integer.toString(itemPessoa.getIdade());
                                usuarioLogado[4] = itemPessoa.getCpf();
                                usuarioLogado[5] = itemPessoa.getRg();
                                usuarioLogado[6] = itemPessoa.getAgencia();
                                usuarioLogado[7] = itemPessoa.getConta();
                                usuarioLogado[8] = itemPessoa.getBanco();
                                usuarioLogado[9] = itemPessoa.getTelefone();
                                
                                return usuarioLogado;
                            }
                        }
                    }
                }
                
                return usuarioLogado;
            }
            else
            {
                throw new IllegalArgumentException("O Login/senha vazio.");
            }   
        }
        catch(RuntimeException error){
            String[] erroCausado = new String[1];
            erroCausado[0] = error.getMessage();
            return erroCausado;
        }
    }
    
    public boolean validaNomeLogin(String login)
    {
        for(Usuario itemUsuario : listaUsuarios)
        {
            if(itemUsuario.getLogin().equals(login))
            {
                JOptionPane.showMessageDialog(null, "Nome de login já existente.");
                throw new RuntimeException("Nome de login já existente.");
            }
        }
        return true;
    }
    
    public boolean validaEmail(String email)
    {
        for(Usuario itemUsuario : listaUsuarios)
        {
            if(itemUsuario.getEmail().equals(email))
            {
                JOptionPane.showMessageDialog(null, "Email já cadastrado.");
                throw new RuntimeException("Email já cadastrado.");
            }
        }
        return true;
    }
    
}

