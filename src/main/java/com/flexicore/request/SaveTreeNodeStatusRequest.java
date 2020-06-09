package com.flexicore.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class SaveTreeNodeStatusRequest {

    private Map<String, Boolean> nodeStatus=new HashMap<>();
    @JsonIgnore
    private Map<String, TreeNode> nodeIdtoTree;

    public Map<String, Boolean> getNodeStatus() {
        return nodeStatus;
    }

    public SaveTreeNodeStatusRequest setNodeStatus(Map<String, Boolean> nodeStatus) {
        this.nodeStatus = nodeStatus;
        return this;
    }

    @JsonIgnore
    public Map<String, TreeNode> getNodeIdtoTree() {
        return nodeIdtoTree;
    }

    public SaveTreeNodeStatusRequest setNodeIdtoTree(Map<String, TreeNode> nodeIdtoTree) {
        this.nodeIdtoTree = nodeIdtoTree;
        return this;
    }
}
