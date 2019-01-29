package com.yjf.esupplier.ws.info;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.data.TradeDetailData;
import com.yjf.esupplier.ws.enums.DivisionWayEnum;

public class TradeDetailInfo extends TradeDetailData {
	
	private static final long serialVersionUID = 7439253366356687767L;
	String tradeName;
	Money income=new Money(0,0);

    /**
     * 还款方式
     */
    private DivisionWayEnum repayDivisionWay;
	protected long demandId;

	public String getTradeName() {
		return tradeName;
	}
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	public Money getIncome() {
		return income;
	}
	public void setIncome(Money income) {
		this.income = income;
	}

    public DivisionWayEnum getRepayDivisionWay() {
        return repayDivisionWay;
    }

    public void setRepayDivisionWay(DivisionWayEnum repayDivisionWay) {
        this.repayDivisionWay = repayDivisionWay;
    }

    public long getDemandId() {
		return demandId;
	}
	public void setDemandId(long demandId) {
		this.demandId = demandId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TradeDetailInfo [tradeName=");
		builder.append(tradeName);
		builder.append(", income=");
		builder.append(income);
		builder.append(", repayDivisionWay=");
		builder.append(repayDivisionWay);
		builder.append(", demandId=");
		builder.append(demandId);
		builder.append("]");
		return builder.toString();
	}
	
}
