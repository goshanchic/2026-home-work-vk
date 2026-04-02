package company.vk.edu.distrib.compute;

import java.io.IOException; // Добавлен необходимый импорт
import company.vk.edu.distrib.compute.goshanchic.KVServiceFactoryImpl;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Server {

    public static void main(String[] args) throws IOException { // Стандартное объявление main
        Logger log = LoggerFactory.getLogger("server");
        int port = 8080;

        // Исправлено имя класса при создании объекта (убрана приставка 'goshanchic')
        KVService storage = new KVServiceFactoryImpl().create(port);

        storage.start();
        log.info("Server started on port {}", port);

        // Корректное завершение работы сервера при выключении приложения
        Runtime.getRuntime().addShutdownHook(new Thread(storage::stop));
    }
}
