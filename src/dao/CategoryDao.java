package dao;

import entity.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Siren Chen.
 *
 * Category Dao interface
 */
public interface CategoryDao {
    /**
     * find all the category
     * @return the list of category entity
     * @throws SQLException
     */
    public List<Category> queryAll() throws SQLException;


    /**
     * find a category by id
     * @param cid category id
     * @return category
     * @throws SQLException
     */
    public Category findCategoryById(int cid) throws SQLException;
}
