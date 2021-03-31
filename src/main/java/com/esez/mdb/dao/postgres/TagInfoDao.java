package com.esez.mdb.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.esez.mdb.model.postgres.TagInfo;
import com.esez.mdb.model.postgres.User;
import com.google.common.base.Strings;


@Transactional
@Repository(value = "TagInfoDao")
public class TagInfoDao {

    @PersistenceContext(unitName = "postgresPU")
    EntityManager em;
    
    
    @Autowired
    @Qualifier("jdbcTemplatePostgres")
    private JdbcTemplate jdbcTemplatePostgres;
    
    @Autowired
    @Qualifier("jdbcTemplateTibero")
    private JdbcTemplate jdbcTemplateTibero;
    
    
    
    
    /**
     * total count get 
     * @param paramMap
     * @return
     */
    public int getTotalCount(Map<String, Object> paramMap) {

        String siteCd = paramMap.get("siteCd") == null ? "" : paramMap.get("siteCd").toString();
    	String tagNm = paramMap.get("tagNm") == null ? "" : paramMap.get("tagNm").toString();
		String tagType = paramMap.get("tagType") == null ? "" : paramMap.get("tagType").toString();

		StringBuilder sb = new StringBuilder();
    	sb.append(" SELECT count(ti) FROM TagInfo AS ti ");
    	sb.append(" WHERE 1=1 ");
    	if (siteCd != null && !siteCd.equals("")) {
    		sb.append(" AND siteCd = :siteCd ");
    	}
    	if (tagNm != null) {
    		sb.append(" AND tagNm like :tagNm ");
    	}
    	if (tagType != null) {
    		sb.append(" AND tagType = :tagType ");
    	}
    	
    	Query query = em.createQuery(sb.toString());
    	if (siteCd != null) {
    		query.setParameter("siteCd", siteCd);
    	}
    	if (tagNm != null) {
    		query.setParameter("tagNm", tagNm);
    	}
    	if (tagType != null) {
    		query.setParameter("tagType", tagType);
    	}
    	
    	int result = ((Long) query.getSingleResult()).intValue();
    	
    	return result;
    }
    
    private final String INSERTSQL="INSERT INTO zium.users(id,name) values(?,?)";
    
    
    public User create(User user){
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplatePostgres.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(INSERTSQL, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1,user.getId());
                ps.setString(2,user.getName());

                return ps;
            }
        }, holder);

        int newUserId=(int)holder.getKeys().get("id");
        // int newUserId=holder.getKey().intValue();   postgres 는 전체를 필드를 돌려준다.
        user.setId(newUserId);
        return user;
    }
    
    
    public void createList(List<User> userList) {
        List<Object[]> batch = new ArrayList<Object[]>();
        for (User user:userList) {
            Object[] values = new Object[]{
                    user.getId(),user.getName()
            };
            batch.add(values);
         }
         int[] updateCounts = jdbcTemplatePostgres.batchUpdate(INSERTSQL,batch);
    }
    
}
