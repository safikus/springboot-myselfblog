package com.lrm.service;

import com.lrm.blog.po.Tag;
import com.lrm.blog.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

/**
 * Created by Administrator on 2021/10/13.
 */
public interface TagService {
//    Tag saveTag(Tag tag);
//    //根据id查询分类
//    Tag getTag(Long id);
//
//    //查询所有分类
//    List<Tag> getAllTag();
//
//    //根据分类名称查询分类
//    Tag getTagByName(String name);
//
//    Page<Tag> listTag(Pageable pageable);
//
//    List<Tag> listTag();
//    List<Tag> listTag(String ids);
//
//    List<Tag> listTagTop(Integer size);
////编辑修改分类
//    Tag updateTag(Long id,Tag tag);
//
//    void deleteTag(Long id);
    Tag saveTag(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    List<Tag> listTagTop(Integer size);

    List<Tag> listTag(String ids);

    Tag updateTag(Long id, Tag tag);

    void deleteTag(Long id);
}
