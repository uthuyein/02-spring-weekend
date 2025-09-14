package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Account;

public class E_SynchronizationDb extends JpaFactory {

	@Test
	void test() throws InterruptedException {

		Thread opeOne = OperationOne(5000);
		Thread opeTwo = OperationTwo(15000);
		opeOne.start();
		opeTwo.start();
		Thread.sleep(1500);

	}

	private Thread OperationOne(double balance) {
		return new Thread(() -> {
			var em = emf.createEntityManager();
			var a1 = em.find(Account.class, 1);
			
			try {
				em.getTransaction().begin();
				System.out.println("=====  Before update opertaion one ======");

				System.out.println("===== (One) Before Update Balance :" + a1.getBalance() + " ======");

				Thread.sleep(800);
				
				em.refresh(a1);
				
				a1.setBalance(a1.getBalance() + balance);
				System.out.println("=====  After update opertaion one ======");

				System.out.println("=====(One)After Update Balance :" + a1.getBalance() + " ======");

				em.getTransaction().commit();
				em.close();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
	}

	private Thread OperationTwo(double balance) {

		return new Thread(() -> {
			var em = emf.createEntityManager();
			var a1 = em.find(Account.class, 1);
			try {
				em.getTransaction().begin();
				System.out.println("   =====  Before update opertaion Two ======");

				System.out.println("----- (Two)Before Update Balance :" + a1.getBalance() + "  ------");

				Thread.sleep(500);
				//em.refresh(a1);
				a1.setBalance(a1.getBalance() + balance);
				em.flush();
				System.out.println("   =====  After update opertaion Two ======");
				System.out.println("-----  (Two)After Update Balance :" + a1.getBalance() + " -----");

				em.getTransaction().commit();
				em.close();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
}
