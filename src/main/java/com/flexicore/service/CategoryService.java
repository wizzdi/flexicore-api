package com.flexicore.service;

import com.flexicore.data.jsoncontainers.PaginationResponse;
import com.flexicore.interfaces.FlexiCoreService;
import com.flexicore.model.*;
import com.flexicore.request.*;
import com.flexicore.security.SecurityContext;

import java.util.List;
import java.util.Set;

public interface CategoryService extends FlexiCoreService {

    /**
     * returns all Categories
     * @param categoryFilter object used to filter result set
     * @param securityContext security context of the user to execute the action
     * @return returns a list of categories including pagination info
     */
    PaginationResponse<Category> getAllCategories(CategoryFilter categoryFilter, SecurityContext securityContext);
    /**
     * returns all Categories
     * @param categoryFilter object used to filter result set
     * @param securityContext security context of the user to execute the action
     * @return returns a list of categories
     */
    List<Category> listAllCategories(CategoryFilter categoryFilter, SecurityContext securityContext);

    /**
     * creates a category
     * @param categoryCreate object used to create the category
     * @param securityContext security context of the user to execute the action
     * @return created category
     */
    Category createCategoryNoMerge(CategoryCreate categoryCreate, SecurityContext securityContext);

    /**
     * creates a category
     * @param categoryCreate object used to create the category
     * @param securityContext security context of the user to execute the action
     * @return created category
     */
    Category createCategory(CategoryCreate categoryCreate,SecurityContext securityContext);
    /**
     * update a category
     * @param categoryUpdate object used to update the category
     * @param securityContext security context of the user to execute the action
     * @return updated category
     */
    Category updateCategory(CategoryUpdate categoryUpdate, SecurityContext securityContext);
    /**
     * update a category
     * @param categoryCreate object used to update the category
     * @param category category to update
     * @return true if updated , false otherwise
     */
    boolean updateCategoryNoMerge(CategoryCreate categoryCreate,Category category);

    /**
     * return all category to baseclass links
     * @param categoryToBaseclassFilter object used to filter the result set
     * @param securityContext security context of the user to execute the action
     * @return list of category to baseclass links with pagination info
     */
    PaginationResponse<CategoryToBaseClass> getAllCategoryToBaseclass(CategoryToBaseclassFilter categoryToBaseclassFilter, SecurityContext securityContext);
    /**
     * return all category to baseclass links
     * @param categoryToBaseclassFilter object used to filter the result set
     * @param securityContext security context of the user to execute the action
     * @return list of category to baseclass links
     */
    List<CategoryToBaseClass> listAllCategoryToBaseclass(CategoryToBaseclassFilter categoryToBaseclassFilter, SecurityContext securityContext);

    /**
     * creates a link between baseclass and category
     * @param categoryToBaseclassCreate object used to create a category to baseclass link
     * @param securityContext security context of the user to execute the action
     * @return created category to baseclass link
     */
    CategoryToBaseClass createCategoryToBaseclassNoMerge(CategoryToBaseclassCreate categoryToBaseclassCreate, SecurityContext securityContext);
    /**
     * creates a link between baseclass and category
     * @param categoryToBaseclassCreate object used to create a category to baseclass link
     * @param securityContext security context of the user to execute the action
     * @return created category to baseclass link
     */
    CategoryToBaseClass createCategoryToBaseclass(CategoryToBaseclassCreate categoryToBaseclassCreate,SecurityContext securityContext);
    /**
     * updates a link between baseclass and category
     * @param categoryToBaseclassUpdate object used to update a category to baseclass link
     * @param securityContext security context of the user to execute the action
     * @return updated category to baseclass link
     */
    CategoryToBaseClass updateCategoryToBaseclass(CategoryToBaseclassUpdate categoryToBaseclassUpdate,SecurityContext securityContext);
    /**
     * updates a link between baseclass and categoryToBaseClass
     * @param categoryToBaseclassCreate object used to update a categoryToBaseClass to baseclass link
     * @param categoryToBaseClass categoryToBaseClass to update
     * @return true if updated false otherwise
     */
    boolean updateCategoryToBaseclassNoMerge(CategoryToBaseclassCreate categoryToBaseclassCreate,CategoryToBaseClass categoryToBaseClass);

}
