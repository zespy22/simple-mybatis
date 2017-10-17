package com.sample.demo1;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sample.demo1.mappers.EmployeeMapper;
import com.sample.demo1.vo.Employee;

public class MybatisApp {
	public static void main(String[] args) throws Exception {
		
		String resource = "META-INF/mybatis/mybatis-config.xml";
		
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			List<Employee> employees = mapper.getAllEmployees();
			
			System.out.println("조회된 사원 수: " + employees.size());
		} finally {
			session.close();
		}
		
	}
}
