package com.lms.test.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iboray.lms.application.service.PlanService;
import com.iboray.lms.domain.vo.PlanVO;
import com.iboray.lms.infrastructure.utils.JsonPojoMapper;
import com.iboray.lms.userinterface.common.Pager;

public class PlanTest {
	
	private static final String[] res = {"db/*.xml","service/*.xml","domain/*.xml","aop/tx.xml"};
	public static BeanFactory beanFactory = new ClassPathXmlApplicationContext(res);
	@Test
	public void findAll(){
		PlanService planService  = (PlanService)beanFactory.getBean("planService");
		Pager<PlanVO> uv = planService.findAll(0, 2);
		List<PlanVO> ul = uv.getPageList();
		String planJsonStr = "";
		planJsonStr = JsonPojoMapper.toJson(ul, true);
		System.out.println(planJsonStr);
//		for(Iterator<PlanVO> it = ul.iterator();it.hasNext();)
//			System.out.println(">>>>>>>>>>>>>>>>>"+it.next().getCartcode());
	}
	public void findPlanVOBYPlanNo(String planNo){
		
	}
	
	public void deleteByNos(String[] nos){
		
	}
	@Test
	public void createPlan(){
		PlanService planService  = (PlanService)beanFactory.getBean("planService");
		for(int i=100;i<200;i++){
			PlanVO p = new PlanVO();
			p.setCartcode("TESTCARTCODE"+i);
			p.setItemsname("测试物料名称"+i);
			p.setFkUsecompno("TESTUSECOMPNO"+i);
			p.setReceiptdate("20141111");
			p.setPlannum(20.0);
			p.setPlanprice(30.0);
			p.setPlanmoney(600.0);
			p.setPlanstatus("10");
			//int a = planService.createPlan(p);
			//System.out.println(a);
		}
	}
	
	public void updatePlan(PlanVO urv){
		
	}
	
	public void findByVO(PlanVO planVO,int offset,int limit){
		
	}
	
	public static void main(String[] args) {
		System.out.println((98+10-1)/10);
	}
}
