package com.flexicore.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.FilteringInformationHolder;
import com.flexicore.model.tree.TreeNode;


public class TreeNodeFilter extends FilteringInformationHolder {

    private String parentId;
    @JsonIgnore
    private TreeNode parent;

    public String getParentId() {
        return parentId;
    }

    public TreeNodeFilter setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    @JsonIgnore
    public TreeNode getParent() {
        return parent;
    }

    public TreeNodeFilter setParent(TreeNode parent) {
        this.parent = parent;
        return this;
    }
}
