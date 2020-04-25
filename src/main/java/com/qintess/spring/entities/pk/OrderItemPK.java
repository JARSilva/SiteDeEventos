package com.qintess.spring.entities.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderItemPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "order_id")
	private Integer order;

	@Column(name = "event_id")
	private Integer event;

	public OrderItemPK() {
		super();
	}

	public OrderItemPK(Integer order, Integer event) {
		super();
		this.order = order;
		this.event = event;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getEvent() {
		return event;
	}

	public void setEvent(Integer event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "OrderItemPK [order=" + order + ", event=" + event + "]";
	}

	

}
