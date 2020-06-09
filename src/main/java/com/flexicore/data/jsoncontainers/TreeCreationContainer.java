package com.flexicore.data.jsoncontainers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.tree.TreeNode;

public class TreeCreationContainer {

    private String rootId;
    @JsonIgnore
    private TreeNode root;
    private String description;
    private String name;

    public String getRootId() {
        return rootId;
    }

    public TreeCreationContainer setRootId(String rootId) {
        this.rootId = rootId;
        return this;
    }

    @JsonIgnore
    public TreeNode getRoot() {
        return root;
    }

    public TreeCreationContainer setRoot(TreeNode root) {
        this.root = root;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TreeCreationContainer setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public TreeCreationContainer setName(String name) {
        this.name = name;
        return this;
    }
}
