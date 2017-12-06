
package entites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Specification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commentSpec;

    public Specification() {
    }

    public Specification(String commentSpec) {
        this.commentSpec = commentSpec;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentSpec() {
        return commentSpec;
    }

    public void setCommentSpec(String commentSpec) {
        this.commentSpec = commentSpec;
    }

 

    @Override
    public String toString() {
        return "specifiaction : " + commentSpec ;
    }

}
