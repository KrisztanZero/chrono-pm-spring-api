package org.chronopm.chronopmspringapi.services;

import org.chronopm.chronopmspringapi.dtos.CommentDto;
import org.chronopm.chronopmspringapi.mappers.CommentMapper;
import org.chronopm.chronopmspringapi.models.Comment;
import org.chronopm.chronopmspringapi.repositories.ICommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService implements IEntityService<CommentDto> {

    private final ICommentRepository commentRepository;

    public CommentService(ICommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentDto> getAll() {
        return commentRepository.findAll()
                .stream()
                .map(CommentMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto getById(String id) {
        return CommentMapper.mapToDto(getCommentById(id));
    }

    @Override
    public CommentDto create(CommentDto commentDto) {
        var comment = commentRepository.save(CommentMapper.mapToModel(commentDto));
        return CommentMapper.mapToDto(comment);
    }

    @Override
    public CommentDto update(CommentDto commentDto, String id) {
        var existingComment = getCommentById(id);
        var updatedComment = CommentMapper.mapForUpdate(commentDto, existingComment);
        updatedComment.setId(id);
        var comment = commentRepository.save(updatedComment);
        return CommentMapper.mapToDto(comment);
    }

    @Override
    public String delete(String id) {
        commentRepository.deleteById(id);

        return id;
    }

    private Comment getCommentById(String id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));
    }
}
