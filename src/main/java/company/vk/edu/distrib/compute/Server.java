package company.vk.edu.distrib.compute;

import java.io.IOException; // Добавлен необходимый импорт
import company.vk.edu.distrib.compute.goshanchic.KVServiceFactoryImpl;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Server {

    public static void main(String[] args) throws IOException {
        Logger log = LoggerFactory.getLogger("server");
        int port = 8080;

        KVService storage = new KVServiceFactoryImpl().create(port);

        storage.start();
        log.info("Server started on port {}", port);
        Runtime.getRuntime().addShutdownHook(new Thread(storage::stop));
    }
}
