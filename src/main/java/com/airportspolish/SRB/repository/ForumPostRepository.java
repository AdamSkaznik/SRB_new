/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.repository;

import com.airportspolish.SRB.model.ForumPost;

import java.util.LinkedList;

public interface ForumPostRepository {
    Long countPosts();
    LinkedList<ForumPost> findAllPostsByCategorySortByNewest(String category);
    LinkedList<ForumPost> findAllPostsById(Long id);
    ForumPost findPostById(Long id);
    void savePost(ForumPost forumPost);
}
