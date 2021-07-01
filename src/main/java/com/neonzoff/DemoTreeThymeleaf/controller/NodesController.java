package com.neonzoff.DemoTreeThymeleaf.controller;

import com.neonzoff.DemoTreeThymeleaf.model.Node;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tseplyaev Dmitry
 */
@RestController
@RequestMapping("nodes")
public class NodesController {

    //change path here
    private final String PATH = "C:\\Program Files\\Java";

    private List<Node> nodes;


    @GetMapping
    public List<Node> nodes() throws IOException {
        return getSampleNodeList();
    }


    private List<Node> getSampleNodeList() throws IOException {
        nodes = new ArrayList<>();

        File file = new File(PATH);
        nodes.add(new Node(PATH, "0", file.getName(), "Каталог", ""));
        getDirectory(file);

        return nodes;
    }

    private void getDirectory(File file) {
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
                getDirectory(tempFile);
            }
        }

    }
}
