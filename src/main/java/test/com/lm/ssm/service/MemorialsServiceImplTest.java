package test.com.lm.ssm.service; 

import com.lm.ssm.entity.Memorials;
import com.lm.ssm.mapper.MemorialsMapper;
import com.lm.ssm.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/** 
* MemorialsServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>5月 22, 2022</pre> 
* @version 1.0 
*/
public class MemorialsServiceImplTest {
    @Autowired
    private MemorialsMapper memorialsMapper;


    @Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getMemorialsAll() 
* 
*/ 
@Test
public void testGetMemorialsAll() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getMemorialsById(String id) 
* 
*/ 
@Test
public void testGetMemorialsById() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: saveMemorials(Memorials memorials) 
* 
*/ 
@Test
public void testSaveMemorials() throws Exception { 
//TODO: Test goes here...

//    return lists;
} 

/** 
* 
* Method: deleteMemorials(String id) 
* 
*/ 
@Test
public void testDeleteMemorials() throws Exception { 
//TODO: Test goes here...
} 

/** 
* 
* Method: updateMemorials(Memorials memorials) 
* 
*/ 
@Test
public void testUpdateMemorials() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: applyMemorials(String id, String requestBody) 
* 
*/ 
@Test
public void testApplyMemorials() throws Exception { 
//TODO: Test goes here... 
} 


} 
