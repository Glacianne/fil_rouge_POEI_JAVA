package Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "user_id")
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String password;


}
