package com.lrm.service;

import com.lrm.blog.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Administrator on 2021/10/12.
 */
public interface TypeService {
    //保存的是传过来的type 这样的实体对象
    //新增保存分类
    Type saveType(Type type);
    //根据id查询分类
    Type getType(Long id);

    //查询所有分类
    List<Type> getAllType();

    //根据分类名称查询分类
    Type getTypeByName(String name);

    Page<Type> listType(Pageable pageable);

    List<Type> listType();

    List<Type> listTypeTop(Integer size);
//编辑修改分类
    Type updateType(Long id,Type type);

    void deleteType(Long id);
}

