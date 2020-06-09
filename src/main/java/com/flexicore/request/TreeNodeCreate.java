package com.flexicore.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.FileResource;
import com.flexicore.model.Presenter;
import com.flexicore.model.dynamic.DynamicExecution;
import com.flexicore.model.tree.TreeNode;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Describes a treenode to be created or updated")
public class TreeNodeCreate {

    private String parentId;
    @JsonIgnore
    private TreeNode parent;
    private String dynamicExecutionId;
    @JsonIgnore
    private DynamicExecution dynamicExecution;
    private String name;
    private String description;
    private Boolean eager;
    private Boolean staticChildren;
    private Boolean invisible;
    private String contextString;
    private Boolean allowFilteringEditing;
    private Boolean inMap;
    private String presenterId;
    @JsonIgnore
    private Presenter presenter;
    private String iconId;
    @JsonIgnore
    private FileResource icon;


    @Schema(description = "Parent Node Id , or null ")
    public String getParentId() {
        return parentId;
    }

    public TreeNodeCreate setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    @JsonIgnore
    public TreeNode getParent() {
        return parent;
    }

    public TreeNodeCreate setParent(TreeNode parent) {
        this.parent = parent;
        return this;
    }

    @Schema(description = "dynamic execution id to be saved on this tree node")
    public String getDynamicExecutionId() {
        return dynamicExecutionId;
    }

    public <T extends TreeNodeCreate> T setDynamicExecutionId(String dynamicExecutionId) {
        this.dynamicExecutionId = dynamicExecutionId;
        return (T) this;
    }

    @JsonIgnore
    public DynamicExecution getDynamicExecution() {
        return dynamicExecution;
    }

    public <T extends TreeNodeCreate> T setDynamicExecution(DynamicExecution dynamicExecution) {
        this.dynamicExecution = dynamicExecution;
        return (T) this;
    }

    @Schema(description = "Name of the node")
    public String getName() {
        return name;
    }

    public TreeNodeCreate setName(String name) {
        this.name = name;
        return this;
    }
    @Schema(description = "Optional description for the node")
    public String getDescription() {
        return description;
    }

    public TreeNodeCreate setDescription(String description) {
        this.description = description;
        return this;
    }
    @Schema(description = "this is for client use, if true, get all children nodes when node is displayed")
    public Boolean getEager() {
        return eager;
    }

    public TreeNodeCreate setEager(Boolean eager) {
        this.eager = eager;
        return this;
    }
    @Schema(description = "Static node, that is children are not dynamically created by a filter, children are explicitly  specified ")
    public Boolean getStaticChildren() {
        return staticChildren;
    }

    public TreeNodeCreate setStaticChildren(Boolean staticChildren) {
        this.staticChildren = staticChildren;
        return this;
    }
    @Schema(description = "This is for client use (JSON makes sense here) , use can be any, for example for setting optional filter at run time, or for specifying behavior for up stream nodes in filters")
    public String getContextString() {
        return contextString;
    }

    public <T extends TreeNodeCreate> T setContextString(String contextString) {
        this.contextString = contextString;
        return (T) this;
    }
    @Schema(description = "A node can be invisible, makes sense for root or static nodes only")
    public Boolean getInvisible() {
        return invisible;
    }

    public <T extends TreeNodeCreate> T setInvisible(Boolean invisible) {
        this.invisible = invisible;
        return (T) this;
    }
    @Schema(description = "If true, allow users , at run time, to change filters on dynamic nodes.")
    public Boolean getAllowFilteringEditing() {
        return allowFilteringEditing;
    }

    public <T extends TreeNodeCreate> T setAllowFilteringEditing(Boolean allowFilteringEditing) {
        this.allowFilteringEditing = allowFilteringEditing;
        return (T) this;
    }

    @Schema(description = "If true, retrieved leaves  are displayed on the map, for this, the type of nodes must be ? extends EquipmentShort")
    public Boolean getInMap() {
        return inMap;
    }

    public <T extends TreeNodeCreate> T setInMap(Boolean inMap) {
        this.inMap = inMap;
        return (T) this;
    }

    @Schema(description = "Presenter id")
    public String getPresenterId() {
        return presenterId;
    }

    public <T extends TreeNodeCreate> T setPresenterId(String presenterId) {
        this.presenterId = presenterId;
        return (T) this;
    }

    @JsonIgnore
    public Presenter getPresenter() {
        return presenter;
    }

    public <T extends TreeNodeCreate> T setPresenter(Presenter presenter) {
        this.presenter = presenter;
        return (T) this;
    }
    @Schema(description = "tree nodes icon - this is a fileResource id")
    public String getIconId() {
        return iconId;
    }

    public <T extends TreeNodeCreate> T setIconId(String iconId) {
        this.iconId = iconId;
        return (T) this;
    }

    @JsonIgnore
    public FileResource getIcon() {
        return icon;
    }

    public <T extends TreeNodeCreate> T setIcon(FileResource icon) {
        this.icon = icon;
        return (T) this;
    }
}
