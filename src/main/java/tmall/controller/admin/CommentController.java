package tmall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tmall.annotation.Auth;
import tmall.pojo.Category;
import tmall.pojo.Comment;
import tmall.pojo.Order;
import tmall.pojo.User;
import tmall.util.Pagination;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author littlestar
 */
@Controller
@RequestMapping("/admin/comment")
public class CommentController extends AdminBaseController {
    @Auth(User.Group.admin)
    @RequestMapping("list")
    public String list(Model model, Pagination pagination) throws Exception {
        List<Comment> comments = commentService.
                list("pagination", pagination, "depth", 3);
        model.addAttribute("comments", comments);
        return "admin/listComment";
    }


    @RequestMapping("delete")
    public String delete(Integer id, HttpSession session) throws Exception {
        commentService.delete(commentService.get(id));
        session.removeAttribute("cs");
        return "redirect:list";
    }
}