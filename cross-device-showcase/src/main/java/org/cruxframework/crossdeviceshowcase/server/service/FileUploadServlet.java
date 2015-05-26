package org.cruxframework.crossdeviceshowcase.server.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServlet
 */
public class FileUploadServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1183019676233475190L;

	private final static Logger LOGGER = 
            Logger.getLogger(FileUploadServlet.class.getCanonicalName());
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		processRequest(request,response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		// Create path components to save the file
		final Part filePart = request.getPart("file");

		//Comentar daqui para baixo quando o showcase for para a appengine
		final String path = "c:\\temp\\";
		final String fileName = getFileName(filePart);

		OutputStream out = null;
		InputStream filecontent = null;
		final PrintWriter writer = response.getWriter();

		try {
			out = new FileOutputStream(new File(path + File.separator
					+ fileName));
			filecontent = filePart.getInputStream();

			int read = 0;
			final byte[] bytes = new byte[1024];

			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			writer.println("New file " + fileName + " created at " + path);
			LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", 
					new Object[]{fileName, path});
		} catch (FileNotFoundException fne) {
			writer.println("You either did not specify a file to upload or are "
					+ "trying to upload a file to a protected or nonexistent "
					+ "location.");
			writer.println("<br/> ERROR: " + fne.getMessage());

			LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
					new Object[]{fne.getMessage()});
		} finally {
			if (out != null) {
				out.close();
			}
			if (filecontent != null) {
				filecontent.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
	}

	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");
		LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(
						content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
