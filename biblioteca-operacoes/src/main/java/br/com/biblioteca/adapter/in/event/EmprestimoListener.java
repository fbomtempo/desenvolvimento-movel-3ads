package br.com.biblioteca.adapter.in.event;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.biblioteca.domain.emprestimo.app.EmprestimoService;
import br.com.biblioteca.domain.emprestimo.model.Emprestimo;

@Component
public class EmprestimoListener {
    
	/*private final EmprestimoService service;
	
    @Autowired
    public EmprestimoListener(EmprestimoService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queues.emprestimos.name}")
    public void listen(@Payload Emprestimo emprestimo) {
        System.out.println(String.format("(Queue-Listener) %s : %s", emprestimo.getClass().getCanonicalName(), emprestimo));
        this.service.cadastrar(emprestimo);
    }*/
}
