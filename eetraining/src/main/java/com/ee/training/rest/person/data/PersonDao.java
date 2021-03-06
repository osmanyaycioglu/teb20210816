package com.ee.training.rest.person.data;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.ee.training.rest.person.model.PersonDTO;

@LocalBean
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonDao {

    @PersistenceContext(unitName = "eetraining")
    private EntityManager em;

    //    @PersistenceUnit(unitName = "eetraining")
    //    private EntityManagerFactory emf;

    //    @Transactional(value = TxType.REQUIRES_NEW,
    //                   rollbackOn = {
    //                                  NullPointerException.class,
    //                                  IllegalAccessError.class
    //                   })
    public void add(final PersonDTO person) {
        //        EntityManager createEntityManagerLoc = emf.createEntityManager();
        //        createEntityManagerLoc.persist(person);
        //        createEntityManagerLoc.close();
        this.em.persist(person);

        //person.setName("xyz");
    }

    // @Transactional(TxType.NEVER)
    public void update(final PersonDTO person) {
        if (!this.em.contains(person)) {
            PersonDTO mergeLoc = this.em.merge(person);
            //mergeLoc.setName("xyz");
        }
    }

    public void remove(final Long personId) {
        PersonDTO findLoc = this.em.find(PersonDTO.class,
                                         personId);
        if (findLoc != null) {
            this.em.remove(findLoc);
        }
    }

    public PersonDTO getOne(final Long personId) {
        return this.em.find(PersonDTO.class,
                            personId);
    }

    @Transactional(TxType.NOT_SUPPORTED)
    public List<PersonDTO> getAll() {
        TypedQuery<PersonDTO> createQueryLoc = this.em.createQuery("select p from PersonDTO p",
                                                                   PersonDTO.class);
        return createQueryLoc.getResultList();
    }

    public List<PersonDTO> getByName(final String name) {
        TypedQuery<PersonDTO> createQueryLoc = this.em.createQuery("select p from PersonDTO p where p.name=?1",
                                                                   PersonDTO.class);
        createQueryLoc.setParameter(1,
                                    name);
        return createQueryLoc.getResultList();
    }

    public List<PersonDTO> getByNameEx(final String name) {
        TypedQuery<PersonDTO> createQueryLoc = this.em.createNamedQuery("select_by_name",
                                                                        PersonDTO.class);
        createQueryLoc.setParameter(1,
                                    name);
        return createQueryLoc.getResultList();
    }

    public List<PersonDTO> getbYName2(final String name) {
        TypedQuery<PersonDTO> createQueryLoc = this.em.createQuery("select p from PersonDTO p where p.name=:xyz",
                                                                   PersonDTO.class);
        createQueryLoc.setParameter("xyz",
                                    name);
        return createQueryLoc.getResultList();
    }


    public List<PersonDTO> getAllNative() {
        Query createNativeQueryLoc = this.em.createNativeQuery("select * from person",
                                                               PersonDTO.class);
        List<PersonDTO> resultListLoc = createNativeQueryLoc.getResultList();
        return resultListLoc;
    }

    //    public void addPureJava(final PersonDTO person) {
    //        this.em.getTransaction()
    //               .begin();
    //        try {
    //            this.em.persist(person);
    //            this.em.getTransaction()
    //                   .commit();
    //        } catch (Exception eLoc) {
    //            this.em.getTransaction()
    //                   .rollback();
    //        }
    //    }

}
