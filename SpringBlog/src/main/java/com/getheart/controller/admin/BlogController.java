package com.getheart.controller.admin;

import com.getheart.entity.Blog;
import com.getheart.entity.User;
import com.getheart.service.BlogService;
import com.getheart.service.TypeService;
import com.getheart.vol.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author Json
 * @date 2020-30-18:13
 */
@Controller
@RequestMapping("/admin")
public class BlogController {


    private static final String INPUT = "admin/blogs-input";
    private static final String LIST = "admin/blogs";
    private static final String REDIRECT_LIST = "redirect:../admin/blogs";

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;

    @GetMapping("/blogs")
    public String listBlog(@PageableDefault(size = 3, sort = {"updateTime"},
            direction = Sort.Direction.DESC) Pageable pageable, BlogQuery blog, Model model){

        model.addAttribute("types",typeService.listtype());
        model.addAttribute("page",blogService.listBlog(pageable,blog));
        return LIST;
    }
    @PostMapping("/blogs/serch")
    public String serch(@PageableDefault(size = 3, sort = {"updateTime"},
            direction = Sort.Direction.DESC) Pageable pageable, BlogQuery blog, Model model){

        model.addAttribute("page",blogService.listBlog(pageable,blog));

        return "admin/blogs :: blogList";
    }

    @GetMapping("/blogs/input")
    public String input(Model model){
        model.addAttribute("types",typeService.listtype());
        model.addAttribute("blog",new Blog());
        return INPUT;
    }

    @GetMapping("/blogs/{id}/input")
    public String editinput(@PathVariable Long id, Model model){

        model.addAttribute("types",typeService.listtype());
        model.addAttribute("blog", blogService.getBlogById(id));
        return INPUT;
    }

    @PostMapping("/blogs")
    public String post(Blog blog, HttpSession session, RedirectAttributes attributes){

        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getType().getId()));
        Blog saveBlog;
        if (blog.getId() == null){
             saveBlog = blogService.saveBlog(blog);
        }else {
             saveBlog = blogService.updateBlog(blog.getId(), blog);
        }

        if (saveBlog == null) {
            attributes.addFlashAttribute("message","操作失败！");
        } else {
            attributes.addFlashAttribute("message","操作成功！");
        }
        return REDIRECT_LIST;
    }

}

