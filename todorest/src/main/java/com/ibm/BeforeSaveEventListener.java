package com.ibm;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

import com.ibm.model.Todo;

@Component
public class BeforeSaveEventListener extends AbstractRepositoryEventListener<Todo> {

	@Override
	protected void onAfterCreate(Todo entity) {
		// TODO Auto-generated method stub
		super.onAfterCreate(entity);
		System.out.println("========================");
		System.out.println(entity);
		System.out.println("========================");
	}
}
