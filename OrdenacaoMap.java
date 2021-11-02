package br.com.one.innovation.dio.Map;



/*
        Dados as seguinte informações sobre meus livros favoritos e seus autores,
        crie um dicionário e ordene  , exibindo ( nome autor - nome livro);

        Autor = Hawking,Stephen - Livro = nome: Uma Breve História do Tempo. paginas:256
        Autor = Duhigg, Charles - LIVRO = nome: O Poder do Hábito, paginas:408
        Autor = Harari, Yuval Noah - Livro = 21 Lições Para o Seéculo 21, pagina :432;

        */

import java.util.*;

public class OrdenacaoMap {

    public static void main(String[] args) {


        System.out.println("\tOrdem Aleatoria");

        Map<String, Livro> meusLivros = new HashMap<>() {{
            put("Hawking,Stephen ", new Livro("Uma Breve História do tempo ", 256));
            put("Duhigg, Charles ", new Livro("O Poder do Hábito ", 408));
            put("Harari, Yuval Noah ", new Livro("21 Lições para o século  21 ", 432));
        }};
        for (Map.Entry<String, Livro> livro : meusLivros.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());


        System.out.println("\tOrdem Inserção");

        Map<String, Livro> meusLivros1 = new LinkedHashMap<>() {{
            put("Hawking , Stephen", new Livro("Uma Breve História do Tempo", 256));
            put("Duhigg, Charles ", new Livro("O Poder do Hábito ", 408));
            put("Harari, Yuval Noah ", new Livro("21 Lições para o século  21 ", 256));
        }};
        for (Map.Entry<String, Livro> livro : meusLivros1.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());


        System.out.println("\tOrdem Alfabetea autores");
        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
        for (Map.Entry<String, Livro> livro : meusLivros2.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("\tOrdem Alfabetea dos livros");
        Set<Map.Entry<String, Livro>> meusLivro3 = new TreeSet<>(new ComparatorNome());
        meusLivro3.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivro3)
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("\tOrdem numero de  pagina");

        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorPagina());
        meusLivros4.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivros4)
            System.out.println(livro.getKey() + " - " + livro.getValue().getPaginas());

    }


}


class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) &&
                paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome: '" + nome + '\'' +
                ", paginas = " + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}
class ComparatorPagina implements Comparator<Map.Entry<String,Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getPaginas().compareTo(l2.getValue().getPaginas());
    }
}