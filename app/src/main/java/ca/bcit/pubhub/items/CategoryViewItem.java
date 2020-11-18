package ca.bcit.pubhub.items;

public class CategoryViewItem {
    private String _categoryName;

    public CategoryViewItem(String _categoryName) {
        this._categoryName = _categoryName;
    }

    public String get_categoryName() {
        return _categoryName;
    }

    public void set_categoryName(String _categoryName) {
        this._categoryName = _categoryName;
    }
}
