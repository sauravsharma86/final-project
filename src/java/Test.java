
import db.ContentDAO;
import java.util.List;
import pojo.Content;

public class Test {

    public static void main(String argc[]) {
        List<Content> l = ContentDAO.getUploadContent(1);
    }
}
