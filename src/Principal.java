import java.io.IOException;
import java.util.Scanner;

public class Principal {
        public static void main(String[] args)  {
                Scanner leitura = new Scanner(System.in);
                ConsultacEP consultacEP = new ConsultacEP();
                boolean continuar = true;
 
                while (continuar) {

                        System.out.println("Digite um número de CEP para consulta ou 'sair' para encerrar ");
                        var cep = leitura.nextLine();

                        if(cep.equalsIgnoreCase("sair")){
                                continuar = false;
                                break;
                        }

                        if (cep.length() < 8) {
                                System.out.println("Digite um número de 8 dígitos");
                        }

                        try {
                                Endereco novoEndereco = consultacEP.buscaEndereco(cep);
                                System.out.println(novoEndereco);
                                GeradorDeArquivo gerador = new GeradorDeArquivo();
                                gerador.salvaJson(novoEndereco);
                        } catch (RuntimeException | IOException e) {
                                System.out.println(e.getMessage());
                                System.out.println("Não consegui obter o endereço a partir deste CEP. " +
                                        "Finalizando a aplicação");
                        }
                }
        }
}
