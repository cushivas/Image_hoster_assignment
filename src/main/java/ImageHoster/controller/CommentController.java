package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageController imageController;

    // When user adds a new comment, this end point is invoked
    // It takes image id, title and comment object in path params or request body
    @RequestMapping("/image/{id}/{title}/comments")
    public String addComment(@PathVariable("id") Integer id, @PathVariable("title") String title, Comment comment, Model model, HttpSession session) {
        comment.setId(null);
        comment.setCreateDate(new Date());
        comment.setImage(imageService.getImage(id));
        User user = (User)session.getAttribute("loggeduser");
        comment.setUser(user);
        this.commentService.addComment(comment);
        return imageController.showImage(id, title, model);
    }
}
