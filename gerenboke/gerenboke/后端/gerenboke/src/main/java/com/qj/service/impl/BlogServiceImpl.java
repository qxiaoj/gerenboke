package com.qj.service.impl;

import com.qj.entity.Blog;
import com.qj.mapper.BlogMapper;
import com.qj.service.BlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
