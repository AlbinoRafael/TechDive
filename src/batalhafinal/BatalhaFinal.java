package batalhafinal;

import classesdecombate.Arqueiro;
import classesdecombate.Guerreiro;
import classesdecombate.Mago;
import classesdecombate.Paladino;
import classesinimigas.Alquimista;
import classesinimigas.Armeiro;
import classesinimigas.Lider;
import entidades.*;

import java.util.Scanner;

public class BatalhaFinal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nSeja bem vindo(a) à BATALHA FINAL!\n");

        // TODO: solicitar ao jogador um nome para o personagem.
        System.out.print("Digite um nome para o personagem: ");
        String nome = sc.nextLine();
        // TODO: solicitar ao jogador um sexo para o personagem.
        //       M ou F.
        System.out.print("Digite o sexo para o personagem (M ou F): ");
        String sexo = sc.nextLine();

        // TODO: solicitar ao jogador qual a classe do personagem.
        //       Guerreiro, Paladino, Arqueiro, Mago.
        // TODO: solicitar ao jogador qual arma o personagem vai usar,
        //       dentre as opções disponíveis para a classe selecionada.
        // TODO: instanciar um novo objeto da classe selecionada pelo jogador,
        //       passando como argumentos os valores coletados.
        System.out.println("Selecione a Classe do Jogador: \n 1 - Guerreiro \n 2 - Paladino \n 3 - Arqueiro \n 4 - Mago \n");
        System.out.print("Selecione a opção desejada: ");
        int opcaoClasse = sc.nextInt();
        Jogador jogador = null;
        int opcaoArma = -1;
        switch (opcaoClasse) {
            case 1:
                System.out.println("\nSelecione a arma: \n 1 - Espada \n 2 - Machado \n");
                System.out.print("digite a opção desejada: ");
                opcaoArma = sc.nextInt();
                if (opcaoArma == 1) {
                    jogador = new Guerreiro(nome, sexo, EnumArma.ESPADA);
                } else if (opcaoArma == 2) {
                    jogador = new Guerreiro(nome, sexo, EnumArma.MACHADO);
                } else {
                    System.out.println("Opção inválida!");
                }
                break;
            case 2:
                System.out.println("\nSelecione a arma: \n 1 - Martelo \n 2 - Clava \n");
                System.out.print("digite a opção desejada: ");
                opcaoArma = sc.nextInt();
                if (opcaoArma == 1) {
                    jogador = new Paladino(nome, sexo, EnumArma.MARTELO);
                } else if (opcaoArma == 2) {
                    jogador = new Paladino(nome, sexo, EnumArma.CLAVA);
                } else {
                    System.out.println("Opção inválida!");
                }
                break;
            case 3:
                System.out.println("\nSelecione a arma: \n 1 - Arco \n 2 - Besta \n");
                System.out.print("digite a opção desejada: ");
                opcaoArma = sc.nextInt();
                if (opcaoArma == 1) {
                    jogador = new Arqueiro(nome, sexo, EnumArma.ARCO);
                } else if (opcaoArma == 2) {
                    jogador = new Arqueiro(nome, sexo, EnumArma.BESTA);
                } else {
                    System.out.println("Opção inválida!");
                }
                break;
            case 4:
                System.out.println("\nSelecione a arma: \n 1 - Cajado \n 2 - Livro de Magias \n");
                System.out.print("digite a opção desejada: ");
                opcaoArma = sc.nextInt();
                if (opcaoArma == 1) {
                    jogador = new Mago(nome, sexo, EnumArma.CAJADO);
                } else if (opcaoArma == 2) {
                    jogador = new Mago(nome, sexo, EnumArma.LIVRO_MAGIAS);
                } else {
                    System.out.println("Opção inválida!");
                }
                break;
        }

        System.out.println("\nA noite se aproxima, a lua já surge no céu, estrelas vão se acendendo,\n"
                + "e sob a luz do crepúsculo você está prestes a entrar na fase final da sua missão.\n"
                + "Você olha para o portal à sua frente, e sabe que a partir desse ponto, sua vida mudará para sempre.");

        System.out.println("Memórias do caminho percorrido para chegar até aqui invadem sua mente.\n"
                + "Você se lembra de todos os inimigos já derrotados para alcançar o covil do líder maligno.\n"
                + "Olha para seu equipamento de combate, já danificado e desgastado depois de tantas lutas.\n"
                + "Você está a um passo de encerrar para sempre esse mal.");

        System.out.println("Buscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.");

        // TODO: pedir ao jogador para escolher a motivação do seu personagem.
        //       por que o personagem está nessa missão de destruir os inimigos?
        //       Vingança ou Glória?

        System.out.println("\nEscolha sua motivação: \n1 - Vingança \n2 - Glória \n");
        System.out.print("Selecione a opção desejada: ");
        int opcaoMotivacao = sc.nextInt();
        if (opcaoMotivacao == 1) {
            jogador.setMotivacao(EnumMotivacao.VINGANCA);
        } else if (opcaoMotivacao == 2) {
            jogador.setMotivacao(EnumMotivacao.GLORIA);
        } else {
            System.out.println("Opção inválida!");
        }
        // TODO: if (motivação do jogador == VINGANÇA)
        if (jogador.getMotivacao() == EnumMotivacao.VINGANCA) {
            System.out.println("\nImagens daquela noite trágica invadem sua mente.\n"
                    + "Você nem precisa se esforçar para lembrar, pois essas memórias estão sempre presentes,\n"
                    + "mesmo que de pano de fundo, quando você tem outros pensamentos em foco, elas nunca o deixaram.\n"
                    + "Elas são o combustível que te fizeram chegar até aqui.\n"
                    + "E você sabe que não irá desistir até ter vingado a morte\n"
                    + "daqueles que foram - e pra sempre serão - sua fonte de amor e desejo de continuar vivo.\n"
                    + "O maldito líder finalmente pagará por tanto mal causado na vida de tantos\n"
                    + "(e principalmente na sua).\n");
        }
        // TODO else
        else {
            System.out.println("\nVocê já consegue visualizar na sua mente o povo da cidade te recebendo de braços abertos,\n"
                    + "bardos criando canções sobre seus feitos heróicos, nobres te presenteando com jóias e diversas riquezas,\n"
                    + "taberneiros se recusando a cobrar por suas bebedeiras e comilanças.\n"
                    + "Desde já, você sente o amor do público, te louvando a cada passo que dá pelas ruas,\n"
                    + "depois de destruir o vilão que tanto assombrou a paz de todos.\n"
                    + "Porém, você sabe que ainda falta o último ato dessa história.\n"
                    + "Você se concentra na missão.\n"
                    + "A glória o aguarda, mas não antes da última batalha.\n");

            System.out.println("Inspirado pelo motivo que te trouxe até aqui, você sente seu coração ardendo em chamas,\n"
                    + "suas mãos formigarem em volta da sua arma. Você a segura com firmeza. Seu foco está renovado.\n"
                    + "Você avança pelo portal.\n");

            System.out.println("A escuridão te envolve. Uma iluminação muito fraca entra pelo portal às suas costas.\n"
                    + "À sua frente, só é possível perceber que você se encontra em um corredor extenso.\n"
                    + "Você só pode ir à frente, ou desistir.\n");
        }
        // TODO: perguntar ao jogador se o personagem segue em frente ou desiste
        // TODO: if (desiste)
        boolean desiste = false;
        System.out.println("Você deseja seguir em frente ou desistir?");
        System.out.println(" 1 - Seguir em Frente\n 2 - Desistir\n");
        System.out.print("digite a opção desejada: ");
        int opcaoDesistir = sc.nextInt();
        if (opcaoDesistir == 1) {
            desiste = false;
        } else if (opcaoDesistir == 2) {
            desiste = true;
        } else {
            System.out.println("Opção inválida!");
        }
        if (desiste) {
            System.out.println("\nO medo invade o seu coração e você sente que ainda não está à altura do desafio.\n"
                    + "Você se volta para a noite lá fora, e corre em direção à segurança.");
            // TODO: encerrar a execução do programa: System.exit(0);
            System.exit(0);
        } else {
            System.out.println("\nVocê caminha, atento a todos os seus sentidos, por vários metros,\n"
                    + "até visualizar a frente uma fonte de luz, que você imagina ser a chama de uma tocha,\n"
                    + "vindo de dentro de uma porta aberta.\n");

            System.out.println("Você se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha,\n"
                    + "e pondera sobre como passar pela porta.\n");

            // TODO: perguntar ao jogador se deseja passar pela porta ANDANDO CUIDADOSAMENTE, CORRENDO ou SALTANDO.
            System.out.println("Você deseja passar pela porta: \n 1 - Saltando\n 2 - Correndo\n 3- Andando cuidadosamente\n");
            System.out.print("Selecione a opção desejada: ");
            int opcaoPassarPorta = sc.nextInt();
            // TODO: if SALTANDO
            if (opcaoPassarPorta == 1) {
                System.out.println("\nVocê se concentra e pula em direção à luz, saltando de antes da porta até o interior da sala.\n");
            }
            // TODO: else if CORRENDO

            else if (opcaoPassarPorta == 2) {
                System.out.println("\nVocê respira fundo e desata a correr em direção à sala.\n"
                        + "Quando passa pela porta, sente que pisou em uma pedra solta,\n"
                        + "mas não dá muita importância e segue para dentro da sala, olhando ao redor à procura de inimigos.\n"
                        + "Não tem ninguém, mas você ouve sons de flechas batendo na pedra atrás de você,\n"
                        + "e quando se vira, vê várias flechas no chão.\n"
                        + "Espiando pela porta, você entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto,\n"
                        + "mas por sorte você entrou correndo e conseguiu escapar desse ataque surpresa.\n");
            }
            // TODO: else
            else if (opcaoPassarPorta == 3) {
                System.out.println("\nVocê toma cuidado e vai caminhando vagarosamente em direção à luz.\n"
                        + "Quando você pisa exatamente embaixo da porta, você sente o chão ceder levemente, como se tivesse pisado em uma pedra solta.\n"
                        + "Você ouve um ruído de mecanismos se movimentando, e uma escotilha se abre no teto atrás de você, no corredor.\n"
                        + "Flechas voam da escotilha em sua direção, e você salta para dentro da sala, porém uma delas te acerta na perna.\n");
                //TODO: instanciar objeto Armadilha e invocar método de causar dano.
                new Armadilha().atacar(jogador);
            }
            System.out.println("\nVocê se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede.\n"
                    + "Uma delas foi aquela pela qual você entrou, que estava aberta, e as outras três estão fechadas.\n"
                    + "A porta à sua frente é a maior das quatro, com inscrições em seu entorno em uma língua que você não sabe ler,\n"
                    + "mas reconhece como sendo a língua antiga utilizada pelo inimigo.\n"
                    + "Você se aproxima da porta e percebe que ela está trancada por duas fechaduras douradas,\n"
                    + "e você entende que precisará primeiro derrotar o que estiver nas outras duas portas laterais,\n"
                    + "antes de conseguir enfrentar o líder.\n");

            System.out.println("Você se dirige para a porta à direita.\n");

            System.out.println("\nVocê se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada.\n"
                    + "Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra.\n"
                    + "Ao entrar, você se depara com uma sala espaçosa,\n"
                    + "com vários equipamentos de batalha pendurados nas paredes e dispostos em armários e mesas.\n"
                    + "Você imagina que este seja o arsenal do inimigo, onde estão guardados os equipamentos que seus soldados\n"
                    + "utilizam quando saem para espalhar o terror nas cidades e vilas da região.\n"
                    + "Enquanto seu olhar percorre a sala, você ouve a porta se fechando e gira rapidamente para olhar para trás.\n"
                    + "Ali, de pé entre você e a porta fechada, bloqueando o caminho do seu destino, está um dos capitães do inimigo.\n"
                    + "Um orque horrendo, de armadura, capacete e espada em punho, em posição de combate.\n"
                    + "Ele avança em sua direção.\n");
        }
        // TODO: instanciar objeto Armeiro
        Inimigo armeiro = new Armeiro();
        // TODO: iniciar loop de combate, inimigo ataca primeiro
        combate(jogador, armeiro, 1);
        System.out.println("\nApós derrotar o Armeiro, você percebe que seus equipamentos estão muito danificados.\n"
                + "Olha em volta, encarando todas aquelas peças de armaduras resistentes e em ótimo estado.\n");

        // TODO: perguntar ao jogador se ele quer ou não pegar as armaduras novas.
        System.out.println("\nO que você quer fazer com as armaduras novas?: \n1 - Pegar \n2 - Não pegar\n");
        System.out.print("Selecione a opção desejada: ");
        int opcaoArmadura = sc.nextInt();
        // TODO: Se escolher pegar
        if (opcaoArmadura == 1) {
            System.out.println("\nVocê resolve usar os equipamentos do inimigo contra ele, e trocar algumas peças suas,\n"
                    + "que estavam danificadas, pelas peças de armaduras existentes na sala.\n"
                    + "De armadura nova, você se sente mais protegido para os desafios à sua frente.\n");
            // TODO: deve ser acrescentado +5 pontos de defesa para o jogador.
            jogador.setPontosDefesa(jogador.getPontosDefesa() + 5);
        } else if (opcaoArmadura == 2) {
            // TODO: se não
            System.out.println("\nVocê decide que não precisa utilizar nada que venha das mãos do inimigo.\n");
        } else {
            System.out.println("\nOpção inválida!\n");
        }
        System.out.println("\nEm uma mesa, você encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras da porta do líder inimigo.\n"
                + "Você pega a chave e guarda numa pequena bolsa que leva presa ao cinto.\n");

        System.out.println("\nVocê retorna à sala anterior e se dirige à porta da esquerda.\n"
                + "Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada.\n"
                + "Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra.\n"
                + "Ao entrar, você se depara com uma sala parecida com a do arsenal, mas em vez de armaduras,\n"
                + "existem vários potes e garrafas de vidro com conteúdos misteriosos e de cores diversas,\n"
                + "e você entende que o capitão que vive ali, realiza experimentos com diversos ingredientes,\n"
                + "criando poções utilizadas pelos soldados para aterrorizar a região.\n");
        System.out.println("\nNo fundo da sala, olhando em sua direção, está outro dos capitães do inimigo.\n"
                + "Um orque horrendo, de armadura, cajado em punho, em posição de combate. Ele avança em sua direção.\n");
        // TODO: instanciar objeto Alquimista
        Inimigo alquimista = new Alquimista();
        // TODO: iniciar loop de combate, inimigo ataca primeiro
        combate(jogador, alquimista, 1);
        System.out.println("\nApós derrotar o Alquimista, você olha em volta, tentando reconhecer alguma poção do estoque do inimigo.\n"
                + "Em uma mesa, você reconhece uma pequena garrafa de vidro contendo um líquido levemente rosado,\n"
                + "pega a garrafa e pondera se deve beber um gole.\n");
        // TODO: perguntar ao jogador se ele quer ou não beber.
        System.out.println("O que você deseja fazer com o líquido?\n1 - Beber\n2 - Não beber\n");
        System.out.print("Selecione a opção desejada: ");
        int opcaoLiquido = sc.nextInt();
        // TODO: Se escolher beber
        if (opcaoLiquido == 1) {
            System.out.println("Você se sente revigorado para seguir adiante!\n");
            // TODO: pontos de saúde do jogador devem ser restaurados 100%
            jogador.setPontosSaude(jogador.SAUDE_MAXIMA);
        } else if (opcaoLiquido == 2) {
            // TODO: se não
            System.out.println("Você fica receoso de beber algo produzido pelo inimigo.\n");
        }
        System.out.println("Ao lado da porta, você vê uma chave dourada em cima de uma mesa,\n"
                + "e sabe que aquela chave abre a outra fechadura da porta do líder inimigo.\n"
                + "Você pega a chave e guarda na pequena bolsa que leva presa ao cinto.\n");

        System.out.println("De volta à sala das portas, você se dirige à porta final.\n"
                + "Coloca as chaves nas fechaduras, e a porta se abre.\n"
                + "Seu coração acelera, memórias de toda a sua vida passam pela sua mente,\n"
                + "e você percebe que está muito próximo do seu objetivo final.\n"
                + "Segura sua arma com mais firmeza, foca no combate que você sabe que irá se seguir, e adentra a porta.\n");

        System.out.println("Lá dentro, você vê o líder sentado em uma poltrona dourada, com duas fogueiras de cada lado, e prisioneiros acorrentados às paredes.\n");

        System.out.println("Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de lâmina dupla.\n");
        Inimigo lider = new Lider();
        // TODO: jogador deve decidir se ataca ou espera
        System.out.println("Você deseja: \n1 - Atacar\n2 - Esperar\n");
        System.out.print("Selecione a opção desejada: ");
        int opcaoDecisao = sc.nextInt();
        // TODO: iniciar loop de combate, dependendo da resposta do jogador, ele ataca primeiro
        if (opcaoDecisao == 1) {
            combate(jogador, lider, 0);
        } else if (opcaoDecisao == 2) {
            combate(jogador, lider, 1);
        }
        if (lider.getPontosSaude() <= 0) {
            System.out.println("Você conseguiu!");
            // TODO: exibir mensagem de vitória de acordo com a motivação do jogador:
            // se vingança: Você obteve sua vingança. Você se ajoelha e cai no choro, invadido por uma sensação de alívio e felicidade. Você se vingou, tudo que sempre quis, está feito. Agora você pode seguir sua vida.
            if (jogador.getMotivacao() == EnumMotivacao.VINGANCA) {
                System.out.println("Você obteve sua vingança. Você se ajoelha e cai no choro, invadido por uma sensação de alívio e felicidade. Você se vingou, tudo que sempre quis, está feito. Agora você pode seguir sua vida.\n");
            } else if (jogador.getMotivacao() == EnumMotivacao.GLORIA) {
                // se glória: O êxtase em que você se encontra não cabe dentro de si. Você se ajoelha e grita de alegria. A glória o aguarda, você a conquistou.
                System.out.println("O êxtase em que você se encontra não cabe dentro de si. Você se ajoelha e grita de alegria. A glória o aguarda, você a conquistou.\n");
            }
            System.out.println("Você se levanta, olha para os prisioneiros, vai de um em um e os liberta,\n"
                    + "e todos vocês saem em direção à noite, retornando à cidade.\n"
                    + "Seu dever está cumprido.");
        }

    }

    private static void combate(Jogador jogador, Inimigo inimigo, int turno) {
		/*
		Num combate, cada adversário possui um turno. Quem toma a iniciativa do início do combate possui a vantagem do primeiro turno. O inimigo sempre atacará, e o jogador pode escolher entre atacar e fugir (encerrando o jogo).

		Cada ataque leva em consideração os pontos de ataque do personagem + ataque da arma + “rolamento de dado” (valor entre 1-20) para definir o tanto de dano que o atacante irá desferir no defensor. Essa quantidade de dano é subtraída pelos pontos de defesa do defensor. Se o rolamento de dado do atacante for 1, ele erra, e o defensor não sofre nenhum dano. Se o rolamento de dado do atacante for 20, ele conseguirá um acerto crítico, e o seu ataque ignora a defesa do adversário (ou seja, o dano que ele desfere é 100%, sem subtrair pelos pontos de defesa do defensor).

		Quando o inimigo ataca, é realizado o cálculo do ataque e o jogo deve atualizar os pontos de vida do jogador, e exibir a mensagem: “O inimigo atacou! Você sofreu X de dano e agora possui Y pontos de vida.” substituindo X pela quantidade de dano do ataque e Y pela quantidade de pontos de vida atual do jogador. Se o inimigo errar, a mensagem exibida deve ser “O inimigo errou o ataque! Você não sofreu dano.”. Se o inimigo acertar um ataque crítico, a mensagem deve ser: "O inimigo acertou um ataque crítico! Você sofreu X de dano e agora possui Y pontos de vida.".
		Caso o ataque do inimigo te leve a 0 pontos de vida, você morre, e a mensagem exibida deve ser “Você não estava preparado para a força do inimigo. {COMPLEMENTO DE ACORDO COM A MOTIVAÇÃO}”, substituindo o conteúdo entre chaves de acordo com a motivação do personagem selecionada no início do jogo. VINGANÇA: “Não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você.” GLÓRIA: “A glória que buscavas não será sua, e a cidade aguarda por seu(sua) próximo(a) herói(na).” (o gênero deve ser alterado para refletir o sexo do personagem escolhido pelo jogador no início do jogo). O jogo encerra quando o jogador morre.

		Quando é a vez do jogador fazer uma ação, deve ser perguntado a ele se ele deseja atacar ou fugir. Se escolher fugir, o jogo deve exibir a mensagem “Você não estava preparado para a força do inimigo, e decide fugir para que possa tentar novamente em uma próxima vez.”.
		Se escolher atacar, o jogo deve realizar o cálculo do ataque e atualizar os pontos de vida do inimigo. O jogo deve exibir a mensagem “Você atacou {COMPLEMENTO DA ARMA} e causou X de dano no inimigo!”, substituindo o conteúdo entre chaves de acordo com a arma do personagem. Espada, machado, martelo ou clava: “com sua/seu {ARMA}”. Arco+flecha ou besta+virote: “com seu/sua {ARMA}, a/o {MUNIÇÃO} atingiu”. Cajado: “com seu cajado, lançando uma bola de fogo”. Livro: “absorvendo energia do livro com uma mão e liberando com a outra”.
		Se o jogador errar, a mensagem exibida deve ser “Você errou seu ataque! O inimigo não sofreu dano algum.”. Se o jogador acertar um ataque crítico, a mensagem deve ser: "Você acertou um ataque crítico! {COMPLEMENTO}” substituindo o conteúdo entre chaves pela mensagem de ataque normal.
		Caso o inimigo morra com o seu ataque, o jogo deve exibir “O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.”
		*/
        Scanner sc = new Scanner(System.in);
        int turno1 = turno;
        boolean continua = true;
        do {
            if (turno1 % 2 == 1) {
                inimigo.atacar(jogador);
                if (jogador.getPontosSaude() <= 0) {
                    if (jogador.getMotivacao() == EnumMotivacao.VINGANCA) {
                        System.out.println("Você não estava preparado para a força do inimigo. Não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você.\n");
                        System.exit(0);
                    } else if (jogador.getMotivacao() == EnumMotivacao.GLORIA) {
                        System.out.println("Você não estava preparado para a força do inimigo. A glória que buscavas não será sua, e a cidade aguarda por seu(sua) próximo(a) herói(na).\n");
                        System.exit(0);
                    }
                }
                turno1++;
            } else {
                System.out.println("\nO que você vai fazer? \n1 - Atacar!\n2 - Fugir!\n");
                System.out.print("Selecione a opção desejada: ");
                int opcaoCombate = sc.nextInt();
                if (opcaoCombate == 1) {
                    jogador.atacar(inimigo);
                    if (inimigo.getPontosSaude() <= 0) {
                        System.out.println("O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.\n");
                        continua = false;
                    }
                    turno1++;
                } else if (opcaoCombate == 2) {
                    System.out.println("Você não estava preparado para a força do inimigo, e decide fugir para que possa tentar novamente em uma próxima vez.\n");
                    System.exit(0);
                } else {
                    System.out.println("Opção inválida!\n");
                }

            }
        } while (continua);
    }
}
