import java.util.ArrayList;
import java.util.Random;

public class Aula3 {

    public static class Ordenacao {

        public static void bolha(ArrayList<Integer> lista) {
            int n = lista.size();
            int comparacoes = 0;
            int trocas = 0;

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {

                    comparacoes++;

                    if (lista.get(j) > lista.get(j + 1)) {
                        int temp = lista.get(j);
                        lista.set(j, lista.get(j + 1));
                        lista.set(j + 1, temp);

                        trocas++;
                    }
                }
            }

            System.out.println("Bubble Sort:");
            System.out.println("Comparações: " + comparacoes);
            System.out.println("Trocas: " + trocas);
        }

        public static void selecao(ArrayList<Integer> lista) {
            long n = lista.size();
            long comparacoes = 0;
            long trocas = 0;

            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;

                for (int j = i + 1; j < n; j++) {

                    comparacoes++;

                    if (lista.get(j) < lista.get(minIndex)) {
                        minIndex = j;
                    }
                }

                if (minIndex != i) {
                    int temp = lista.get(minIndex);
                    lista.set(minIndex, lista.get(i));
                    lista.set(i, temp);

                    trocas++;
                }
            }

            System.out.println("Selection Sort:");
            System.out.println("Comparações: " + comparacoes);
            System.out.println("Trocas: " + trocas);
        }

        public static void insercao(ArrayList<Integer> lista) {
            int n = lista.size();
            int comparacoes = 0;
            int trocas = 0;

            for (int i = 1; i < n; i++) {
                int key = lista.get(i);
                int j = i - 1;

                while (j >= 0) {

                    comparacoes++;

                    if (lista.get(j) > key) {
                        lista.set(j + 1, lista.get(j));
                        trocas++;
                        j--;
                    } else {
                        break;
                    }
                }

                lista.set(j + 1, key);
            }

            System.out.println("Insertion Sort:");
            System.out.println("Comparações: " + comparacoes);
            System.out.println("Trocas: " + trocas);
        }
    }

    public static class Util {

        public static void popularLista(ArrayList<Integer> lista, int quantidade) {
            Random gerador = new Random();

            for (int i = 0; i < quantidade; i++) {
                lista.add(gerador.nextInt(100));
            }
        }

        public static void exibirLista(ArrayList<Integer> lista) {
            for (int i = 0; i < lista.size(); i++) {
                System.out.print(lista.get(i) + " ");
            }

            System.out.println();
        }

        public static void exibirTempoExecucao(long tempo) {
            System.out.println("Tempo de execução: " + tempo + " nanosegundos");
        }
    }

    public static class Principal {

        public static void main(String[] args) {

            ArrayList<Integer> listaBolha = new ArrayList<>();
            ArrayList<Integer> listaSelecao = new ArrayList<>();
            ArrayList<Integer> listaInsercao = new ArrayList<>();

            int quantidade;

            System.out.println("Quantos números deseja trabalhar?");

            try {
                quantidade = Integer.parseInt(System.console().readLine());

                Util.popularLista(listaBolha, quantidade);
                Util.popularLista(listaSelecao, quantidade);
                Util.popularLista(listaInsercao, quantidade);

              
                long startTime = System.nanoTime();

                Ordenacao.bolha(listaBolha);

                long elapsedTime = System.nanoTime() - startTime;

                Util.exibirTempoExecucao(elapsedTime);

                System.out.println();

                
                long startTime2 = System.nanoTime();

                Ordenacao.selecao(listaSelecao);

                long elapsedTime2 = System.nanoTime() - startTime2;

                Util.exibirTempoExecucao(elapsedTime2);

                System.out.println();

               
                long startTime3 = System.nanoTime();

                Ordenacao.insercao(listaInsercao);

                long elapsedTime3 = System.nanoTime() - startTime3;

                Util.exibirTempoExecucao(elapsedTime3);
            }
            catch (NumberFormatException e) {
                System.out.println("Mensagem de erro: " + e.getMessage());
                return;
            }
        }
    }
}