package Model;

public abstract class Perguntas{
    private int id;

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getTitulo();

    public abstract void setTitulo(String titulo);
    
    public abstract void setAlternativas(String[] alternativas);
    
    public abstract void setAlternativaCorreta(int alternativaCorreta);
    
    public abstract String[] getAlternativas();
    
    public abstract int getAlternativaCorreta();
    
    public abstract String inserir(String titulo, String[] alternativas, int alternativaCorreta);
    
    public abstract String excluir(int idPergunta);
    
}
