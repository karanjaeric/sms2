/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.beans;

import com.sms.inventorymodels.Item;
import com.sms.inventorymodels.ItemCategory;
import com.sms.inventorymodels.RemainingUnits;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author ekaranja
 */
public interface InventoryBeanI {

    void save(Item t);

    EntityManager getEntityManager();

    List<Item> getAllItems();

    Item findByItemCode(String code);

    public void saveCategory(ItemCategory category);

    List<ItemCategory> getAllCategories();

    List<ItemCategory> findCategoryByCode(String code);

    public void saveRemainingUnit(RemainingUnits ru);
    void itemUpdate(Item t);
    void updateItemRemains(int units,String itemCode);

}
