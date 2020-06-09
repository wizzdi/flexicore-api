package com.flexicore.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.tree.TreeNode;

public class TreeNodeUpdateContainer extends TreeNodeCreate {

    private String nodeId;
    @JsonIgnore
    private TreeNode treeNode;

    public String getNodeId() {
        return nodeId;
    }

    public <T extends TreeNodeUpdateContainer> T setNodeId(String nodeId) {
        this.nodeId = nodeId;
        return (T) this;
    }

    @JsonIgnore
    public TreeNode getTreeNode() {
        return treeNode;
    }

    public <T extends TreeNodeUpdateContainer> T setTreeNode(TreeNode treeNode) {
        this.treeNode = treeNode;
        return (T) this;
    }
}
