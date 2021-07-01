package com.neonzoff.DemoTreeThymeleaf.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Tseplyaev Dmitry
 */
@Getter
@Setter
public class Node {

    private String nodeId; // node id
    private String pId; // parent id
    private String text;
    private String type;
    private String size;

    public Node(String nodeId, String pId, String text, String type, String size) {
        this.nodeId = nodeId;
        this.pId = pId;
        this.text = text;
        this.type = type;
        this.size = size;
    }
}
