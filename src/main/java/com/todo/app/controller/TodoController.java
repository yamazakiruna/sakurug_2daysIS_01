package com.todo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo.app.entity.Todo;
import com.todo.app.mapper.TodoMapper;

@RequestMapping("")
@Controller
public class TodoController {

    @Autowired
    TodoMapper todoMapper;
    
    /**
     * 課題一覧
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
    	// 全件表示
//       List<Todo> list = todoMapper.selectAll();
    	// 未完了のみ表示
    	List<Todo> list = todoMapper.selectIncomplete();
    	// 完了のみ表示
    	List<Todo> doneList = todoMapper.selectComplete();
        model.addAttribute("todos",list);
        model.addAttribute("doneTodos", doneList);
        return "index";
    }
    
    /**
     * 課題追加
     * @param todo
     * @return
     */
    @RequestMapping("/add")
    public String add(Todo todo) {
    	todoMapper.add(todo);
    	return "redirect:/";
    }
    
    /**
     * 課題更新
     * @param todo
     * @return
     */
    @RequestMapping("/update")
    public String update(Todo todo) {
    	todoMapper.update(todo);
    	return "redirect:/";
    }
    
    /**
     * 課題削除（一括）
     * @return なし
     */
    @RequestMapping("/delete")
    public String delete() {
    	todoMapper.delete();
    	return "redirect:/";
    }
}
