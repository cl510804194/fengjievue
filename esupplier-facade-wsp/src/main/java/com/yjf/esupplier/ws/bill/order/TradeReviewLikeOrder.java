package com.yjf.esupplier.ws.bill.order;

import com.yjf.esupplier.ws.bill.enums.CommentLikeTypeEnum;
import com.yjf.esupplier.ws.bill.enums.OperateTypeEnum;
import com.yjf.esupplier.ws.order.ProcessOrder;
import com.yjf.esupplier.ws.review.order.TradeReviewCreateOrder;

public class TradeReviewLikeOrder extends ProcessOrder {
	
	private static final long serialVersionUID = 8095938059938752512L;
	
	/*点赞的评价ID*/
	private long commentId;
	/*评价点赞类型*/
	private CommentLikeTypeEnum commentLikeTypeEnum;
	/*操作类型*/
	private OperateTypeEnum operateTypeEnum;
	
	public long getCommentId() {
		return commentId;
	}
	
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	
	public CommentLikeTypeEnum getCommentLikeTypeEnum() {
		return commentLikeTypeEnum;
	}
	
	public void setCommentLikeTypeEnum(CommentLikeTypeEnum commentLikeTypeEnum) {
		this.commentLikeTypeEnum = commentLikeTypeEnum;
	}
	
	public OperateTypeEnum getOperateTypeEnum() {
		return operateTypeEnum;
	}
	
	public void setOperateTypeEnum(OperateTypeEnum operateTypeEnum) {
		this.operateTypeEnum = operateTypeEnum;
	}
	
	@Override
	public void check() {
		super.check();
		validateNotNull(commentId, "评价信息");
		validateNotNull(commentLikeTypeEnum, "评价点赞类型");
		validateNotNull(operateTypeEnum, "操作类型");
		validateGreaterThan(processorId, "用户ID");
	}
}
