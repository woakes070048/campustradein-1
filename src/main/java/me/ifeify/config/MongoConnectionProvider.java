package me.ifeify.config;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ifeify
 */
public class MongoConnectionProvider implements DatabaseConnectionProvider<MongoClient> {
    @Override
    public MongoClient get() throws IOException {
        String file = System.getProperty("MONGO_CONFIG_FILE");
        if(file == null) {
            throw new IOException("MONGO_CONFIG_FILE system variable not set");
        }
        Path path = Paths.get(file);
        if(!Files.exists(path)) {
            throw new IOException("Mongo config file, " + file + ", does not exist");
        }
        // parse mongo yml config file
        Yaml yaml = new Yaml();
        Map<String, Map<String, String>> servers =
                (Map<String, Map<String, String>>)yaml.load(new FileInputStream(file));

        if(servers.size() == 0) {
            throw new IOException("No mongo clients configured in " + file);
        }

        boolean isStandAlone = servers.size() == 1 ? true : false;

        // standalone server
        if(isStandAlone) {
            Map.Entry<String, Map<String, String>> standAlone = servers.entrySet().iterator().next();
            Map<String, String> map = standAlone.getValue();

            return new MongoClient(new ServerAddress(map.get("hostname"),
                                                Integer.parseInt(map.get("port"))));
        }
        // replica sets
        List<ServerAddress> serverAddresses = new ArrayList<>();
        for(Map.Entry<String, Map<String, String>> entry : servers.entrySet()) {
            Map<String, String> map = entry.getValue();
            ServerAddress serverAddress = new ServerAddress(map.get("hostname"),
                                                        Integer.parseInt(map.get("port")));
            serverAddresses.add(serverAddress);
        }
        return new MongoClient(serverAddresses);
    }
}
