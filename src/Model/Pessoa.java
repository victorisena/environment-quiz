package Model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Pessoa {
    private int id;
    private String nome;
    private String sobrenome;
    private int idade;
    private String cpf;
    private String rg;
    private String agencia;
    private String conta;
    private String banco;
    private String telefone;
    private static int ultimoId = 0;
    
    private static ArrayList<Pessoa> listaPessoas = new ArrayList();
    
    public Pessoa(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome.length() > 2)
        {
            this.nome = nome;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "O nome deve ter no mínimo 3 caracteres.");
            throw new RuntimeException("O nome deve ter no mínimo 3 caracteres.");
        }
        
    }
    
    public String getSobrenome() {
        return sobrenome;
    }

    public static ArrayList<Pessoa> getListaPessoas() {
        return listaPessoas;
    }

    public void setSobrenome(String sobrenome) {
        if(sobrenome.length() >= 4)
        {
            this.sobrenome = sobrenome;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "O sobrenome deve ter no mínimo 4 caracteres.");
            throw new RuntimeException("O sobrenome deve ter no mínimo 4 caracteres.");
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if(idade >= 18){
            this.idade = idade;
        }
        else{
            JOptionPane.showMessageDialog(null, "É necessário ser maior de idade para se cadastrar.");
            throw new RuntimeException("A idade deve ser maior ou igual a 18.");
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(this.validaCpf(cpf))
        {
            if(cpf.length() == 11)
            {
                this.cpf = cpf;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "O cpf deve ter 11 dígitos.");
                throw new RuntimeException("O cpf deve ter 11 digitos.");
            }
        }
        
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
         if(this.validaRg(rg))
        {
            if(rg.length() == 9)
            {
                this.rg = rg;
            }
            else
            {
               JOptionPane.showMessageDialog(null, "O rg deve ter 9 dígitos.");
               throw new RuntimeException("O rg deve ter 9 digitos."); 
            }
        }
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        if(banco != null){
            this.banco = banco;    
        }
        else{
            JOptionPane.showMessageDialog(null, "Erro ao inserir o banco");
        }
    }

    public String getAgencia() {
        return agencia;
    }
    
    public void setAgencia(String agencia) {
        if(agencia.length() > 2 && agencia.length() <= 4){
            if(agencia.length() == 3)
            {
                agencia+="0";
            }
            
            this.agencia = agencia;
        }
        else{
            JOptionPane.showMessageDialog(null, "A agência deve ter no mínimo 3 digitos, insira novamente o valor da agência.");
            throw new RuntimeException("A agência deve ter 4 digitos."); 
        }
        
    }
    
    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        if(conta.length() >= 4)
        {
            this.conta = conta;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "A conta deve ter no mínimo 4 dígitos.");
            throw new RuntimeException("A conta deve ter no mínimo 4 dígitos."); 
        }
        
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
         if(this.validaTelefone(telefone))
        {
            if(telefone.length() >= 9)
            {
                this.telefone = telefone;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "O telefone deve ter no mínimo 9 dígitos.");
                throw new RuntimeException("O telefone deve ter no mínimo 9 dígitos."); 
            }   
        }
    }
    
    public ArrayList<Pessoa> getPessoaById(int idPessoa){
        ArrayList<Pessoa> listaPessoaById = new ArrayList<>();
        
        for(Pessoa item : listaPessoas){
            if(item.getId() == idPessoa){
                listaPessoaById.add(item);
                return listaPessoaById;
            }
        }
        return listaPessoaById;
    }
    
     protected String inserir(String _nome, String _sobrenome ,int _idade, String _cpf, String _rg, String _agencia, 
             String _conta, String _banco, String _telefone)
    {
        try
        {
            if(_nome != null && _sobrenome != null && _cpf != null && _rg != null)
            {
                Pessoa pessoa = new Pessoa();

                pessoa.setId(ultimoId);
                pessoa.setNome(_nome);
                pessoa.setSobrenome(_sobrenome);
                pessoa.setIdade(_idade);
                pessoa.setCpf(_cpf);
                pessoa.setRg(_rg);
                pessoa.setAgencia(_agencia);
                pessoa.setConta(_conta);
                pessoa.setBanco(_banco);
                pessoa.setTelefone(_telefone);

                ultimoId += 1;

                listaPessoas.add(pessoa);
                
                return "OK";
            }
            
            return "Erro";
        }
        catch(Exception error)
        {
            return "Erro: " + error.getMessage();
        }
    }
     
    public boolean validaCpf(String cpf)
    {
        for(Pessoa itemPessoa : listaPessoas)
        {
            if(itemPessoa.getCpf().equals(cpf))
            {
                JOptionPane.showMessageDialog(null, "Cpf já cadastrado.");
                throw new RuntimeException("Cpf já cadastrado.");
            }
        }
        return true;
    }
    
    public boolean validaRg(String rg)
    {
        for(Pessoa itemPessoa : listaPessoas)
        {
            if(itemPessoa.getRg().equals(rg))
            {
                JOptionPane.showMessageDialog(null, "Rg já cadastrado.");
                throw new RuntimeException("Rg já cadastrado.");
            }
        }
        return true;
    }
    
    
    public boolean validaTelefone(String telefone)
    {
        for(Pessoa itemPessoa : listaPessoas)
        {
            if(itemPessoa.getTelefone().equals(telefone))
            {
                JOptionPane.showMessageDialog(null, "Telefone já cadastrado.");
                throw new RuntimeException("Telefone já cadastrado.");
            }
        }
        return true;
    }
}
