package com.flexicore.model.tree;

import com.flexicore.model.Baseclass;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Tree extends Baseclass {
    private static Tree s_Singleton=new Tree();
    public  static Tree s() {return s_Singleton;}

    public Tree() {
    }

    public Tree(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    @ManyToOne(targetEntity = TreeNode.class)
    private TreeNode root;


    @ManyToOne(targetEntity = TreeNode.class)
    public TreeNode getRoot() {
        return root;
    }

    public Tree setRoot(TreeNode root) {
        this.root = root;
        return this;
    }
}
