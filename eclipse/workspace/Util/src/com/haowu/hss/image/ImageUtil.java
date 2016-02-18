package com.haowu.hss.image;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageUtil {
	private static ImageUtil imageUtil = null;
	private Image arch;
	private ImageIcon watermark;
	private String targetFileUrl=null;

	private ImageUtil() {
	}

	private static class BuildImage {
		private static ImageUtil build() {
			return new ImageUtil();
		}
	}

	private void init(Image arch, ImageIcon watermark, String targetFileUrl) {
		this.targetFileUrl = targetFileUrl;
		this.arch = arch;
		this.watermark = watermark;
	}

	/**
	 * 初始化
	 * 
	 * @param archUrl
	 *            原图片路径
	 * @param watermarkUrl
	 *            水印图片路径
	 * @param targetFileUrl
	 *            目标图片路径
	 * @return ImageUtil对象
	 * @throws IOException
	 */
	public static ImageUtil build(String archUrl, String watermarkUrl, String targetFileUrl) throws IOException {
		try {
			Image image = ImageIO.read(new File(archUrl));
			ImageIcon imageIcon = new ImageIcon(watermarkUrl);
			return build(image, imageIcon, targetFileUrl);
		} catch (IOException e) {
			throw e;
		}
	}
	/**
	 * 当使用该方法创建对象时，必须设置原始图片、水印图片；
	 * @return
	 */
	public static ImageUtil build(){
		if (imageUtil == null) {
			imageUtil = BuildImage.build();
		}
		return imageUtil;
	}	

	/**
	 * 初始化
	 * 
	 * @param arch
	 *            原始图片
	 * @param watermark
	 *            水印图片
	 * @param targetFileUrl
	 *            目标路径
	 * @return
	 */
	public static ImageUtil build(Image arch, ImageIcon watermark, String targetFileUrl) {
		if (imageUtil == null) {
			imageUtil = BuildImage.build();
		}
		imageUtil.init(arch, watermark, targetFileUrl);
		return imageUtil;
	}
	
	
	public void setArch(Image arch) {
		this.arch = arch;
	}

	public void setWatermark(ImageIcon watermark) {
		this.watermark = watermark;
	}

	public void setTargetFileUrl(String targetFileUrl) {
		this.targetFileUrl = targetFileUrl;
	}

	/**
	 * 添加水印
	 * 
	 * @param degree
	 *            水印角度,取值范围：0-360
	 * @param alpha
	 *            水印透明度，取值：0.0-1.0f
	 * @param x
	 *            x轴偏移比例，取值范围：0.0-1.0f
	 * @param y
	 *            y轴偏移比例，取值范围：0.0-1.0f
	 * @throws IOException
	 */
	public void addWatermark(Integer degree, Float alpha, float x, float y) throws IOException {
		if(targetFileUrl==null){
			File file=new File("D:/files/");
			if (!file.exists()) {
				file.mkdirs();
			}
			targetFileUrl="D:/files/"+System.currentTimeMillis()+".jpg";
		}
		
		BufferedImage bImage = new BufferedImage(arch.getWidth(null), arch.getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bImage.createGraphics();
		// 设置呈现的效果
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		// 将原图像先画到中间图像版上
		g.drawImage(arch, 0, 0, null);
		int l = (int) Math
				.ceil(Math.sqrt(Math.pow(watermark.getIconWidth(), 2) + Math.pow(watermark.getIconHeight(), 2)));
		BufferedImage image = new BufferedImage(l, l, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gpd = image.createGraphics();
		gpd.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		if (null != degree) {
			// 设置水印旋转
			gpd.rotate(Math.toRadians(degree), (double) (l / 2), (double) (l / 2));
		}
		gpd.drawImage(watermark.getImage(), (int) ((1 - (float) watermark.getIconWidth() / l) / 2 * l),
				(int) ((1 - (float) watermark.getIconHeight() / l) / 2 * l), null);
		
		gpd.dispose();
		if (alpha > 1) {
			alpha = 1.0f;
		} else if (alpha < 0) {
			alpha = 0.0f;
		}
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));

		if (x > 1 - (float) l / arch.getWidth(null)) {
			x = 1 - (float) l / arch.getWidth(null);
		} else if (x < 0) {
			x = 0.0f;
		}
		if (y > 1 - (float) (l / arch.getHeight(null))) {
			y = 1 - (float) (l/ arch.getHeight(null));
		} else if (y < 0) {
			y = 0.0f;
		}
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		// 将水印以设置好的透明度和组合方式添加到目标画板
		g.drawImage(image, (int) (x * arch.getWidth(null)), (int) (y * arch.getHeight(null)), null);
		
		g.dispose();
		// 将设置好的画板输出到指定位置
		FileOutputStream outputStream = new FileOutputStream(targetFileUrl);
		ImageIO.write(bImage, "JPG", outputStream);
		if (outputStream != null) {
			outputStream.close();
		}
	}

}
