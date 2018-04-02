package service.impl;

import dao.CategoryDao;
import entity.Category;
import service.CategoryService;
import core.MyBeanFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Siren Chen.
 */
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = (CategoryDao) MyBeanFactory.getImplClass("CategoryDao");

    @Override
    public List<Category> showAllCategory() throws SQLException {

        return categoryDao.queryAll();
    }

    @Override
    public Category findCategoryById(String cid) throws SQLException {

        return categoryDao.findCategoryById(Integer.parseInt(cid));
    }
}
