package com.neonzoff.demotreethymeleaf.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Tseplyaev Dmitry
 */
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

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
