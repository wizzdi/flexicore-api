/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model.tree;

import com.flexicore.annotations.AnnotatedClazz;
import com.flexicore.model.Baselink;
import com.flexicore.model.User;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@SuppressWarnings("serial")
@AnnotatedClazz(Category="CategoryToBaseClass", Name="CategoryToBaseClass", Description="CategoryToBaseClass")
@Entity

public class TreeNodeToUser extends Baselink {

	@ManyToOne(targetEntity = TreeNode.class)
	private TreeNode treeNode;
	@ManyToOne(targetEntity = User.class)
	private User user;
	private boolean nodeOpen;

	public TreeNodeToUser() {
	}

	public TreeNodeToUser(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@ManyToOne(targetEntity = TreeNode.class)
	public TreeNode getTreeNode() {
		return treeNode;
	}

	public <T extends TreeNodeToUser> T setTreeNode(TreeNode treeNode) {
		this.treeNode = treeNode;
		return (T) this;
	}

	@ManyToOne(targetEntity = User.class)
	public User getUser() {
		return user;
	}

	public <T extends TreeNodeToUser> T setUser(User user) {
		this.user = user;
		return (T) this;
	}

	public boolean isNodeOpen() {
		return nodeOpen;
	}

	public <T extends TreeNodeToUser> T setNodeOpen(boolean nodeOpen) {
		this.nodeOpen = nodeOpen;
		return (T) this;
	}

	@Override
	public TreeNode getLeftside() {
		return treeNode;
	}

	@Override
	public User getRightside() {
		return user;
	}
}
