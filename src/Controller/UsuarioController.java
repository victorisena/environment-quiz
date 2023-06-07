package Controller;

import Model.Usuario;

public class UsuarioController {
    
    Usuario usuario = new Usuario();
    
    public boolean cadastrarUsuario(String nome, String sobrenome, int idade, String rg, 
            String cpf, String agencia, String conta, String banco, String telefone, String login, String email, String senha)
    {
        if(nome != null && sobrenome != null && idade >= 18 && rg != null && cpf != null && agencia != null && conta != null 
                && banco != null && login != null && email != null && senha != null)
        {
            String retorno = usuario.inserir(this.formataDado(nome, "nome"), this.formataDado(sobrenome, "sobrenome"), 
                    idade,this.formataDado(rg, "rg"), this.formataDado(cpf, "cpf"), this.formataDado(agencia, "agencia"), 
                    this.formataDado(conta, "conta"), this.formataDado(banco, "banco"), this.formataDado(telefone, "telefone"), 
                    this.formataDado(login, "login"), this.formataDado(email, "email"), this.formataDado(senha, "senha"));
            
            if(retorno == "OK")
            {
                return true;
            }
            
            return false;
        }
        
        return false;
    }
    
    public String formataDado(String dado, String tipoDado){
        switch(tipoDado)
        {
            case "nome":
                return dado.trim();
            case "sobrenome":
                return dado.trim();
            case "rg":
                String rg = dado.trim();
                if(rg.contains("."))
                {
                    rg = rg.replace(".", "");
                }
                if(rg.contains("-"))
                {
                    rg = rg.replace("-", "");
                }
                
                return rg;
            case "cpf":
                String cpf = dado.trim();
                if(cpf.contains("."))
                {
                    cpf = cpf.replace(".", "");
                }
                if(cpf.equals("-"))
                {
                    cpf = cpf.replace("-", "");
                }
                
                return cpf;
                
            case "agencia":
                return dado.trim();
                
            case "conta":
                String conta = dado.trim();
                if(conta.contains("."))
                {
                    conta = conta.replace(".", "");
                }
                if(conta.contains("-"))
                {
                    conta = conta.replace("-", "");
                }
                
                return conta;
                
            case "banco":
                String banco = dado.trim();
                if(banco.contains("."))
                {
                    banco = banco.replace(".", "");
                }
                if(banco.contains("-"))
                {
                    banco = banco.replace("-", "");
                }
                
                return banco;
                
            case "telefone":
                String telefone = dado.trim();
                if(telefone.contains("."))
                {
                    telefone = telefone.replace(".", "");
                }
                if(telefone.contains("-"))
                {
                    telefone = telefone.replace("-", "");
                }
                
                return telefone;
            case "login":
                return dado.trim();
                
            case "email":
                return dado.trim();
                
            case "senha":
                return dado.trim();
                
            default:
                return "";
        }
    }
    
    public boolean loginUsuario(String login, String senha)
    {
        if(login != null && senha != null){
            String retorno = usuario.login(login.trim(), senha);
            
            if(retorno == "OK"){
                return true;
            }
            
            return false;
        }
        
        return false;
    }
    
    public String[] getDadosUsuarioByLogin(String login, String senha){
        String[] usuarioLogado = new String[10];
        if(this.loginUsuario(login, senha))
        {
            usuarioLogado = usuario.getUsuarioByLogin(login, senha);
            
            return usuarioLogado;
        }
        return usuarioLogado;
    }
}
