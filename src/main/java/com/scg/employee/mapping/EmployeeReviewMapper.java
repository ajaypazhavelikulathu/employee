package com.scg.employee.mapping;

import org.mapstruct.Mapper;

import com.scg.employee.dao.entity.Review;
import com.scg.employee.vo.ReviewVo;

@Mapper(componentModel = "spring")

public interface EmployeeReviewMapper {

	ReviewVo toVo(Review review);

	Review toEntity(ReviewVo reviewVo);

}
