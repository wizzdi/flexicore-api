package com.flexicore.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.tree.TreeNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreeNodeStatusRequest {

    private Set<String> nodeIds=new HashSet<>();
    @JsonIgnore
    private List<TreeNode> treeNodes;

    public Set<String> getNodeIds() {
        return nodeIds;
    }

    public TreeNodeStatusRequest setNodeIds(Set<String> nodeIds) {
        this.nodeIds = nodeIds;
        return this;
    }

    @JsonIgnore
    public List<TreeNode> getTreeNodes() {
        return treeNodes;
    }

    public TreeNodeStatusRequest setTreeNodes(List<TreeNode> treeNodes) {
        this.treeNodes = treeNodes;
        return this;
    }
}
