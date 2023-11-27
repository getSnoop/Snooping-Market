import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Produtos> produtos = new ArrayList<>();
        List<Vendas> vendas = new ArrayList<>();
        boolean repetirgeral = true;
        Scanner scanner = new Scanner(System.in);
        int escolha;

        while (repetirgeral) {
            System.out.println(" =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" + "|   [Escolha o número para abrir seu menu!]");
            System.out.println("|   [1] Produtos                   [2] Vendas");
            System.out.println("V =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            escolha = scanner.nextInt();
            scanner.nextLine();
            if (escolha == 1) {
                System.out.println(" =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" + "[Escolha o número para realizar sua ação!]");
                System.out.println("|   [1] Cadastrar Produtos    [2] Retirar Cadastro    [3] Listar Produtos");
                System.out.println("|   [4] Pesquisar Produtos    [5] Retornar ao menu principal");
                System.out.println("V =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                escolha = scanner.nextInt();
                scanner.nextLine();
                if (escolha == 1) {
                    System.out.println("Primeiro, insira o nome");
                    String n = scanner.nextLine();
                    System.out.println("Escolha o código de seu item");
                    int c = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Agora insira o valor do produto");
                    double v = scanner.nextDouble();
                    System.out.println("Qual a categoria de seu produto?");
                    String ca = scanner.next();
                    System.out.println("Por fim, insira a quantidade do seu produto no estoque");
                    int u = scanner.nextInt();
                    scanner.nextLine();
                    Produtos produto = new Produtos(n, v, u, c, ca);
                    produtos.add(produto);
                    System.out.println("Seu produto foi registrado! \n" + "Nome: " + produto.getNome() + "\n Valor: " + produto.getValor() + "\n Unidades em estoque: " + produto.getUnidades());
                } else if (escolha == 2) {
                    System.out.println("Qual produto você quer retirar o cadastro? ");
                    String retirar = scanner.nextLine();
                    Iterator<Produtos> iterator = produtos.iterator();
                    while (iterator.hasNext()) {
                        Produtos produto = iterator.next();
                        if (produto.getNome().equals(retirar)) {
                            iterator.remove();
                            System.out.println("Produto " + retirar + " retirado");
                        }
                    }
                } else if (escolha == 3) {
                    for (Produtos produto : produtos) {
                        produto.listar();
                    }
                } else if (escolha == 4) {
                    boolean pesquisar;
                    pesquisar = true;
                    String tipo;
                    String resposta;
                    while (pesquisar) {
                        System.out.println("-----Pesquise seu produto-----");
                        System.out.println("(escolha [1] para nome e [2] para categoria)");
                        tipo = scanner.nextLine();
                        if (tipo.contains("1")) {
                            System.out.println("*Escreva o nome do produto:");
                            tipo = scanner.nextLine();
                            for (Produtos produto : produtos) {
                                if (produto.getNome().contains(tipo)) {
                                    produto.listar();
                                }
                            }
                        } else if (tipo.contains("2")) {
                            System.out.println("*Escreva a categoria do produto:");
                            tipo = scanner.nextLine();
                            for (Produtos produto : produtos) {
                                if (produto.getCategoria().contains(tipo)) {
                                    produto.listar();
                                }
                            }
                        }
                        System.out.println("=-=-=-=-=-=-=-=-=-= \n" + "Deseja  [1] pesquisar outro produto ou [2]Não pesquisar");
                        resposta = scanner.nextLine();
                        if (resposta.contains("2")) {
                            pesquisar = false;
                        }
                    }
                } else if (escolha == 5){
                    System.out.println("...");
                }
            } else if (escolha == 2) {
                System.out.println(" =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" + "[Escolha o número para realizar sua ação!]");
                System.out.println("|   [1] Comprar               [2] Listar Vendas       [3] Pesquisar Vendas");
                System.out.println("|   [4] Relatório de Vendas   [5] Retornar ao menu principal");
                System.out.println("V =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                escolha = scanner.nextInt();
                scanner.nextLine();
                if (escolha == 1) {
                    boolean adicionar = true;
                    double valor = 0;
                    int qtd;
                    String qtd2 = "";
                    String itens = "";
                    while (adicionar) {
                        System.out.println("Qual produto você deseja adicionar ao carrinho?");
                        String comprar = scanner.nextLine();
                        for (Produtos produto : produtos) {
                            if (comprar.equalsIgnoreCase(produto.getNome())) {
                                System.out.println("Qual quantidade você deseja?");
                                qtd = scanner.nextInt();
                                scanner.nextLine();
                                if (qtd <= produto.getUnidades()) {
                                    double amostra = valor + produto.getValor() * qtd;
                                    System.out.println("Isso adicionará " + produto.getValor() * qtd + " ao seu carrinho, que custará " + amostra);
                                    System.out.println("Confirmar item? [1]Sim, [2]Não");
                                    int confirma = scanner.nextInt();
                                    scanner.nextLine();
                                    if (confirma == 1) {
                                        produto.setUnidades(produto.getUnidades() - qtd);
                                        if (qtd2.equals("")) {
                                            qtd2 += qtd;
                                        } else {
                                            qtd2 = qtd2 + ", " + qtd;
                                        }
                                        valor += produto.getValor() * qtd;
                                        if (itens.equals("")) {
                                            itens = comprar;
                                        } else {
                                            itens = itens + ", " + comprar;
                                        }
                                        System.out.println("Seu carrinho contém os itens " + itens + " e está custando " + valor);
                                        System.out.println("Deseja [1] adicionar mais itens ou [2] podemos finalizar a compra?");
                                        confirma = scanner.nextInt();
                                        scanner.nextLine();
                                        if (confirma == 1) {
                                            System.out.println("Retornando a aba de busca!");
                                        } else if (confirma == 2) {
                                            String pagamento = "";
                                            System.out.println("Escolha seu método de pagamento. [1] Cartão, [2] Dinheiro, [3] Outro");
                                            confirma = scanner.nextInt();
                                            scanner.nextLine();
                                            if (confirma == 1) {
                                                pagamento = "Cartão";
                                            } else if (confirma == 2) {
                                                pagamento = "Dinheiro";
                                            } else if (confirma == 3) {
                                                System.out.println("Por favor digite o nome do método");
                                                pagamento = scanner.next();
                                            }
                                            LocalDate hora = LocalDate.now();
                                            Vendas venda = new Vendas(qtd2, valor, itens, hora, pagamento);
                                            vendas.add(venda);
                                            System.out.println("Venda finalizada!");
                                            adicionar = false;
                                        }
                                    } else if (confirma == 2) {
                                        System.out.println("Ok! produto cancelado! Deseja [1] adicionar outro produto ou [2] finalizar a compra? você também pode utilizar [3] para cancelar o carrinho");
                                        confirma = scanner.nextInt();
                                        scanner.nextLine();
                                        if (confirma == 1) {
                                            System.out.println("Retornando a aba de busca!");
                                        } else if (confirma == 2) {
                                            String pagamento = "";
                                            System.out.println("Escolha seu método de pagamento. [1] Cartão, [2] Dinheiro, [3] Outro");
                                            confirma = scanner.nextInt();
                                            scanner.nextLine();
                                            if (confirma == 1) {
                                                pagamento = "Cartão";
                                            } else if (confirma == 2) {
                                                pagamento = "Dinheiro";
                                            } else if (confirma == 3) {
                                                System.out.println("Por favor digite o nome do método");
                                                pagamento = scanner.next();
                                            }
                                            LocalDate hora = LocalDate.now();
                                            Vendas venda = new Vendas(qtd2, valor, itens, hora, pagamento);
                                            vendas.add(venda);
                                            System.out.println("Venda finalizada!");
                                            adicionar = false;
                                        } else if (confirma == 3) {
                                            adicionar = false;
                                            System.out.println("Retornando ao menu principal!");
                                        }
                                    }
                                } else if (qtd > produto.getUnidades()) {
                                    System.out.println("Estamos sem estoque no momento! o máximo para este item é de " + produto.getUnidades());
                                    System.out.println("Retornando a aba de busca...");
                                    Thread.sleep(3000);
                                }
                            }
                        }
                    }
                } else if (escolha == 2) {
                    for (Vendas venda : vendas) {
                        venda.listar();
                    }
                } else if (escolha == 3) {
                    boolean pesquisar;
                    pesquisar = true;
                    String tipo;
                    String resposta;
                    while (pesquisar) {
                        System.out.println("-----Pesquise a venda-----");
                        System.out.println("*Escreva o nome do produto:");
                        tipo = scanner.nextLine();
                        for (Vendas venda : vendas) {
                            if (venda.getItem().contains(tipo)) {
                                venda.listar();
                            }
                        }
                        System.out.println("Deseja [1] pesquisar outro produto ou [2] Não pesquisar");
                        resposta = scanner.nextLine();
                        if (resposta.contains("2")) {
                            pesquisar = false;
                        }
                    }
                } else if (escolha == 4) {
                    String itens = "";
                    int dinheiroGanho = 0;
                    int cartao = 0;
                    int dinheiro = 0;
                    int outro = 0;
                    String itensV = "";
                    System.out.println("Escolha a primeira data para o relatório (aaaa-mm-dd)");
                    String data1 = scanner.nextLine();
                    System.out.println("Escolha a segunda data para o relatório (aaaa-mm-dd)");
                    String data2 = scanner.nextLine();
                    LocalDate dt1 = LocalDate.parse(data1);
                    LocalDate dt2 = LocalDate.parse(data2);
                    for (Vendas venda : vendas) {
                        if (venda.getHora().isBefore(dt2) || venda.getHora().isEqual(dt2) && venda.getHora().isAfter(dt1) || venda.getHora().isEqual(dt1)) {
                            if (itens.equals("")) {
                                itens = venda.getItem();
                            } else {
                                itens = itens + ", " + venda.getItem();
                            }
                            dinheiroGanho += (int) venda.getValor();
                            if (venda.getPagamento().contains("Cartão")) {
                                cartao += 1;
                            } else if (venda.getPagamento().contains("Dinheiro")) {
                                dinheiro += 1;
                            } else {
                                outro += 1;
                            }
                            if (itensV.equals("")) {
                                itensV = venda.getQtd();
                            } else {
                                itensV = itensV + ", " + venda.getQtd();
                            }
                        }
                    }
                    System.out.println("Relatório finalizado!");
                    System.out.println("=-=Itens comprados: " + itens + "=-=");
                    System.out.println("=-=Quantidade de itens vendidos: " + itensV + "=-=");
                    System.out.println("*Formas de pagamento usadas:");
                    System.out.println("Dinheiro: " + dinheiro + "   Cartão:" + cartao + "   Outros:" + outro);
                    System.out.println("Dinheiro gerado: " + dinheiroGanho);
                }  else if (escolha == 5){
                    System.out.println("...");
                }
            }
                    System.out.println("-----------------------------------------------");
                    System.out.println(" Retornando ao menu");
                    System.out.println("-----------------------------------------------");
                    Thread.sleep(1700);
        }
    }
}