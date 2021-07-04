package com.neonzoff.demotreethymeleaf.controller;

import com.neonzoff.demotreethymeleaf.model.Node;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tseplyaev Dmitry
 */
@RestController
@RequestMapping("nodes")
public class NodesController {

    //change path here
    @Value("C:\\Program Files\\Java")
    private String PATH;

    private List<Node> nodes;


    @GetMapping
    public List<Node> nodes() {
        return getSampleNodeList();
    }


    private List<Node> getSampleNodeList() {
        nodes = new ArrayList<>();

        File file = new File(PATH);
        nodes.add(new Node(PATH, "0", file.getName(), "Каталог", ""));
        fillNodes(file);

        return nodes;
    }

    private void fillNodes(File file) {
        File[] files = file.listFiles();
        for (File tempFile : files) {
            if (tempFile.isFile()) {
//                System.out.println("[Файл] " + tempFile.getAbsoluteFile());
//                System.out.print("Файл: Путь=" + tempFile.getPath() + " Путь_родителя=" + tempFile.getParentFile().getPath() + " имя_файла=" + tempFile.getAbsoluteFile() + "\n");
                nodes.add(new Node(tempFile.getPath(), tempFile.getParentFile().getPath(), tempFile.getName(), "Файл", (tempFile.length() + " байт")));
            } else if (tempFile.isDirectory()) {
//                System.out.println("[Каталог] " + tempFile.getPath());
                nodes.add(new Node(tempFile.getPath(), tempFile.getParentFile().getPath(), tempFile.getName(), "Каталог", ""));
//                System.out.print("Директория: Путь=" + tempFile.getPath() + " Путь_родителя=" + tempFile.getParentFile().getPath() + " имя_директории=" + tempFile.getName() + "\n");
                fillNodes(tempFile);
            }
        }

    }
}
