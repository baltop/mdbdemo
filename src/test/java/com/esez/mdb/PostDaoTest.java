package com.esez.mdb;



import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esez.mdb.dao.postgres.TagInfoDao;



@SpringBootTest
public class PostDaoTest {

	@Autowired
	private TagInfoDao tagInfoDao;

//	@Autowired
//	EntityManager em;

	@Test
	public void testGetAll() {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("siteCd", "ZIUM");
		paramMap.put("tagNm", "Vm");
		paramMap.put("tagType", "IOT003002");		

		int count = tagInfoDao.getTotalCount(paramMap);

		assertEquals(1, count);



	}

//	@Test
//	public void test_sql_hibernate_dto_query_example() {
//		Query query = em.createNativeQuery("SELECT cd_nm, cd, cd_desc FROM iot_web.comm_cd_info");
//		query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//
//		Session session = em.unwrap(Session.class);
//		List<Map<String, Object>> mapList = session
//				.createNativeQuery("SELECT cd_nm, cd, cd_desc FROM iot_web.comm_cd_info")
//				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
//
//		System.out.println(mapList);
//		query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
//
//		List<PersonSummaryDTO> dtos = session.createNativeQuery("SELECT cd_nm, cd, cd_desc FROM iot_web.comm_cd_info")
//				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
//
//		doInJPA(this::entityManagerFactory, entityManager -> {
//			Session session = entityManager.unwrap(Session.class);
//			// tag::sql-hibernate-dto-query-example[]
//			List<PersonSummaryDTO> dtos = session
//					.createNativeQuery("SELECT p.id as \"id\", p.name as \"name\" " + "FROM Person p")
//					.setResultTransformer(Transformers.aliasToBean(PersonSummaryDTO.class)).list();
//			// end::sql-hibernate-dto-query-example[]
//			assertEquals(3, dtos.size());
//		});
//	}

}