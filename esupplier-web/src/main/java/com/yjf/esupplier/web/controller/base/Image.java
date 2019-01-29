package com.yjf.esupplier.web.controller.base;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.gimpy.BlockGimpyRenderer;
import nl.captcha.gimpy.DropShadowGimpyRenderer;
import nl.captcha.gimpy.FishEyeGimpyRenderer;
import nl.captcha.gimpy.RippleGimpyRenderer;
import nl.captcha.noise.CurvedLineNoiseProducer;

import com.yjf.common.env.Env;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.log.Logger;
import com.yjf.common.log.LoggerFactory;

public class Image {
	protected static final Logger logger = LoggerFactory.getLogger(Image.class);
	static Captcha.Builder builder = null;
	
	public static Color getRandColor(int fc, int bc) {
		// 给定范围获得随机颜色
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	
	public static char getRandom() {
		String value = "2345679ACDEFHJKLMNPRSTUVWXYZacdefhjklmnprstuvwxyz";
		int randomNumber = 0;
		randomNumber = (int) (Math.random() * value.length());
		return value.toCharArray()[randomNumber];
	}
	
	// 生成随机字符
	private static String getRandChar(int length) {
		String code = "";
		//Random random = new Random();
		for (int i = 0; i < length; i++) {
			//			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字
			//			String charOrNum = "char";
			//			if ("char".equalsIgnoreCase(charOrNum)) // 字符串
			//			{
			//				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
			//				code += (char) (choice + random.nextInt(26));
			//			} else if ("num".equalsIgnoreCase(charOrNum)) // 数字
			//			{
			//				code += String.valueOf(random.nextInt(10));
			//			}
			code += String.valueOf(getRandom());
		}
		return code;
	}
	
	public static void creatImageNew(HttpSession session, OutputStream outputStream) {
		
		builder = new Captcha.Builder(150, 50);
		//噪声
		builder.addNoise(new CurvedLineNoiseProducer(Color.blue, 0.8233f));
		//添加随机字体
		List<Font> fontList = new ArrayList<Font>();
		fontList.add(new Font("Arial", Font.HANGING_BASELINE, 34));//可以设置斜体之类的
		fontList.add(new Font("Courier", Font.LAYOUT_LEFT_TO_RIGHT, 40));
		fontList.add(new Font("Courier", Font.ITALIC, 30));
		fontList.add(new Font("Courier", Font.PLAIN, 50));
		//字体颜色
		List<Color> colorList = new ArrayList<Color>();
		colorList.add(Color.red);
		colorList.add(Color.black);
		colorList.add(Color.orange);
		colorList.add(Color.green);
		nl.captcha.text.renderer.DefaultWordRenderer dwr = new nl.captcha.text.renderer.DefaultWordRenderer(
			colorList, fontList);
		builder.addText(dwr);
		//背景，渐变
		GradiatedBackgroundProducer gbp = new GradiatedBackgroundProducer();
		gbp.setFromColor(Color.gray);
		gbp.setToColor(Color.white);
		builder.addBackground(gbp);
		//各种滤镜
		builder.gimp(new BlockGimpyRenderer(1));
		builder.gimp(new RippleGimpyRenderer());
		Color color = new Color(0.0f, 0.0f, 0.0f, 0.0f);
		builder.gimp(new FishEyeGimpyRenderer(color, color));
		builder.gimp(new DropShadowGimpyRenderer(2, 77));
		
		//创建对象
		Captcha captcha = builder.build();
		try {
			//生成图片
			ImageIO.write(captcha.getImage(), "png", outputStream);
		} catch (Exception e) {
			logger.error("生成图片失效", e);
		}
		
		session.setAttribute("errCount", 0);
		session.setAttribute("imgCode", captcha.getAnswer());
		
	}
	
	public static BufferedImage creatImage(HttpSession session) {
		//初始化验证码
		String sRand = "";
		// 在内存中创建图象
		int width = 60, height = 20;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		Graphics g = image.getGraphics();
		// 生成随机类
		Random random = new Random();
		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		// 设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 115; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		// 取随机产生的认证码(4位数字)
		for (int i = 0; i < 4; i++) {
			String rand = getRandChar(1);
			sRand += rand;
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random
				.nextInt(110)));
			// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			if (!Env.isOnline()) {
				g.drawString("8", 13 * i + 6, 16);
			} else {
				g.drawString(rand, 13 * i + 6, 16);
			}
			
		}
		// 图象生效
		g.dispose();
		if (!Env.isOnline()) {
			sRand = "8888";
		}
		session.setAttribute("imgCodeMaxCount", 0);
		session.setAttribute("errCount", 0);
		session.setAttribute("imgCode", sRand);
		return image;
	}
	
	public static boolean checkImgCode(HttpSession session, String imgCode) {
		boolean bool = false;
		int errCount = 0;
		int imgCodeMaxCount = 0;
		if (session.getAttribute("errCount") != null) {
			errCount = (int) session.getAttribute("errCount");
		}
		if (session.getAttribute("imgCodeMaxCount") != null) {
			imgCodeMaxCount = (int) session.getAttribute("imgCodeMaxCount");
		}
		if (imgCodeMaxCount > 5) {
			session.setAttribute("errCount", 0);
			session.removeAttribute("imgCode");
			session.removeAttribute("imgCodeMaxCount");
			return false;
		}
		String oldImgCode = (String) session.getAttribute("imgCode");
		if (StringUtil.isNotEmpty(imgCode) && imgCode.equalsIgnoreCase(oldImgCode) && errCount < 5) {
			bool = true;
			imgCodeMaxCount++;
			session.setAttribute("imgCodeMaxCount", imgCodeMaxCount);
		} else {
			errCount++;
			session.setAttribute("errCount", errCount);
		}
		if (errCount == 5) {
			session.setAttribute("errCount", 0);
			session.setAttribute("imgCodeMaxCount", 0);
			session.removeAttribute("imgCode");
		}
		return bool;
	}
}
