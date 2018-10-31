package club.cheapok.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SomePost {
    int userId;
    long id;
    String title;
    String body;
}
