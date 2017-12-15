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

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ekaranja
 */
@Stateless
@Local
public class InventoryBean implements InventoryBeanI {

    @PersistenceContext(unitName = "SMSPU")
    private EntityManager em;

    @Override
    public void save(Item t) {

        try {

            em.persist(t);

        } catch (Exception e) {
        }

    }

    @Override
    public EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Item> getAllItems() {
        return em.createQuery("select I from Item i").getResultList();
    }

    @Override
    public Item findByItemCode(String code) {
        return (Item)em.createQuery("select I from Item i where i.itemCode= :code").setParameter("code", code).getResultList().get(0);
    }

    @Override
    public void saveCategory(ItemCategory category) {
        em.persist(category);
    }

    @Override
    public List<ItemCategory> getAllCategories() {
        return em.createQuery("SELECT C from ItemCategory C").getResultList();
    }

    @Override
    public List<ItemCategory> findCategoryByCode(String code) {
        return em.createQuery("SELECT C from ItemCategory C where C.categoryCode= :code").setParameter("code", code).getResultList();

    }

    @Override
    public void saveRemainingUnit(RemainingUnits ru) {
         em.persist(ru);
    }

    @Override
    public void itemUpdate(Item t) {
        em.merge(t);
    }

    @Override
    public void updateItemRemains(int units, String itemCode) {
        em.createQuery("UPDATE Item I set I.remaining= "+units+" WHERE I.itemCode= :code").setParameter("code", itemCode).executeUpdate();
    }

}
