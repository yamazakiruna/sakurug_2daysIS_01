package com.todo.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.todo.app.entity.Todo;

@Mapper
public interface TodoMapper {

	// 全て表示
    public List<Todo> selectAll();
    // 未完了のみ表示
    public List<Todo> selectIncomplete();
    // 完了を表示
    public List<Todo> selectComplete();
    // 課題を追加
    public void add(Todo todo);
    // 課題を更新
    public void update(Todo todo);
    // 課題削除
    public void delete();
    
}