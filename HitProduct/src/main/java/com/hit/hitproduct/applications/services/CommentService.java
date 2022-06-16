package com.hit.hitproduct.applications.services;

import com.hit.hitproduct.adapter.web.v1.transfer.responses.TrueFalseResponse;
import com.hit.hitproduct.domains.dtos.CommentDto;
import com.hit.hitproduct.domains.entities.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    List<Comment> getComments();

    Comment getCommentById(Long id);

    Comment createComment(Long idUser, Long idProductRate, CommentDto commentDto);

    Comment createCommentChild(Long idUser, Long idProductRate, Long idCmtParent, CommentDto commentDto);

    Comment updateComment(Long id, CommentDto commentDto);

    TrueFalseResponse deleteComment(Long id);
}
