import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Atendimento extends Agent {
    protected void setup() {
        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    System.out.println("Agente de Atendimento: " + msg.getContent());
                    String reply = gerarResposta(msg.getContent());
                    ACLMessage replyMsg = msg.createReply();
                    replyMsg.setContent(reply);
                    send(replyMsg);
                } else {
                    block();
                }
            }
        });
    }

    private String gerarResposta(String pergunta) {
        // Lógica para gerar a resposta com base na pergunta
        if (pergunta.contains("Olá")) {
            return "Olá! Eu sou Ana, seu agente de atendimento da Universidade Central. Em que posso te ajudar?";
        } else if (pergunta.contains("inscrição") || pergunta.contains("matrícula")) {
            return "Claro! Estou aqui para ajudar. Qual é a sua dúvida específica sobre a inscrição?";
        } else if (pergunta.contains("processo de matrícula online")) {
            return "Você já acessou o portal do aluno para iniciar o processo de matrícula?";
        } else if (pergunta.contains("login")) {
            return "Ótimo! Após fazer login, você encontrará a opção de 'Matrícula' ou 'Inscrição' no menu principal.";
        } else if (pergunta.contains("lista de disciplinas")) {
            return "Agora você verá uma lista de disciplinas disponíveis para o próximo semestre.";
        } else if (pergunta.contains("selecionar as disciplinas")) {
            return "Selecione as disciplinas que deseja cursar e clique em 'Confirmar Matrícula' ou no botão equivalente.";
        } else if (pergunta.contains("obrigado")) {
            return "Não há de quê! Estou aqui para ajudar. Se surgir qualquer outra dúvida, não hesite em me contatar.";
        } else if (pergunta.contains("bom dia")) {
            return "Igualmente!";
        } else {
            return "Desculpe, não entendi. Pode repetir?";
        }
    }
}
