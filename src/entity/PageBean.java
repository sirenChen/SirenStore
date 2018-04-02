package entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Siren Chen.
 * pagination information
 */
public class PageBean<E> implements Serializable {
    private List<E> list = null;

    private int curPage;
    private int nextPage;
    private int prevPage;

    private int firstPage;
    private int lastPage;

    private int pageSize;     // number of records per page
    private long totalSize;   // total number of records

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getNextPage() {
        return curPage == lastPage ? curPage : curPage + 1;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPrevPage() {
        return curPage == 1 ? curPage : curPage - 1;
    }

    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }

    public int getFirstPage() {
        return 1;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = 1;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;

        this.setLastPage((int) Math.ceil(
                (double) totalSize / (double) pageSize
        ));
    }
}
