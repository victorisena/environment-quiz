package Controller;

import Model.MeioAmbiente;
import java.util.ArrayList;

public class MeioAmbienteController {
    MeioAmbiente perguntas = new MeioAmbiente();
    
    public boolean inserirPerguntas(){
        
        try
        {
            if(perguntas.getListaMeioAmbiente().size() == 0)
            {
            
                String tituloPrimeira = "Qual a floresta mais devastadas do Brasil ?";
                String[] alternativasPrimeira = new String[4];
                int alternativaCorretaPrimeira = 1;

                alternativasPrimeira[0] = "Pantanal";
                alternativasPrimeira[1] = "Mata Atlântica";
                alternativasPrimeira[2] = "Amazônica";
                alternativasPrimeira[3] = "Caatinga";

                String retPrimeiraPergunta = perguntas.inserir(tituloPrimeira, alternativasPrimeira, alternativaCorretaPrimeira);

                String tituloSegunda = "Na Floresta Amazônica há a maior espécie de cobra do mundo, qual o nome dela?";
                String[] alternativasSegunda =  new String[4];
                int alternativaCorretaSegunda = 3;

                alternativasSegunda[0] = "Mamba-Negra";
                alternativasSegunda[1] = "Naja";
                alternativasSegunda[2] = "Jararaca";
                alternativasSegunda[3] = "Sucuri";

                String retSegundaPergunta = perguntas.inserir(tituloSegunda, alternativasSegunda, alternativaCorretaSegunda);

                String tituloTerceira = "O desmatamento da floresta Amazônica por dia equivale a quantos campos de futebol?";
                String[] alternativasTerceira =  new String[4];
                int alternativaCorretaTerceira = 0;

                alternativasTerceira[0] = "1.900";
                alternativasTerceira[1] = "7.000";
                alternativasTerceira[2] = "1.580";
                alternativasTerceira[3] = "15.000";

                String retTerceiraPergunta = perguntas.inserir(tituloTerceira, alternativasTerceira, alternativaCorretaTerceira);

                String tituloQuarta = "Quais desses animais não faz parte da flora amazônica?";
                String[] alternativasQuarta = new String[4];
                int alternativaCorretaQuarta = 1;

                alternativasQuarta[0] = "Boto";
                alternativasQuarta[1] = "Puma";
                alternativasQuarta[2] = "Capivara";
                alternativasQuarta[3] = "Sapo-Cururu";

                String retQuartaPergunta = perguntas.inserir(tituloQuarta, alternativasQuarta, alternativaCorretaQuarta);

                String tituloQuinta = "Em media qual a temperatura do planeta terra?";
                String[] alternativasQuinta =  new String[4];
                int alternativaCorretaQuinta = 2;

                alternativasQuinta[0] = "150°C";
                alternativasQuinta[1] = "-20°C";
                alternativasQuinta[2] = "15°C";
                alternativasQuinta[3] = "1000°C";

                String retQuintaPergunta = perguntas.inserir(tituloQuinta, alternativasQuinta, alternativaCorretaQuinta);

                if(retPrimeiraPergunta == "OK" && retSegundaPergunta == "OK" && retTerceiraPergunta == "OK" && retQuartaPergunta == "OK" && retQuintaPergunta == "OK")
                {
                    return true;
                }
                
                return false;
            }
            
            return true;
        }
        catch(Exception error)
        {
            String erro = error.getMessage();
            return false;
        }
        
    }
    
    public String getTituloPergunta(int numeroPergunta){
        ArrayList<MeioAmbiente> listaPergunta = perguntas.getPerguntaById(numeroPergunta);
        String tituloPergunta = null;
        if(listaPergunta.size() > 0)
        {
            for(MeioAmbiente item : listaPergunta)
            {
               tituloPergunta = item.getTitulo();
            }
        }
        
        return tituloPergunta;
    }
    
    public String[] getAlternativasPergunta(int numeroPergunta){
        ArrayList<MeioAmbiente> listaPergunta = perguntas.getPerguntaById(numeroPergunta);
        String[] alternativas = new String[8];
        if(listaPergunta.size() > 0){
            for(MeioAmbiente item : listaPergunta)
            {
                alternativas = item.getAlternativas();
            }
        }
        
        return alternativas;
    }
    
    public int getAlternativasCorreta(int numeroPergunta){
        ArrayList<MeioAmbiente> listaPergunta = perguntas.getPerguntaById(numeroPergunta);
        int alternativaCorreta = 0;
        if(listaPergunta.size() > 0)
        {
            for(MeioAmbiente item : listaPergunta)
            {
                alternativaCorreta = item.getAlternativaCorreta();
            }
        }
        else
        {
            alternativaCorreta = -1;
        }
        
        return alternativaCorreta;
    }
    
    public boolean validaAlternativa(int numeroPergunta, int alternativaSelecionada){
        ArrayList<MeioAmbiente> listaPergunta = new ArrayList();
        listaPergunta = perguntas.getPerguntaById(numeroPergunta);
        
        for(MeioAmbiente item : listaPergunta)
        {
            if(item.getAlternativaCorreta() == alternativaSelecionada){
                return true;
            }
        }
        
        return false;
    }
}

