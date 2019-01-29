package com.yjf.esupplier.domain.service.repository.impl;

import org.springframework.stereotype.Service;

import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.esupplier.dal.dataobject.HotelsStockDO;
import com.yjf.esupplier.dal.dataobject.TblHotelLongSetDO;
import com.yjf.esupplier.domain.HotelStockDomain;
import com.yjf.esupplier.domain.enums.EsupplieDomainResultEnum;
import com.yjf.esupplier.domain.exception.ExceptionDomainFactory;
import com.yjf.esupplier.domain.service.repository.HotelStockDomainRepository;
import com.yjf.esupplier.ws.hotel.enums.HotelStockStatusEnum;
import com.yjf.esupplier.ws.hotel.enums.HotelTypeEnum;

@Service("hotelStockDomainRepository")
public class HotelStockDomainRepositoryImpl extends DomainRepositoryBase
											implements HotelStockDomainRepository {
											
	@Override
	public void store(HotelStockDomain domain) {
		if (domain == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		HotelsStockDO hotelsStockDO = new HotelsStockDO();
		BeanCopier.staticCopy(domain, hotelsStockDO);
		hotelsStockDO.setStatus(domain.getStatus().getCode());
		hotelsStockDAO.insert(hotelsStockDO);
	}
	
	@Override
	public void reStore(HotelStockDomain domain) {
		if (domain == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		HotelsStockDO hotelsStockDO = new HotelsStockDO();
		BeanCopier.staticCopy(domain, hotelsStockDO);
		hotelsStockDO.setStatus(domain.getStatus().getCode());
		hotelsStockDAO.update(hotelsStockDO);
	}
	
	@Override
	public HotelStockDomain active(long hotelId, boolean isLock) {
		HotelsStockDO hotelsStockDO = null;
		if (isLock) {
			hotelsStockDO = hotelsStockDAO.findByIdForUpdate(hotelId);
		} else {
			hotelsStockDO = hotelsStockDAO.findById(hotelId);
		}
		if (hotelsStockDO == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		HotelStockDomain domain = new HotelStockDomain();
		BeanCopier.staticCopy(hotelsStockDO, domain);
		domain.setStatus(HotelStockStatusEnum.getByCode(hotelsStockDO.getStatus()));
		return domain;
	}
	
	public void addOrderNum(HotelStockDomain domain, HotelTypeEnum hotelTypeEnum, long orderNum) {
		if (domain == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		if (hotelTypeEnum == HotelTypeEnum.SPECIAL) {
			long specialNum = domain.getSpecialRoomNum() + orderNum;
			if (specialNum > domain.getSpecialRoomTotalNum())
				throw ExceptionDomainFactory
					.newDomainException(EsupplieDomainResultEnum.EXAM_SELF_NOT_PASS, "特价房预订数量有误！");
			domain.setSpecialRoomNum(specialNum);
			long leftNum = domain.getOrdainNum() + orderNum;
			domain.setOrdainNum(leftNum);
		} else if (hotelTypeEnum == HotelTypeEnum.MORNING) {
			long morningNum = domain.getMorningRoomNum() + orderNum;
			if (morningNum > domain.getMorningRoomTotalNum())
				throw ExceptionDomainFactory
					.newDomainException(EsupplieDomainResultEnum.EXAM_SELF_NOT_PASS, "凌晨房预订数量有误！");
			domain.setMorningRoomNum(morningNum);
			long leftNum = domain.getOrdainNum() + orderNum;
			domain.setOrdainNum(leftNum);
		} else if (hotelTypeEnum == HotelTypeEnum.LONGRENT) {
			long longNum = domain.getLongRoomNum() + orderNum;
			TblHotelLongSetDO longSetDO = hotelLongSetDAO.findBySupplierIdAndProductId(
				domain.getSupplierId(), domain.getProductId());
			if (longSetDO == null || longNum > longSetDO.getRoomNum())
				throw ExceptionDomainFactory.newDomainException(
					EsupplieDomainResultEnum.EXAM_SELF_NOT_PASS, "长包房预订数量有误！");
			domain.setLongRoomNum(longNum);
			long leftNum = domain.getOrdainNum() + orderNum;
			domain.setOrdainNum(leftNum);
		} else {
			long normalNum = domain.getOrdainNum() + orderNum;
			if (normalNum > domain.getAvailableStock())
				throw ExceptionDomainFactory
					.newDomainException(EsupplieDomainResultEnum.EXAM_SELF_NOT_PASS, "房间预订数量有误！");
			domain.setOrdainNum(normalNum);
		}
		reStore(domain);
	}
	
	public void delOrderNum(HotelStockDomain domain, HotelTypeEnum hotelTypeEnum, long orderNum) {
		if (domain == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		if (hotelTypeEnum == HotelTypeEnum.SPECIAL) {
			long specialNum = domain.getSpecialRoomNum() - orderNum;
			if (specialNum < 0)
				throw ExceptionDomainFactory
					.newDomainException(EsupplieDomainResultEnum.EXAM_SELF_NOT_PASS, "特价房退订数量有误！");
			domain.setSpecialRoomNum(specialNum);
			long leftNum = domain.getOrdainNum() - orderNum;
			domain.setOrdainNum(leftNum);
		} else if (hotelTypeEnum == HotelTypeEnum.MORNING) {
			long morningNum = domain.getMorningRoomNum() - orderNum;
			if (morningNum < 0)
				throw ExceptionDomainFactory
					.newDomainException(EsupplieDomainResultEnum.EXAM_SELF_NOT_PASS, "凌晨房退订数量有误！");
			domain.setMorningRoomNum(morningNum);
			long leftNum = domain.getOrdainNum() - orderNum;
			domain.setOrdainNum(leftNum);
		} else if (hotelTypeEnum == HotelTypeEnum.LONGRENT) {
			long longNum = domain.getLongRoomNum() - orderNum;
			if (longNum < 0)
				throw ExceptionDomainFactory.newDomainException(
					EsupplieDomainResultEnum.EXAM_SELF_NOT_PASS, "长包房退订数量有误！");
			domain.setLongRoomNum(longNum);
			long leftNum = domain.getOrdainNum() - orderNum;
			domain.setOrdainNum(leftNum);
		} else {
			long normalNum = domain.getOrdainNum() - orderNum;
			if (normalNum < 0)
				throw ExceptionDomainFactory
					.newDomainException(EsupplieDomainResultEnum.EXAM_SELF_NOT_PASS, "房间退订数量有误！");
			domain.setOrdainNum(normalNum);
		}
		reStore(domain);
		
	}
	
}
