package com.qj.service.impl;

import com.qj.entity.Comment;
import com.qj.mapper.CommentMapper;
import com.qj.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qxiaoj
 * @since 2022-03-22
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
