package com.neonzoff.DemoTreeThymeleaf.controller;

import com.neonzoff.DemoTreeThymeleaf.dao.NodeRepository;
import com.neonzoff.DemoTreeThymeleaf.model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Tseplyaev Dmitry
 */
@RestController
@RequestMapping("nodes")
public class NodesController {

    //change path here
    @Value(value = "D:\\test")
    private String PATH;

    private List<Node> nodes;

    @Autowired
    private NodeRepository repository;


    @GetMapping
    public List<Node> nodes() {
        if (nodes == null) {
            return getSampleNodeList();
        } else {
            return nodes;
        }
    }


    private List<Node> getSampleNodeList() {
        nodes = new ArrayList<>();

        File file = new File(PATH);
//        nodes.add(new Node(PATH, "0", file.getName(), "Каталог", ""));
        repository.save(new Node(PATH, "0", file.getName(), UUID.randomUUID().toString().replace("-", ""), ""));
        getDirectory(file);

        for (Node node : repository.findAll()) {
            nodes.add(node);
        }
        return nodes;
    }

    private void getDirectory(File file) {
        File[] files = file.listFiles();
        for (File tempFile : files) {
            if (tempFile.isFile()) {
//                System.out.println("[Файл] " + tempFile.getAbsoluteFile());
//                System.out.print("Файл: Путь=" + tempFile.getPath() + " Путь_родителя=" + tempFile.getParentFile().getPath() + " имя_файла=" + tempFile.getAbsoluteFile() + "\n");
//                nodes.add(new Node(tempFile.getPath(), tempFile.getParentFile().getPath(), tempFile.getName(), "Файл", (tempFile.length() + " байт")));
                repository.save(new Node(tempFile.getPath(), tempFile.getParentFile().getPath(), tempFile.getName(), UUID.randomUUID().toString().replace("-", ""), (tempFile.length() + " байт")));
            } else if (tempFile.isDirectory()) {
//                System.out.println("[Каталог] " + tempFile.getPath());
//                nodes.add(new Node(tempFile.getPath(), tempFile.getParentFile().getPath(), tempFile.getName(), "Каталог", ""));
                repository.save(new Node(tempFile.getPath(), tempFile.getParentFile().getPath(), tempFile.getName(), UUID.randomUUID().toString().replace("-", ""), ""));
//                System.out.print("Директория: Путь=" + tempFile.getPath() + " Путь_родителя=" + tempFile.getParentFile().getPath() + " имя_директории=" + tempFile.getName() + "\n");
                getDirectory(tempFile);
            }
        }

    }
}
