package org.sourya.springaspect;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service //semantic variation of @Component
public class CommentService {
	private Logger logger = Logger.getLogger(CommentService.class.getName());
	
	public void publishComment(Comment comment) {
		logger.info("publishing comment:" + comment.getText());
	}
}
