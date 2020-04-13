package com.getheart.controller.admin;

import com.getheart.entity.Type;
import com.getheart.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @author Json
 * @date 2020-31-20:53
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typebiz;

    @GetMapping("/types")
    public String list(@PageableDefault(size = 3, sort = {"id"},
            direction = Sort.Direction.DESC) Pageable pageable,
                       Model model) {

        Page<Type> listType = typebiz.listType(pageable);
        model.addAttribute("page", listType);
        return "admin/types";
    }

    @GetMapping("types/input")
    public String input(Model model) {
        model.addAttribute("type",new Type());
        return "admin/type-input";
    }

    /**
     * 添加博客类型
     * @param type
     * @param attributes
     * @return
     */
    @PostMapping("/inserttypes")
    public String addtype(@Valid Type type, BindingResult result, RedirectAttributes attributes) {


        if (result.hasErrors()){
            return "admin/type-input";
        }
        Type saveType = typebiz.saveType(type);
        if (saveType == null) {
            attributes.addFlashAttribute("message","操作失败！");
        } else {
            attributes.addFlashAttribute("message","操作成功！");
        }

        return "redirect:/admin/types";
    }

    /**
     * 更新前，根据id查询分类信息
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/types/{id}/beforeupdate")
    public String beforeupdatetype(@PathVariable Long id,Model model){

        model.addAttribute("type",typebiz.getType(id));
        return "admin/type-input";
    }

    /**
     *
     * 调用updateType方法进行更新
     * @param type
     * @param id
     * @param attributes
     * @return
     */
    @PostMapping("/update/{id}")
    public String update(Type type,
                         @PathVariable Long id,
                         RedirectAttributes attributes) {

        Type saveType = typebiz.updateType(id,type);
        if (saveType == null) {
            attributes.addFlashAttribute("message","更新失败！");
        } else {
            attributes.addFlashAttribute("message","更新成功！");
        }

        return "redirect:/admin/types";
    }
    /**
     * 根据id删除类型
     * @param id
     * @param attributes
     * @return
     */
    @GetMapping("types/{id}/delete")
    public String deletetype(@PathVariable Long id,RedirectAttributes attributes){

        typebiz.deleteType(id);
        attributes.addFlashAttribute("message","删除成功！");
        return "redirect:/admin/types";

    }
}



