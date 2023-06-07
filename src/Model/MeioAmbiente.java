package Model;
import java.util.ArrayList;

public class MeioAmbiente extends Perguntas
{
    private int id;
    private String titulo;
    private String[] alternativas = new String[4];
    private int alternativaCorreta;
    private static int ultimoId = 0;
    private static ArrayList<MeioAmbiente> listaMeioAmbiente = new ArrayList();

    public MeioAmbiente(){
        
    }
    
    @Override
    public int getId() {
        return id;
    }
    
    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String[] getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(String[] alternativas) {
        this.alternativas = alternativas;
    }
    
    @Override
    public int getAlternativaCorreta() {
        return alternativaCorreta;
    }
    
    public void setAlternativaCorreta(int alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }
    
    public ArrayList<MeioAmbiente> getListaMeioAmbiente(){
        return listaMeioAmbiente;
    }
    
    @Override
    public String inserir(String titulo, String[] alternativas, int alternativaCorreta)
    {
        try
        {
            if(titulo != null && alternativaCorreta >= 0)
            {
                MeioAmbiente meioAmbiente = new MeioAmbiente();
                
                meioAmbiente.setId(ultimoId);
                meioAmbiente.setTitulo(titulo);
                meioAmbiente.setAlternativas(alternativas);
                meioAmbiente.setAlternativaCorreta(alternativaCorreta);
                
                listaMeioAmbiente.add(meioAmbiente);
                
                ultimoId += 1;
                
                return "OK";
            }
            
            return "Erro";
        }
        catch(Exception error)
        {
            return "Erro: " + error.getMessage();
        }
    }
    
    @Override
    public String excluir(int idPergunta)
    {
        try
        {
            if(idPergunta >= 0)
            {
                for(MeioAmbiente item : listaMeioAmbiente)
                {
                    if(item.getId() == idPergunta)
                    {
                        listaMeioAmbiente.remove(item);
                        return "OK";
                    }
                }
            }
            return "Erro";
        }
        catch(Exception error)
        {
            return "Erro : " + error.getMessage();
        }
    }
    
    public ArrayList<MeioAmbiente> getPerguntaById(int idPergunta)
    {
        ArrayList<MeioAmbiente> listaMeioAmbienteById = new ArrayList();
        try
        {
            if(idPergunta >= 0)
            {
                for(MeioAmbiente item : listaMeioAmbiente)
                {
                    if(item.getId() == idPergunta)
                    {
                        listaMeioAmbienteById.add(item);
                        
                        return listaMeioAmbienteById;
                    }
                }
            }
            return listaMeioAmbienteById;
        }
        catch(Exception error)
        {
            String erro = "Erro : " + error.getMessage();
            
            return listaMeioAmbienteById;
        }
    }

    
}
