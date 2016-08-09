package com.funliving.info.repository;

import com.funliving.info.repository.entity.Apartment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:applicationContext-test.xml"})
@TransactionConfiguration(transactionManager = "translationManager", defaultRollback = true)
@Transactional
public class ApartmentRepositoryTest {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Test
    public void testGetEntity() throws Exception {
        Apartment apartment = new Apartment();
        apartment.setName("Chapter Spitalfields22");
        apartment.setCoordinate("1.634,1.8333");
        apartment.setCity(1);
        apartment.setNation(1);
        apartment.setAddress("9 Frying Pan Alley, Spitalfields街区, 伦敦, E1 7HS");
        apartment.setCurrency(1);
        apartment.setRent(264.0f);
        apartment.setCreateTime(new Date());
        apartment.setLastTime(new Date());
        apartment.setImages("https://static.student-cdn.cn/media/cache/light_gallery_main_desktop/mstr/country/united-kingdom/city/london/property/prodigy-living-spitalfields/image-o83j06.jpeg");
        int count= apartmentRepository.create(apartment);
        assertTrue(count > 0);
        System.out.println(apartment.getId());
        Apartment entity = apartmentRepository.getEntity(apartment.getId());
        System.out.println(entity);
        assertThat(entity.getName(),is("Chapter Spitalfields22"));
    }

    @Test
    public void testUpdate() throws Exception {
        Apartment apartment = new Apartment();
        apartment.setName("Chapter Spitalfields22");
        apartment.setCoordinate("1.634,1.8333");
        apartment.setCity(1);
        apartment.setNation(1);
        apartment.setAddress("9 Frying Pan Alley, Spitalfields街区, 伦敦, E1 7HS");
        apartment.setCurrency(1);
        apartment.setRent(264.0f);
        apartment.setCreateTime(new Date());
        apartment.setLastTime(new Date());
        apartment.setImages("https://static.student-cdn.cn/media/cache/light_gallery_main_desktop/mstr/country/united-kingdom/city/london/property/prodigy-living-spitalfields/image-o83j06.jpeg");
        apartment.setId(1);
        int count = apartmentRepository.update(apartment);
//        assertTrue(count > 0);
    }
}