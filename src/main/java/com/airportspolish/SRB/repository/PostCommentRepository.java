/*
 * Copyright (c) 2023. Adam Skaźnik for SOL PPL Chopin Airport
 * All rights reserved.
 */

package com.airportspolish.SRB.repository;

import com.airportspolish.SRB.model.PostComment;

import java.util.List;

public interface PostCommentRepository {
    void saveComment(PostComment comment);
    List<PostComment> getAllCommentsWithUserIdByPostId(Long postId);
    void deletePostById(Long postId);
}
