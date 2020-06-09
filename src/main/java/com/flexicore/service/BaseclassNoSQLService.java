package com.flexicore.service;

import com.flexicore.interfaces.FlexiCoreService;
import com.flexicore.model.nosql.BaseclassNoSQL;
import com.flexicore.request.BaseclassNoSQLCreate;
import com.flexicore.request.BaseclassNoSQLUpdate;

import java.util.List;
import java.util.Set;

public interface BaseclassNoSQLService extends FlexiCoreService {
    <T extends BaseclassNoSQL> T getByIdOrNull(Class<T> c, String id);

    <T extends BaseclassNoSQL> List<T> listByIds(Class<T> c, Set<String> ids);

    /**
     * creates a baseclassNoSQL
     * @param baseclassNoSQLCreate object used to create the baseclassNoSQL
     * @return created baseclassNoSQL
     */
    BaseclassNoSQL createBaseclassNoSQL(BaseclassNoSQLCreate baseclassNoSQLCreate);

    /**
     * creates a baseclassNoSQL
     * @param baseclassNoSQLCreate object used to create the baseclassNoSQL
     * @return created baseclassNoSQL
     */
    BaseclassNoSQL createBaseclassNoSQLNoMerge(BaseclassNoSQLCreate baseclassNoSQLCreate);

    /**
     * updtes a baseclassNoSQL
     * @param baseclassNoSQLUpdate object used to update the baseclassNoSQL
     * @return updated baseclassNoSQL
     */
    BaseclassNoSQL updateBaseclassNoSQL(BaseclassNoSQLUpdate baseclassNoSQLUpdate);

    void mergeBaseclassNoSQL(BaseclassNoSQL o);

    void massMergeBaseclassNoSQL(List<? extends BaseclassNoSQL> o);
}
