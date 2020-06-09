package com.flexicore.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.data.jsoncontainers.TreeCreationContainer;
import com.flexicore.model.tree.Tree;

public class TreeUpdateContainer extends TreeCreationContainer {

    private String treeId;
    @JsonIgnore
    private Tree tree;

    public String getTreeId() {
        return treeId;
    }

    public <T extends TreeUpdateContainer> T setTreeId(String treeId) {
        this.treeId = treeId;
        return (T) this;
    }

    @JsonIgnore
    public Tree getTree() {
        return tree;
    }

    public <T extends TreeUpdateContainer> T setTree(Tree tree) {
        this.tree = tree;
        return (T) this;
    }
}
