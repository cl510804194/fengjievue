package com.yjf.esupplier.web.controller.front.scenicCenter;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.user.query.UserQueryService;
import com.yjf.esupplier.web.controller.base.Image;
import com.yjf.esupplier.web.controller.front.BaseController.ProductManagerBaseController;
import com.yjf.esupplier.web.util.QRCodeUtil;
import com.yjf.esupplier.ws.enums.UserBizTypeEnum;
import com.yjf.esupplier.ws.product.enums.ProductVaryEnum;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.product.order.UpdateProductStatusOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

@Controller
@RequestMapping("/do/scenic")
public class ScenicProductManagerController extends ProductManagerBaseController {
	@Autowired
	protected UserQueryService userQueryService;
	
	@RequestMapping("doCenter/toCreateProduct.htm")
	public String toCreateProduct(	HttpServletRequest request, HttpServletResponse response,
									Model model) {
		return super.toCreateProduct(request, response, model);
	}

	@RequestMapping("doCenter/toCreateTicket.htm")
	public String toCreateTicket(	HttpServletRequest request, HttpServletResponse response,
									  Model model) {
		return super.toCreateTicket(request, response, model);
	}

	@RequestMapping("doCenter/toTicketList.htm")
	public String toTicketList(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		return super.toOtherList(request, response, model, ProductVaryEnum.ticket);
	}

	@RequestMapping("doCenter/toYlLineList.htm")
	public String toYlLineList(HttpServletRequest request, HttpServletResponse response,
							   Model model) {
		return super.toOtherList(request, response, model, ProductVaryEnum.line);
	}

	@RequestMapping("doCenter/toCreateYlLine.htm")
	public String toCreateYlLine(	HttpServletRequest request, HttpServletResponse response,
									 Model model) {
		return super.toCreateYlLine(request, response, model);
	}
	
	@RequestMapping("doCenter/createProduct.htm")
	public String createProduct(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		return super.createProduct(request, response, model);
	}
	
	@RequestMapping("doCenter/toUpdateProduct.htm")
	public String toUpdateProduct(	HttpServletRequest request, HttpServletResponse response,
									Model model) {
		/*获取景区商户*/
		model.addAttribute("suppliers", getScenicSuppliers(request));
		return super.toUpdateProduct(request, response, model);
	}

	@RequestMapping("doCenter/toUpdateTicket.htm")
	public String toUpdateTicket(	HttpServletRequest request, HttpServletResponse response,
									  Model model) {
		return super.toUpdateTicket(request, response, model);
	}

	@RequestMapping("doCenter/toUpdateYlLine.htm")
	public String toUpdateYlLine(	HttpServletRequest request, HttpServletResponse response,
									 Model model) {
		return super.toUpdateYlLine(request, response, model);
	}
	
	@RequestMapping("doCenter/updateProduct.htm")
	public String updateProduct(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		return super.updateProduct(request, response, model);
	}
	
	@RequestMapping("doCenter/checkProductNumber.htm")
	public String checkProductNumber(	HttpServletRequest request, HttpServletResponse response,
										Model model) {
		return super.checkProductNumber(request, response, model);
	}
	
	@RequestMapping("doCenter/toProductList.htm")
	public String toProductList(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		return super.toProductList(request, response, model);
	}
	
	@RequestMapping("doCenter/setTicketOff.htm")
	public String setTicketOff(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		request.setAttribute("productVaryEnum", ProductVaryEnum.ticket);
		return super.setProductOff(request, response, model);
	}

	@RequestMapping("doCenter/setYlLineOff.htm")
	public String setYlLineOff(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		request.setAttribute("productVaryEnum", ProductVaryEnum.line);
		return super.setProductOff(request, response, model);
	}

	@RequestMapping("doCenter/setProductOff.htm")
	public String setProductOff(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		request.setAttribute("productVaryEnum", ProductVaryEnum.product);
		return super.setProductOff(request, response, model);
	}
	
	@RequestMapping("doCenter/setTicketOn.htm")
	public String setTicketOn(	HttpServletRequest request, HttpServletResponse response,
								Model model) {
		request.setAttribute("productVaryEnum", ProductVaryEnum.ticket);
		return super.setProductOn(request, response, model);
	}
	@RequestMapping("doCenter/setYlLineOn.htm")
	public String setYlLineOn(	HttpServletRequest request, HttpServletResponse response,
								   Model model) {
		request.setAttribute("productVaryEnum", ProductVaryEnum.line);
		return super.setProductOn(request, response, model);
	}
	@RequestMapping("doCenter/setProductOn.htm")
	public String setProductOn(	HttpServletRequest request, HttpServletResponse response,
								   Model model) {
		request.setAttribute("productVaryEnum", ProductVaryEnum.product);
		return super.setProductOn(request, response, model);
	}
	
	public UpdateProductStatusOrder makeUpdateSatutsOrder(String productIdString) {
		return super.makeUpdateSatutsOrder(productIdString);
	}
	
	@RequestMapping("doCenter/setTicketDel.htm")
	public String setTicketDel(	HttpServletRequest request, HttpServletResponse response,
											Model model) {
		request.setAttribute("productVaryEnum", ProductVaryEnum.ticket);
		return super.updateProductStatusDel(request, response, model);
	}

	@RequestMapping("doCenter/setYlLineDel.htm")
	public String setYlLineDel(	HttpServletRequest request, HttpServletResponse response,
											 Model model) {
		request.setAttribute("productVaryEnum", ProductVaryEnum.line);
		return super.updateProductStatusDel(request, response, model);
	}

	@RequestMapping("doCenter/setProductDel.htm")
	public String updateProductStatusDel(	HttpServletRequest request, HttpServletResponse response,
											 Model model) {
		request.setAttribute("productVaryEnum", ProductVaryEnum.product);
		return super.updateProductStatusDel(request, response, model);
	}
	
	@RequestMapping("doCenter/getProductQrCode.htm")
	public String getProductQrCode(	HttpServletRequest request, HttpServletResponse response,
									HttpSession session, Model model) throws Exception {
		String pathTemp = request.getSession().getServletContext().getRealPath("");
		String productId = request.getParameter("productId");
		JSONObject json = new JSONObject();
		if (StringUtil.isNotBlank(productId)) {
			ProductInfo productInfo = productService
				.getProductById(NumberUtil.parseLong(productId));
			if (productInfo == null)
				return null;
			json.put("prductId", productId);
			json.put("amount", 1);
			json.put("price", productInfo.getPrice1().toStandardString());
			String text = json.toJSONString();
			String imageUrl = productInfo.getSmallPicPath();
			HttpURLConnection httpUrl = null;
			URL url = null;
			url = new URL(imageUrl);
			httpUrl = (HttpURLConnection) url.openConnection();
			httpUrl.connect();
			InputStream in = null;
			try {
				in = httpUrl.getInputStream();
			} catch (Exception e) {
				
			}
			int width = 60, height = 20;
			BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
			ServletOutputStream outputStream = response.getOutputStream();
			try {
				QRCodeUtil.encodeOutStream(text, in, outputStream, true);
				ImageIO.write(bufferedImage, "jpg", outputStream);
				outputStream.flush();
				outputStream.close();
				in.close();
			} catch (Exception e) {
			} finally {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
				if (in != null) {
					in.close();
				}
			}
		}
		return null;
	}
}
