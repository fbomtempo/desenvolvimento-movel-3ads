package br.com.biblioteca.adapter.in.event;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.biblioteca.domain.cliente.app.ClienteService;
import br.com.biblioteca.domain.cliente.model.Cliente;

@Component
public class ClienteListener {

    /*private final ClienteService service;

    @Autowired
    public ClienteListener(ClienteService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queues.clientes.name}")
    public void listen(@Payload Cliente cliente) {
        System.out.println(String.format("(Queue-Listener) %s : %s", cliente.getClass().getCanonicalName(), cliente));
        this.service.cadastrar(cliente);
    }*/
}
