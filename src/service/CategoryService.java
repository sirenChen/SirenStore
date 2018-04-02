package service;

import entity.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Siren Chen.
 */
public interface CategoryService {

    /**
     * show all category
     * @return
     * @throws SQLException
     */
    public List<Category> showAllCategory() throws SQLException;

    /**
     * find category by id
     * @param cid
     * @return
     * @throws SQLException
     */
    public Category findCategoryById(String cid) throws SQLException;

}
