package Service;

import Model.Category;

import java.util.List;

public class Service {

    /*
    isCategoryExistinList metodundan bir kategori döndüyse bu kategori daha önce eklenmiş demektir.
    bu yüzden if bloğuna girer ve bu kategorinin count'ını 1 arttırır.
    eğer boş değer yani nul döndüyse bu kategori daha önce kategori listesine eklenmemiş demektir, bunu ekler.
     */
    public void updateCount(List<Category> totalCategoryList, Category category) {
        Category categoryInList = isCategoryExistinList(totalCategoryList,category);
        if(categoryInList != null) {
            categoryInList.setCount(categoryInList.getCount()+1);
        }
        else {
            totalCategoryList.add(category);
        }
    }

    /* total kategori listesindeki tüm  kategorileri for döngüsü içinde tek tek döner.
    * eğer listedeki herhangi bir kategoriyle kullanıcıdan alınan kategorinin adı aynıysa 
    * bu kategoriyi döner. değilse null yani boş değer döner
    *  */
    private Category isCategoryExistinList(List<Category> totalCategoryList, Category category) {
        for(int i=0 ; i < totalCategoryList.size();i++) { 
            if(category.getName().toLowerCase().equalsIgnoreCase(totalCategoryList.get(i).getName().toLowerCase())) {
                return totalCategoryList.get(i);
            }
        }
        return null;
    }
}
