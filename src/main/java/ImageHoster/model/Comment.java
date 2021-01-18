package ImageHoster.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
// Entity class for adding comment
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "createDate")
    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Column(name="text", columnDefinition = "TEXT")
    private String text;
    // One Image can have n number of comments but
    // One comment belongs to one image only so 1-many mapping
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image image;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // One Image can belong to only one user
    // But a user can have many images..
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
