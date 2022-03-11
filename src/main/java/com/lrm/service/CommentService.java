package com.lrm.service;

import com.lrm.blog.po.Comment;

import java.util.List;

/**
 * Created by Administrator on 2021/10/22.
 */
public interface CommentService {

     List<Comment> listCommentByBlogId(Long blogId);

     Comment saveComment(Comment comment);
}
