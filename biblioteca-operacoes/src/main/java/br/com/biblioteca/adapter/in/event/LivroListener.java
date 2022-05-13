package br.com.biblioteca.adapter.in.event;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.biblioteca.domain.livro.app.LivroService;
import br.com.biblioteca.domain.livro.model.Livro;

@Component
public class LivroListener {
    
	/*private final LivroService service;
	
    @Autowired
    public LivroListener(LivroService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queues.livros.name}")
    public void listen(@Payload Livro livro) {
        System.out.println(String.format("(Queue-Listener) %s : %s", livro.getClass().getCanonicalName(), livro));
        this.service.cadastrar(livro);
    }*/
}
