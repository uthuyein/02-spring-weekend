package com.jdc.mkt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.utils.JpaFactory;

public class C_GettingResult extends JpaFactory {

	@Order(4)
	@ParameterizedTest
	@CsvSource({ "3,145", "4,1219"

	})
	void getSingleResultTest(int vId, String res) {
		var query = em.createQuery("select sum(subTotal) from VoucherDetail vd where vd.id.voucher.id = :vId",Double.class);
		query.setParameter("vId", vId);
		var sum = query.getSingleResult();
		assertEquals(Double.valueOf(res), sum);

	}

	@Order(3)
	@ParameterizedTest
	@CsvSource({ "Books,2", "Sports,2"

	})
	void getResultStreamTest(String name, long res) {
		var query = em.createQuery("select p from Product p where p.category.name = :name");
		query.setParameter("name", name);
		var stream = query.getResultStream();
		assertEquals(res, stream.count());
	}

	@Order(2)
	@ParameterizedTest
	@CsvSource({ "Books,2", "Sports,2"

	})
	void getResultListTest(String name, long res) {
		var query = em.createQuery("select p from Product p where p.category.name = :name");
		query.setParameter("name", name);
		var list = query.getResultList();
		assertEquals(res, list.stream().count());
	}

	@Order(1)
	@ParameterizedTest
	@CsvSource({ "false,2,2" })
	void executeUpdateTest(boolean active, int catId, int res) {
		em.getTransaction().begin();
		var query = em.createQuery("update Product p set p.active = :active where p.category.id = :id");
		query.setParameter("active", active);
		query.setParameter("id", catId);
		int result = query.executeUpdate();
		assertEquals(res, result);

		em.getTransaction().commit();
	}

}
