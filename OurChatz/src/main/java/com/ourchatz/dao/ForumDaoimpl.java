package com.ourchatz.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ourchatz.model.Forum;

@Transactional
@Repository
public class ForumDaoimpl implements ForumDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void addQuestion(Forum forum) {
		Session session=sessionFactory.getCurrentSession();
		session.save(forum);
	}
	public List<Forum> viewQuestions() {
		Session session=sessionFactory.getCurrentSession();
		return session.createCriteria(Forum.class).list();
	}
	public void updateQuestion(Forum forum)
	{
		Session session=sessionFactory.getCurrentSession();
		session.update(forum);
	}
	public void deleteQuestion(int id) {
		Session session=sessionFactory.getCurrentSession();
		Forum forum=(Forum) session.load(Forum.class,new Integer(id));
		session.delete(forum);
	}
	public Forum getQuestion(int id) {
		Session session=sessionFactory.getCurrentSession();
		Forum forum=(Forum) session.get(Forum.class,new Integer(id));
		System.out.println("description:"+forum.getQuestionDescription());
		return forum;
	}

}
