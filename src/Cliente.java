import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.core.AID;

public class Cliente extends Agent {
    protected void setup() {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                msg.setContent("Olá, tudo bem?");
                msg.addReceiver(new AID("Atendimento", AID.ISLOCALNAME));
                send(msg);
            }
        });
    }
}
