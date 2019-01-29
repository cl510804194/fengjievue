package com.yjf.esupplier.ws.info;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.data.RepayPlanData;
import com.yjf.esupplier.ws.enums.DivisionWayEnum;

public class RepayPlanInfo extends RepayPlanData {

	
	
	/** 借款需求ID */
	protected long demandId;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3760454143586881547L;
	public Money getInterest()
	{
        if(this.getRepayDivisionWay() == DivisionWayEnum.MONTH_PRINCIPAL_INTEREST){

            return this.getAmount().subtract(this.getRepayPrincipalAmount());
        }else{
            if(this.getPeriodNo()==this.getPeriodCount())
            {
                return this.getAmount().subtract(this.getOriginalAmount());
            }
            else
            {
                return this.getAmount();
            }
        }

	}
	
	public long getDemandId() {
		return this.demandId;
	}
	public void setDemandId(long demandId) {
		this.demandId = demandId;
	}
}
