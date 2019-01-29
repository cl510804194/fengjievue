package com.yjf.esupplier.ws.bill.info;

import java.io.Serializable;

import com.yjf.common.lang.util.money.Money;

public class OrderSumInfo implements Serializable {

	private static final long serialVersionUID = -4268265566395880221L;
	/*今天交易额*/
	private Money todayAmount;
	/*今天交易单*/
	private long todayCount;

	private long today020Count;

	private long todayHotelCount;
	/*7天交易额*/
	private Money sevenAmount;
	/*7天交易单*/
	private long sevenCount;

	private long seven020Count;

	private long sevenHotelCount;
	/*30天交易额*/
	private Money monthAmount;
	/*30天交易单数*/
	private long monthCount;

	private long month020Count;

	private long monthHotelCount;


	public Money getTodayAmount() {
		return todayAmount;
	}

	public void setTodayAmount(Money todayAmount) {
		this.todayAmount = todayAmount;
	}

	public long getTodayCount() {
		return todayCount;
	}

	public void setTodayCount(long todayCount) {
		this.todayCount = todayCount;
	}

	public Money getSevenAmount() {
		return sevenAmount;
	}

	public void setSevenAmount(Money sevenAmount) {
		this.sevenAmount = sevenAmount;
	}

	public long getSevenCount() {
		return sevenCount;
	}

	public void setSevenCount(long sevenCount) {
		this.sevenCount = sevenCount;
	}

	public Money getMonthAmount() {
		return monthAmount;
	}

	public void setMonthAmount(Money monthAmount) {
		this.monthAmount = monthAmount;
	}

	public long getMonthCount() {
		return monthCount;
	}

	public void setMonthCount(long monthCount) {
		this.monthCount = monthCount;
	}


	public long getToday020Count() {
		return today020Count;
	}

	public void setToday020Count(long today020Count) {
		this.today020Count = today020Count;
	}

	public long getTodayHotelCount() {
		return todayHotelCount;
	}

	public void setTodayHotelCount(long todayHotelCount) {
		this.todayHotelCount = todayHotelCount;
	}

	public long getSeven020Count() {
		return seven020Count;
	}

	public void setSeven020Count(long seven020Count) {
		this.seven020Count = seven020Count;
	}

	public long getSevenHotelCount() {
		return sevenHotelCount;
	}

	public void setSevenHotelCount(long sevenHotelCount) {
		this.sevenHotelCount = sevenHotelCount;
	}

	public long getMonth020Count() {
		return month020Count;
	}

	public void setMonth020Count(long month020Count) {
		this.month020Count = month020Count;
	}

	public long getMonthHotelCount() {
		return monthHotelCount;
	}

	public void setMonthHotelCount(long monthHotelCount) {
		this.monthHotelCount = monthHotelCount;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("OrderSumInfo{");
		sb.append("todayAmount=").append(todayAmount);
		sb.append(", todayCount=").append(todayCount);
		sb.append(", today020Count=").append(today020Count);
		sb.append(", todayHotelCount=").append(todayHotelCount);
		sb.append(", sevenAmount=").append(sevenAmount);
		sb.append(", sevenCount=").append(sevenCount);
		sb.append(", seven020Count=").append(seven020Count);
		sb.append(", sevenHotelCount=").append(sevenHotelCount);
		sb.append(", monthAmount=").append(monthAmount);
		sb.append(", monthCount=").append(monthCount);
		sb.append(", month020Count=").append(month020Count);
		sb.append(", monthHotelCount=").append(monthHotelCount);
		sb.append('}');
		return sb.toString();
	}

}
