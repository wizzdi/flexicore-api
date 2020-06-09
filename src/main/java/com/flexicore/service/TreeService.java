package com.flexicore.service;

import com.flexicore.data.jsoncontainers.PaginationResponse;
import com.flexicore.data.jsoncontainers.TreeCreationContainer;
import com.flexicore.model.Baseclass;
import com.flexicore.model.tree.Tree;
import com.flexicore.model.tree.TreeNode;
import com.flexicore.request.*;
import com.flexicore.response.SaveTreeNodeStatusResponse;
import com.flexicore.response.TreeNodeStatusResponse;
import com.flexicore.security.SecurityContext;

import java.util.List;
import java.util.Set;

/**
 * service for CRUD #Tree and #TreeNode
 */
public interface TreeService {
    /**
     * creates a #TreeNode
     * @param treeNodeCreationContainer
     * @param securityContext
     * @return
     */
    TreeNode createTreeNode(TreeNodeCreate treeNodeCreationContainer, SecurityContext securityContext);

    /**
     * generic method for receiving entity by id
     * @param id id of the entity
     * @param c type of the entity
     * @param batchString (optional) - used to batch fetch the entity with nested entities
     * @param securityContext security context of the user executing the action
     * @param <T> matches c
     * @return
     */
    <T extends Baseclass> T getByIdOrNull(String id, Class<T> c, List<String> batchString, SecurityContext securityContext);

    /**
     * generic method for receving a list of entities by ids
     * @param c type of the entities
     * @param ids ids of the entities
     * @param securityContext security context of the user executing the action
     * @param <T> matches c
     * @return a list of entities
     */
    <T extends Baseclass> List<T> listByIds(Class<T> c, Set<String> ids, SecurityContext securityContext);

    /**
     * creates a tree
     * @param treeCreationContainer
     * @param securityContext
     * @return
     */
    Tree createTree(TreeCreationContainer treeCreationContainer, SecurityContext securityContext);

    PaginationResponse<Tree> getAllTrees(TreeFilter treeFilter, SecurityContext securityContext);

    PaginationResponse<TreeNode> getAllTreeNodes(TreeNodeFilter treeFilter, SecurityContext securityContext);

    /**
     * updates the tree node status (expended of folded)
     * @param saveTreeNodeStatusRequest
     * @param securityContext
     * @return
     */
    SaveTreeNodeStatusResponse saveTreeNodeStatus(SaveTreeNodeStatusRequest saveTreeNodeStatusRequest, SecurityContext securityContext);

    /**
     * returns the current status of the treeNodes (expanded or folded)
     * @param treeNodeStatusRequest
     * @param securityContext
     * @return
     */
    TreeNodeStatusResponse getTreeNodeStatus(TreeNodeStatusRequest treeNodeStatusRequest, SecurityContext securityContext);

    /**
     * updates a tree node
     * @param treeNodeCreationContainer
     * @param securityContext
     * @return
     */
    TreeNode updateTreeNode(TreeNodeUpdateContainer treeNodeCreationContainer, SecurityContext securityContext);

    /**
     * updates a tree
     * @param updateTree
     * @param securityContext
     * @return
     */
    Tree updateTree(TreeUpdateContainer updateTree, SecurityContext securityContext);
}
