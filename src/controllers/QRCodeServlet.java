package controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;


/**
 * Servlet implementation class QRCodeServlet
 */
@WebServlet("/qrcode")
public class QRCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QRCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String productId=request.getParameter("productId");
		response.setContentType("image/png");
		OutputStream outputStream=response.getOutputStream();
		outputStream.write(getQRCodeImage(productId,400,400));
		outputStream.flush();
		outputStream.close(); 
			}
private byte[] getQRCodeImage(String text, int width, int height){
    try{
    	QRCodeWriter qrCodeWriter = new QRCodeWriter();
    	BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE ,width ,height);
    	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    	MatrixToImageWriter.writeToStream(bitMatrix, "png",byteArrayOutputStream);
    	return byteArrayOutputStream.toByteArray();
	}catch (Exception e)
{
		return null;}}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
