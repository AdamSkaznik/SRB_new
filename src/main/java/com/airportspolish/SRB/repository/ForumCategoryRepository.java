/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.repository;

import com.airportspolish.SRB.model.ForumCategory;

import java.util.List;

public interface ForumCategoryRepository {
    void saveForumCategory(ForumCategory forumCategory);
    List<ForumCategory> findAllCategories();
    ForumCategory findCategoryByTitle(String title);
    boolean checkIfCategoryExistsByTitle(String title);
    boolean checkIfCategoryExistsById(Long title);
    String findCategoryTitleById(Long id);
}
